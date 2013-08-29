package br.iff.campus.pooa20131n.vagasfacil.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@XmlRootElement
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="uid_empresa")
	private String uidEmpresa;

	private String cnpj;

	private String email;

	private String endereco;

	private String nome;

	//bi-directional many-to-one association to Vaga
	@OneToMany(mappedBy="empresa",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Vaga> vagas;

	public Empresa() {
	}

	public String getUidEmpresa() {
		return this.uidEmpresa;
	}

	public void setUidEmpresa(String uidEmpresa) {
		this.uidEmpresa = uidEmpresa;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
		vaga.setEmpresa(this);

		return vaga;
	}

	public Vaga removeVaga(Vaga vaga) {
		getVagas().remove(vaga);
		vaga.setEmpresa(null);

		return vaga;
	}

}