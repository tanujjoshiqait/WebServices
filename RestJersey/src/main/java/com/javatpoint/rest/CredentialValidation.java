package com.javatpoint.rest;
import java.net.URISyntaxException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;




@Path("/form")
public class CredentialValidation {
	
	    @POST
	    @Path("/validation")
	    @Produces("text/html")
	    public Response getResultByPassingValue(
	                    @FormParam("uname") String uname,
	                    @FormParam("Key") String password) {
	        
	        String output = "<font face='verdana' size='2'>" +
	                "Web Service has added your Customer information with Name - <u>"+uname;
	        
	        try {
	            java.net.URI location = new java.net.URI("../Profile.html?msg=A_User_Added");
	            throw new WebApplicationException(Response.temporaryRedirect(location).build());
	        } catch (URISyntaxException e) {
	            e.printStackTrace();
	            
	        }
	        return Response.status(200).entity(output).build();

	 
	    }
	}
	
