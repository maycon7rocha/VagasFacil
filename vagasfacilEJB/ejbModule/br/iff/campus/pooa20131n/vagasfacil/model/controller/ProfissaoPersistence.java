package br.iff.campus.pooa20131n.vagasfacil.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.campus.pooa20131n.vagasfacil.model.entity.Profissao;

@Stateless
@LocalBean
public class ProfissaoPersistence extends AbstractPersistence {
	
	public Profissao inserir(String uidProfissao,  String nome) {
		
		Profissao profissao = new Profissao();
		
		profissao.setUidProfissao(uidProfissao);		
		profissao.setNome(nome);		
		super.insert(profissao);
		
		return profissao;
	}
	public Profissao update(String uidProfissao,  String nome) {

		Profissao profissao = super.find(Profissao.class, uidProfissao);

		profissao.setUidProfissao(uidProfissao);		
		profissao.setNome(nome);
		super.update(profissao);

		return profissao;

	}
	public Profissao find(String uidProfissao) {

		return super.find(Profissao.class, uidProfissao);
	}
	public void delete(String uidProfissao) {
		super.delete(Profissao.class, uidProfissao);
	}
	public List<Profissao> findAll() {
		return super.findAll(Profissao.class);

	}	
	
}
