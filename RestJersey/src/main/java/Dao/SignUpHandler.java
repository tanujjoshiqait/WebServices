package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;


public class SignUpHandler {

public boolean InserDataToDatabase(Connection dbConnect, String[] data, int mobileNumber, String password) throws Exception {

	try {
		PreparedStatement ps = dbConnect.prepareStatement("INSERT INTO CustomerInfo values ( '"
	+data[0]+"', '"+data[1]+"', '"+data[2]+"', "+mobileNumber+", '"+data[3]+"', '"+data[4]+"');");
		System.out.println(ps);
		ps.executeUpdate();
		
		ps=dbConnect.prepareStatement("INSERT INTO LoginCredentials values ( '"+data[0]+"', '"+password+"');"); 
		ps.executeUpdate();
		
		} catch (Exception e) {

			System.out.println("Sign Up Handler Error found : "+e.getMessage());
			throw e;
		}
	return true;
	}
}


