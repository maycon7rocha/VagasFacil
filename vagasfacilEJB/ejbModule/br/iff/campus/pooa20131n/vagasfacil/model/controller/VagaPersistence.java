package br.iff.campus.pooa20131n.vagasfacil.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.campus.pooa20131n.vagasfacil.model.entity.Empresa;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Profissao;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Vaga;


@Stateless
@LocalBean
public class VagaPersistence  extends AbstractPersistence {

	public Vaga inserir(String uidVaga, double salario, int quantidade,
		String requisito,Profissao profissao, Empresa empresa){

		Vaga vaga = new Vaga();
	
		vaga.setUidVaga(uidVaga);
		vaga.setSalario(salario);
		vaga.setQuantidade(quantidade);
		vaga.setRequisito(requisito);
		vaga.setEmpresa(empresa);
		vaga.setProfissao(profissao);
	
		super.insert(vaga);
	
		return vaga;
	}
	public Vaga update(String uidVaga, double salario, int quantidade,
			String requisito, Profissao profissao, Empresa empresa) {
	
		Vaga vaga = super.find(Vaga.class, uidVaga);
	
		vaga.setUidVaga(uidVaga);
		vaga.setSalario(salario);
		vaga.setQuantidade(quantidade);
		vaga.setRequisito(requisito);
		vaga.setEmpresa(empresa);	
		vaga.setProfissao(profissao);
		super.update(vaga);
	
		return vaga;
	}
	public Vaga find(String uidVaga) {
	
		return super.find(Vaga.class, uidVaga);
	}
	
	public void delete(String uidVaga) {
		super.delete(Vaga.class, uidVaga);
	}
	
	public List<Vaga> findAll() {
		return super.findAll(Vaga.class);
	
	}


}
