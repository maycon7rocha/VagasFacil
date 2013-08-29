package br.iff.campus.pooa20131n.vagasfacil.web.controller;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.iff.campus.pooa20131n.vagasfacil.model.controller.UsuarioPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Usuario;

@ManagedBean(name = "usuarioweb")
@RequestScoped
public class UsusarioWebController {
	
	@EJB(lookup = "java:app/vagasfacilEJB/UsuarioPersistence")
	private UsuarioPersistence jusuario;

	private Usuario usuario;

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public List<Usuario> getAllProprietario() {
		return jusuario.findAll();
	}

	public String salva() {

		if (jusuario.find(usuario.getUidUsuario()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Proprietario Ja Cadastrado"));

		} else {
			jusuario.insert(usuario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		return "ok";
	}
	
	public String delete() {

		if (jusuario.find(usuario.getUidUsuario()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario não Existe"));

		} else {
			jusuario.delete(usuario.getUidUsuario());

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario Excluido!"));
		}
		return "ok";
	}
	
	public String update() {

		if (jusuario.find(usuario.getUidUsuario()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario não Existe"));

		} else {
			jusuario.update(usuario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		return "ok";
	}

	public String busca() {

		usuario = jusuario.find(usuario.getUidUsuario());
		if (usuario == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario não Existe"));

		} else {
			jusuario.update(usuario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage(""));
		}
		return "ok";
	}

	public UsusarioWebController() {

	}
}
