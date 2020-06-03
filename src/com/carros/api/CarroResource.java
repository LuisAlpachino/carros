package com.carros.api;

import java.io.IOException;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import com.carros.dto.carrosDTO;
import com.carros.factory.Fabrica;
import com.carros.interfaces.Icarros;
import com.google.gson.Gson;

@Path("carros")
@Provider
public class CarroResource implements ContainerResponseFilter  {
	
	@Context
	private UriInfo context;
	
	//private static String SUCCESS="success";
	
	public CarroResource() {
		
	}
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		try {
			Icarros icarros =(Icarros ) Fabrica.getInstancia("CARROS");
			Collection<carrosDTO> users = icarros.getAll();
			String json = new Gson().toJson(users);
			
			return Response.ok(json, MediaType.APPLICATION_JSON)
//					.header( "Access-Control-Allow-Origin", "http://localhost:8100/")
//					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
					.build();
		} catch(Exception e) {
			return Response.status(Response.Status.SEE_OTHER).entity("Error:" + e.toString()).build();
			
		}
	}
	
	
	
	
//	private String json(String status) {
//		String json = "";
//		JSONObject obj = new JSONObject();
//		obj.put("status", status);
//		json =""+obj;
//		return json;
//	}
	

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().add( "Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");	
	}

}
