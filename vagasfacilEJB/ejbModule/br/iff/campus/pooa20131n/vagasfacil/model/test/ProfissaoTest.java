package br.iff.campus.pooa20131n.vagasfacil.model.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.iff.campus.pooa20131n.vagasfacil.model.controller.ProfissaoPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Profissao;

public class ProfissaoTest {
	
	private ProfissaoPersistence pprop = new ProfissaoPersistence();
	private String uidProfissao = "1";

	@Test
	public void testInserir() {
		Profissao prop = pprop.inserir(uidProfissao,"nome");
				assertEquals(prop.getUidProfissao(), uidProfissao);
			
	}
	@Test
	public void testUpdate() {
		Profissao prop = pprop.update(uidProfissao,"nome");
		assertEquals(prop.getNome(), "nome");
	}
	
	@Test
	public void testFind() {
		Profissao prop = pprop.find(uidProfissao);
		assertEquals(prop.getNome(), "nome");
	}
	

	@Test
	public void testDelete() {
		pprop.delete(uidProfissao);
	}
	

	@Test
	public void testFindAll() {
		List<Profissao> lprpop = pprop.findAll();
		for (Profissao prop : lprpop) {
			assertEquals(prop.getNome(), "nome");
		}

	}

}
