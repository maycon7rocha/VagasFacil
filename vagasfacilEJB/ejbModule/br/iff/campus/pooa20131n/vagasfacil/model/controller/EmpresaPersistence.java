package br.iff.campus.pooa20131n.vagasfacil.model.controller;

import br.iff.campus.pooa20131n.vagasfacil.model.entity.Empresa;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EmpresaPersistence extends AbstractPersistence {
	
	public Empresa inserir(String uidEmpresa,  String nome, 
			String endereco, String cnpj,  String email) {
		Empresa empresa = new Empresa();
		
		empresa.setUidEmpresa(uidEmpresa);		
		empresa.setNome(nome);
		empresa.setEndereco(endereco);
		empresa.setCnpj(cnpj);
		empresa.setEmail(email);
		super.insert(empresa);
		
		return empresa;
	}
	public Empresa update(String uidEmpresa,  String nome, 
			String endereco, String cnpj,  String email) {

		Empresa empresa = super.find(Empresa.class, uidEmpresa);

		empresa.setUidEmpresa(uidEmpresa);		
		empresa.setNome(nome);
		empresa.setEndereco(endereco);
		empresa.setCnpj(cnpj);
		empresa.setEmail(email);
		
		super.update(empresa);

		return empresa;

	}
	public Empresa find(String uidEmpresa) {

		return super.find(Empresa.class, uidEmpresa);
	}

	public void delete(String uid) {
		super.delete(Empresa.class, uid);
	}
	public List<Empresa> findAll() {
		return super.findAll(Empresa.class);

	}

}