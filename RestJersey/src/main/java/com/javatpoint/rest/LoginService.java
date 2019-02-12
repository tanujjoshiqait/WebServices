package com.javatpoint.rest;

import java.net.URISyntaxException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Dao.*;
 
@Path("/WebService")
public class LoginService {
 
@POST
 @Path("/login")
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 public String login(@FormParam("uname") String username,
 @FormParam("pass") String password) {
	
	if( ValidityCheck(username, password)) {
		try {
            java.net.URI location = new java.net.URI("../Profile.html");
            throw new WebApplicationException(Response.temporaryRedirect(location).build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        	}
		return "Valid user";
	}
	else {
		
		return "Not a valid user";
	}
 
}
 
public boolean ValidityCheck(String username,String password)
 {
 String tempPassword = null;
 boolean flag=false;
 try 
 {
 DbConnection dbConnect=new DbConnection();
 LoginHandler loginHand=new LoginHandler();
 tempPassword = loginHand.getParticularUser(dbConnect.getConnection(), username);
// System.out.println(tempPassword);

 if(tempPassword.equals(password)) {
	 flag=true;
 }
 else {
	 flag=false;
 }
 
 } catch (Exception e){
 System.out.println(e);
 }
 return flag;
 }

}