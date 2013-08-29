package br.iff.campos.pooa20131n.vagasfacil.webservices;

import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.iff.campus.pooa20131n.vagasfacil.model.controller.CandidatoPersistencia;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Candidato;

@Path("/Candidato")
public class CandidatoResource {

	private CandidatoPersistencia pcandidato;

	public CandidatoResource() {

	try {
		InitialContext ctx = new InitialContext();
		pcandidato = (CandidatoPersistencia) ctx
		.lookup("java:global/vagasfacilEAR/vagasfacilEJB/CandidatoPersistencia!br.iff.campus.pooa20131n.vagasfacil.model.controller.CandidatoPersistencia");
		} catch (NamingException ne) {
		System.out.println("\n[MyRestService]NamingException: " + ne);
		ne.printStackTrace();
		}
		}

		@GET()
		@Produces("text/plain")
		public String sayHello() {
		Date date = new Date();
		return "Hello World! data agora ++++++++++++++++++++=> "
		+ date.toString();
		}

		@GET
		@Path("/{uid}")
		@Produces(MediaType.APPLICATION_XML)
		public Candidato getCandidato(@PathParam("uid") String uid) {

			return pcandidato.find(uid);
		}


}
