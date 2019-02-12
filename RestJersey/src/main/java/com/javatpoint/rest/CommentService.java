package com.javatpoint.rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Dao.*;

@Path("/CommentsService")
public class CommentService {
		
	@POST
	 @Path("/insertComment")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public String InputCommentToDatabase(@FormParam("uname") String username,
	 @FormParam("comment") String comment) {
		boolean flag=false;
		try {
		DbConnection dbConnect=new DbConnection();
		CommentHandler commentHandle=new CommentHandler();
		flag=commentHandle.CommentToDatabase(dbConnect.getConnection(), username, comment);
		System.out.println(flag);

		} catch(Exception e) {
			
			System.out.println("Comment Service Error found : "+e.getMessage());
			
			}
		if (flag) {
			return "Comment Successful. You can <a href='http://localhost:8080/RestJersey/Profile.html'>add</a> a new comment now.";
		} else {
			return "COmment Failed. Please try again.";
		}
		}

	@GET
	 @Path("/getComment")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.APPLICATION_JSON)
	
	 public String getAllComments(@QueryParam("uname") String username, @QueryParam("byType") String byType) {

		Gson gsonBuilder = new GsonBuilder().create();
		ArrayList<UserComments> userCommentList = new ArrayList<UserComments>();

		if(byType.equalsIgnoreCase("all")) {
		try {
		DbConnection dbConnect=new DbConnection();
		System.out.println("database connectivity done");
		CommentHandler commentHandle=new CommentHandler();
		System.out.println("comment handler done");
		userCommentList=commentHandle.getAllComments(dbConnect.getConnection());
		System.out.println("Comment list return successfully");
		System.out.println(userCommentList);

		} catch(Exception e) {
			System.out.println("Comment Service Error found : "+e.getMessage());
			}
		
		String jsonFromJavaArrayList = gsonBuilder.toJson(userCommentList);
		System.out.println("Printing the size "+userCommentList.size());
		return jsonFromJavaArrayList;
	}
		else if(byType.equalsIgnoreCase("byUser")) {
			try {
				DbConnection dbConnect=new DbConnection();
				System.out.println("database connectivity done");
				CommentHandler commentHandle=new CommentHandler();
				System.out.println("comment handler done");
				userCommentList=commentHandle.getCommentsByUser(dbConnect.getConnection(), username);
				System.out.println("Comment list return successfully");
				System.out.println(userCommentList);

				} catch(Exception e) {
					System.out.println("Comment Service Error found : "+e.getMessage());
					}
				
				String jsonFromJavaArrayList = gsonBuilder.toJson(userCommentList);
				System.out.println("Printing the size "+userCommentList.size());
				return jsonFromJavaArrayList;
	}
		else {
			return "Please make sure you did a selection in comment filter";
		}
	}
	
	
}
