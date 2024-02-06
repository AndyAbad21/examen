package ec.edu.ups.ppw67.demo68.transferencia.services;

import java.util.List;

import ec.edu.ups.ppw67.demo68.transferencia.business.GestionTelefonos;
import ec.edu.ups.ppw67.demo68.transferencia.model.Telefono;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("telefonos")
public class TelefonoServices {
	
	@Inject
	private GestionTelefonos gTelefonos;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)//Obtiene los parametros de las consultas y los envia
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Telefono telefono) {
		try{
			gTelefonos.guardartelefonos(telefono);
			ErrorMessage error = new ErrorMessage(1, "ok");
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Telefono telefono) {
		try{
			gTelefonos.actualizartelefono(telefono);
			return Response.ok(telefono).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response leer(@QueryParam("numero") String numero) {
		try{
			System.out.println("numero " + numero);
			Telefono cli = gTelefonos.gettelefonoPorNumero(numero);
			return Response.ok(cli).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Telefono no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getTelefonos(){
		List<Telefono> telefono = gTelefonos.gettelefonos();
		if(telefono.size()>0)
			return Response.ok(telefono).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Telefonos");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

}