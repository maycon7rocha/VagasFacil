package br.iff.campos.pooa20131n.vagasfacil.webservices;

import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.iff.campus.pooa20131n.vagasfacil.model.controller.EmpresaPersistence;
import br.iff.campus.pooa20131n.vagasfacil.model.entity.Empresa;


@Path("/empresa")
public class EmpresaResourse {

	private EmpresaPersistence pempresa;

	public EmpresaResourse() {
		try {
			InitialContext ctx = new InitialContext();
			pempresa = (EmpresaPersistence) ctx
					.lookup("java:global/vagasfacilEAR/vagasfacilEJB/EmpresaPersistence!br.iff.campus.pooa20131n.vagasfacil.model.controller.EmpresaPersistence");
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
	public Empresa getEmpresa(@PathParam("uid") String uid) {
		
		return  pempresa.find(uid);
	}
	
	@DELETE
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteEmpresa(@PathParam("uid") String uid) {
		
		pempresa.delete(uid);
		return  Response.ok("").build();
	}
	
	@POST
	@Path("/{uid},{nome},{endereco},{cnpj},{email}")
	@Produces(MediaType.APPLICATION_XML)
	public Response addEmpresa(@PathParam("uid") String uid,@PathParam("nome") String nome,@PathParam("endereco") String endereco,@PathParam("email") String email) {
		
		pempresa.inserir(uid, "nome", "endereco", "cnpj", "email");
		return  Response.ok("").build();
	}
	@PUT
	@Path("/{uid},{nome},{endereco},{cnpj},{email}")
	@Produces(MediaType.APPLICATION_XML)
public Response updateEmpresa(@PathParam("uid") String uid,@PathParam("nome") String nome,@PathParam("endereco") String endereco,@PathParam("email") String email) {
		
		pempresa.update(uid, "nome", "endereco", "cnpj", "email");
		return  Response.ok("").build();
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Empresa> getAll() {

		return pempresa.findAll();
	}
}