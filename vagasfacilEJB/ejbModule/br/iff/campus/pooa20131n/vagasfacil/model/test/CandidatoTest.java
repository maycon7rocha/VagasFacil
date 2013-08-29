package br.iff.campus.pooa20131n.vagasfacil.model.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.iff.campus.pooa20131n.vagasfacil.model.controller.CandidatoPersistencia;
import br.iff.campus.pooa20131n.vagasfacil.model.controller.EmpresaPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.controller.ProfissaoPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.controller.UsuarioPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.controller.VagaPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Candidato;



public class CandidatoTest {

	private CandidatoPersistencia pprop = new CandidatoPersistencia();
	private UsuarioPersistence usuper = new UsuarioPersistence();
	private VagaPersistence vagper = new VagaPersistence();
	private EmpresaPersistence empper = new EmpresaPersistence();
	private ProfissaoPersistence proper = new ProfissaoPersistence();
	private String uidCandidato = "001";


	@Test
	public void testInserir() {
		empper.inserir(uidCandidato, "nome", "endereco", "cnpj", "email");
		proper.inserir(uidCandidato,"nome");		
		usuper.inserir(uidCandidato, "nome", "telefone", "cpf", "endereco");		
		vagper.inserir(uidCandidato, 1234, 1234, "requisito", proper.find(uidCandidato), empper.find(uidCandidato));		
		Candidato prop = pprop.inserir(uidCandidato, "situacao", usuper.find(uidCandidato), vagper.find(uidCandidato));
			assertEquals(prop.getUidCandidato(), uidCandidato);
	}

	@Test
	public void testUpdate() {
		Candidato prop = pprop.update(uidCandidato, "situacao", usuper.find(uidCandidato), vagper.find(uidCandidato));
		assertEquals(prop.getSituacao(), "situacao");
	}

	@Test
	public void testFind() {
		Candidato prop = pprop.find(uidCandidato);
		assertEquals(prop.getSituacao(), "situacao");
	}
	

	@Test
	public void testDelete() {
		pprop.delete(uidCandidato);
		usuper.delete(uidCandidato);
		vagper.delete(uidCandidato);
		empper.delete(uidCandidato);
		proper.delete(uidCandidato);
		
		
	}
	

	@Test
	public void testFindAll() {
		List<Candidato> lprpop = pprop.findAll();
		for (Candidato prop : lprpop) {
			assertEquals(prop.getSituacao(), "situacao");
		}
	}

}
