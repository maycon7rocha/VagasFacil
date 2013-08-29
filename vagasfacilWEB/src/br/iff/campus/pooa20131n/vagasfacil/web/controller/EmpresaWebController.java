package br.iff.campus.pooa20131n.vagasfacil.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.iff.campus.pooa20131n.vagasfacil.model.controller.EmpresaPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Empresa;

@ManagedBean(name = "empresaweb")
@RequestScoped
public class EmpresaWebController {

	@EJB(lookup = "java:app/vagasfacilEJB/EmpresaPersistence")
	private EmpresaPersistence jempresa;
	
	private Empresa empresa;

	public Empresa getEmpresa() {
		if (empresa == null) {
			empresa = new Empresa();
		}
		return empresa;
	}

	public List<Empresa> getAllEmpresa() {
		return jempresa.findAll();
	}

	public String salva() {

		if (jempresa.find(empresa.getUidEmpresa()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Proprietario Ja Cadastrado"));

		} else {
			jempresa.insert(empresa);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		return "ok";
	}
	
	public String delete() {

		if (jempresa.find(empresa.getUidEmpresa()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Empresa não Existe"));

		} else {
			jempresa.delete(empresa.getUidEmpresa());

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Empresa Excluido!"));
		}
		return "ok";
	}
	
	public String update() {

		if (jempresa.find(empresa.getUidEmpresa()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Empresa não Existe"));

		} else {
			jempresa.update(empresa);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		return "ok";
	}

	public String busca() {

		empresa = jempresa.find(empresa.getUidEmpresa());
		if (empresa == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Empresa não Existe"));

		} else {
			jempresa.update(empresa);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage(""));
		}
		return "ok";
	}

	public EmpresaWebController() {

	}

}