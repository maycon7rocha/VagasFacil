package br.iff.campus.pooa20131n.vagasfacil.model.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.iff.campus.pooa20131n.vagasfacil.model.controller.UsuarioPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Usuario;

public class UsuarioTest {
	
	private UsuarioPersistence pprop = new UsuarioPersistence();
	private String uidUsuario = "001";

	@Test
	public void testInserir() {
		Usuario prop = pprop.inserir(uidUsuario, "nome", "1234-1234",
			"1234567-89", "endereco");
		assertEquals(prop.getUidUsuario(), uidUsuario);
	}

	@Test
	public void testUpdate() {
		Usuario prop = pprop.update(uidUsuario, "nome", "1234-1234",
				"1234567-89", "endereco");
	assertEquals(prop.getNome(), "nome");
	}

	@Test
	public void testFind() {
		Usuario prop = pprop.find(uidUsuario);
	assertEquals(prop.getNome(), "nome");

	}

	@Test
	public void testFindAll() {
		List<Usuario> lprpop = pprop.findAll();
		for (Usuario prop : lprpop) {
			assertEquals(prop.getNome(), "nome");
		}
	}

	@Test
	public void testDelete() {
		pprop.delete(uidUsuario);


	}

	}