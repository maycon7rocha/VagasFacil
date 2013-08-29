package br.iff.campus.pooa20131n.vagasfacil.web.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.iff.campus.pooa20131n.vagasfacil.model.controller.ProfissaoPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Profissao;


@ManagedBean(name = "profissaoweb")
@RequestScoped
public class ProfissaoWebController {

	@EJB(lookup = "java:app/vagasfacilEJB/ProfissaoPersistence")
	private ProfissaoPersistence jprofissao;

	private Profissao profissao;

	public Profissao getProfissao() {
		if (profissao == null) {
			profissao = new Profissao();
		}
		return profissao;
	}

	public List<Profissao> getAllProfissao() {
		return jprofissao.findAll();
	}

	public String salva() {

		if (jprofissao.find(profissao.getUidProfissao()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Proprietário Já Cadastrado"));

		} else {
			jprofissao.insert(profissao);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		return "ok";
	}
	
	public String delete() {

		if (jprofissao.find(profissao.getUidProfissao()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Profissao não Existe"));

		} else {
			jprofissao.delete(profissao.getUidProfissao());

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Profissao Excluido com Sucesso!"));
		}
		return "ok";
	}
	
	public String update() {

		if (jprofissao.find(profissao.getUidProfissao()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Profissao não Existe"));

		} else {
			jprofissao.update(profissao);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		return "ok";
	}

	public String busca() {

		profissao = jprofissao.find(profissao.getUidProfissao());
		if (profissao == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Profissao não Existe"));

		} else {
			jprofissao.update(profissao);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage(""));
		}
		return "ok";
	}

	public ProfissaoWebController() {

	}

}