package br.iff.campus.pooa20131n.vagasfacil.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the vaga database table.
 * 
 */
@Entity
@XmlRootElement
public class Vaga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uid_vaga")
	private String uidVaga;

	private Integer quantidade;

	private String requisito;

	private double salario;

	//bi-directional many-to-one association to Candidato
	@OneToMany(mappedBy="vaga")
	private List<Candidato> candidatos;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="idempresa")
	private Empresa empresa;

	//bi-directional many-to-one association to Profissao
	@ManyToOne
	@JoinColumn(name="idprofissao")
	private Profissao profissao;

	public Vaga() {
	}

	public String getUidVaga() {
		return this.uidVaga;
	}

	public void setUidVaga(String uidVaga) {
		this.uidVaga = uidVaga;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getRequisito() {
		return this.requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public List<Candidato> getCandidatos() {
		return this.candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public Candidato addCandidato(Candidato candidato) {
		getCandidatos().add(candidato);
		candidato.setVaga(this);

		return candidato;
	}

	public Candidato removeCandidato(Candidato candidato) {
		getCandidatos().remove(candidato);
		candidato.setVaga(null);

		return candidato;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Profissao getProfissao() {
		return this.profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

}