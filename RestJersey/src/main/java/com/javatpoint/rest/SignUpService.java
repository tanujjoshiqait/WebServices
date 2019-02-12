package com.javatpoint.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import Dao.*;


@Path("/SignUpService")
public class SignUpService {
	
@POST
 @Path("/SignUp")
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 public String login(@FormParam("uname") String username,
 @FormParam("pass") String password, @FormParam("name") String name, @FormParam("address") String address,
 @FormParam("gender") String gender, @FormParam("mob") int mob, @FormParam("lang") String lang) {
	boolean flag=false;
	try {
	String[] data= {username,name, address,gender, lang};
	DbConnection dbConnect=new DbConnection();
	SignUpHandler signUpHandle=new SignUpHandler();
	flag=signUpHandle.InserDataToDatabase(dbConnect.getConnection(), data, mob , password);
	System.out.println(flag);

	} catch(Exception e) {
		
		System.out.println("Sign Up Service Error found : "+e.getMessage());
		
		}
	if (flag) {
		return "SignUp Successful. You can <a href=\"http://localhost:8080/RestJersey/AccountLogin.html\">Login Now</a> with your credentials.";
	} else {
		return "SignUp Failed. Please try again.";
	}
	}
}