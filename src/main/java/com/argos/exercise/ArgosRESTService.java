package com.argos.exercise;

import java.io.InputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/")
public class ArgosRESTService {
	@GET
	@Path("/argosService")
	@Produces(MediaType.TEXT_PLAIN)
	public Response argosRESTService() {
		return Response.status(200).entity(ExtractData.getHukdData()).build();
	}
 
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public Response testRESTService(InputStream incomingData) {
		String result = "Argos RESTful Service has been Successfully started.";
		return Response.status(200).entity(result).build();
	}
}