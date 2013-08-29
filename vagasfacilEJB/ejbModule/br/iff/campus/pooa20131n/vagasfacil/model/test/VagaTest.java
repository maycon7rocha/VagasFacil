package br.iff.campus.pooa20131n.vagasfacil.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.iff.campus.pooa20131n.vagasfacil.model.controller.EmpresaPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.controller.ProfissaoPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.controller.VagaPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Vaga;

public class VagaTest {
	
	
	private ProfissaoPersistence proper = new ProfissaoPersistence();
	private EmpresaPersistence empper = new EmpresaPersistence();
	private VagaPersistence pprop = new VagaPersistence();
	private String uid = "002";


	@Test
	public void testInserir() {
		proper.inserir(uid, "nome");
		empper.inserir(uid, "nome", "endereco", "cnpj", "email");
		Vaga prop = pprop.inserir(uid, 1234, 1234,
				"requisito", proper.find(uid),empper.find(uid));
			assertEquals(prop.getUidVaga(), uid);			
					
	}
	

	@Test
	public void testUpdate() {
		
		Vaga prop = pprop.update(uid, 1234, 789,
				"requisito", proper.find(uid),empper.find(uid));
			assertEquals(prop.getRequisito(), "requisito");		
	}
		
	@Test
	public void testFind() {
		Vaga prop = pprop.find(uid);
		assertEquals(prop.getRequisito(), "requisito");
	}
	

	@Test
	public void testDelete() {
		pprop.delete(uid);
		proper.delete(uid);
		empper.delete(uid);
		
	}
	

	@Test
	public void testFindAll() {
		List<Vaga> lprpop = pprop.findAll();
		for (Vaga prop : lprpop) {
			assertEquals(prop.getRequisito(), "requisito");
		}

	}
}
