package br.iff.campus.pooa20131n.vagasfacil.model.test;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.Test;

import br.iff.campus.pooa20131n.vagasfacil.model.controller.EmpresaPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Empresa;

public class EmpresaTest {
	
	private EmpresaPersistence pprop = new EmpresaPersistence();
	private String uidEmpresa = "001";

	@Test
	public void testInserir() {
		Empresa prop = pprop.inserir(uidEmpresa, "nome", "endereco", "cnpj", "email");
			assertEquals(prop.getUidEmpresa(), uidEmpresa);
	}

	@Test
	public void testUpdate() {
		Empresa prop = pprop.update(uidEmpresa, "nome",
				"endereco","cnpj", "email");
			assertEquals(prop.getNome(), "nome");
			}

	@Test
	public void testFind() {
		Empresa prop = pprop.find(uidEmpresa);
		assertEquals(prop.getNome(), "nome");
	}

	@Test
	public void testDelete() {
		pprop.delete(uidEmpresa);
	}

	@Test
	public void testFindAll() {
		List<Empresa> lprpop = pprop.findAll();
		for (Empresa prop : lprpop) {
		assertEquals(prop.getNome(), "nome");
		}
	}

}
