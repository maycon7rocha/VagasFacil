package br.iff.campus.pooa20131n.vagasfacil.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.campus.pooa20131n.vagasfacil.model.entity.Candidato;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Usuario;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Vaga;

@Stateless
@LocalBean
public class CandidatoPersistencia extends AbstractPersistence {

	public Candidato inserir(String uidcandidato, String situacao, Usuario usuario, Vaga vaga) {
	
		Candidato candidato = new Candidato();
	
		candidato.setUidCandidato(uidcandidato);
		candidato.setSituacao(situacao);
		candidato.setUsuario(usuario);
		candidato.setVaga(vaga);		
		super.insert(candidato);
	
		return candidato;
	
	}
	
	public Candidato update(String uidCandidato, String situacao, Usuario usuario, Vaga	vaga)  {
	
		Candidato candidato = super.find(Candidato.class, uidCandidato);
	
		candidato.setUidCandidato(uidCandidato);
		candidato.setSituacao(situacao);
		candidato.setUsuario(usuario);
		candidato.setVaga(vaga);
		
		super.update(candidato);
	
		return candidato;
	
		}
	
		public Candidato find(String uidCandidato) {
		
		return super.find(Candidato.class, uidCandidato);
		}
		
		public void delete(String uidCandidato) {
			super.delete(Candidato.class, uidCandidato);
		}
		
		public List<Candidato> findAll() {
			return super.findAll(Candidato.class);
		
	}

}