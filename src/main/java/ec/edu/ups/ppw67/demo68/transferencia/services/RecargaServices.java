package ec.edu.ups.ppw67.demo68.transferencia.services;

import ec.edu.ups.ppw67.demo68.transferencia.business.GestionOperadoras;
import ec.edu.ups.ppw67.demo68.transferencia.model.Recarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recarga")
public class RecargaServices {

	@Inject 
	private GestionOperadoras gOperadoras;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response transferir(Recarga recarga) {
	    try {
	        gOperadoras.transferir(recarga);
	        System.out.println("Recarga: " + recarga);
	        ErrorMessage error = new ErrorMessage(1, "ok");
	        return Response.status(Response.Status.CREATED).entity(error).build();
	    } catch (Exception e) {
	        ErrorMessage error = new ErrorMessage(99, e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
	    }
	}
	
}
