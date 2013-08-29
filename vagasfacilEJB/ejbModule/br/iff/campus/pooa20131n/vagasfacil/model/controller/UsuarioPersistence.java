package br.iff.campus.pooa20131n.vagasfacil.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.campus.pooa20131n.vagasfacil.model.entity.Usuario;


@Stateless
@LocalBean
public class UsuarioPersistence extends AbstractPersistence {


public Usuario inserir(String uidUsuario, String nome, String telefone,
 String cpf, String endereco) {

	Usuario usuario = new Usuario();

	usuario.setUidUsuario(uidUsuario);
	usuario.setNome(nome);
	usuario.setTelefone(telefone);
	usuario.setCpf(cpf);	
	usuario.setEndereco(endereco);
	
super.insert(usuario);

return usuario;

}

public Usuario update(String uidUsuario, String nome, String telefone,
		 String cpf, String endereco)  {

	Usuario usuario = super.find(Usuario.class, uidUsuario);

	usuario.setUidUsuario(uidUsuario);
	usuario.setNome(nome);
	usuario.setTelefone(telefone);
	usuario.setCpf(cpf);	
	usuario.setEndereco(endereco);
	
	super.update(usuario);

	return usuario;

	}

	public Usuario find(String uidUsuario) {
	
	return super.find(Usuario.class, uidUsuario);
	}
	
	public void delete(String uidUsuario) {
		super.delete(Usuario.class, uidUsuario);
	}
	
	public List<Usuario> findAll() {
		return super.findAll(Usuario.class);
	
	}

}