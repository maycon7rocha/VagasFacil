package br.iff.campus.pooa20131n.vagasfacil.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the candidato database table.
 * 
 */
@Entity
@XmlRootElement
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uid_candidato")
	private String uidCandidato;

	private String situacao;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Vaga
	@ManyToOne
	@JoinColumn(name="idcandidato")
	private Vaga vaga;

	public Candidato() {
	}

	public String getUidCandidato() {
		return this.uidCandidato;
	}

	public void setUidCandidato(String uidCandidato) {
		this.uidCandidato = uidCandidato;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vaga getVaga() {
		return this.vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

}