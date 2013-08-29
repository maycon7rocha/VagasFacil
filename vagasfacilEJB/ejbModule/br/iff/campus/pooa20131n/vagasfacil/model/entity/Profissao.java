package br.iff.campus.pooa20131n.vagasfacil.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the profissao database table.
 * 
 */
@Entity
@XmlRootElement
public class Profissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uid_profissao")
	private String uidProfissao;

	private String nome;

	//bi-directional many-to-one association to Vaga
	@OneToMany(mappedBy="profissao")
	private List<Vaga> vagas;

	public Profissao() {
	}

	public String getUidProfissao() {
		return this.uidProfissao;
	}

	public void setUidProfissao(String uidProfissao) {
		this.uidProfissao = uidProfissao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Vaga> getVagas() {
		return this.vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public Vaga addVaga(Vaga vaga) {
		getVagas().add(vaga);
		vaga.setProfissao(this);

		return vaga;
	}

	public Vaga removeVaga(Vaga vaga) {
		getVagas().remove(vaga);
		vaga.setProfissao(null);

		return vaga;
	}

}