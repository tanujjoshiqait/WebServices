package Dao;
import java.sql.*;
import java.util.ArrayList;

public class CommentHandler {


	public boolean CommentToDatabase(Connection dbConnect, String uname, String comment) throws Exception {

		try {
			PreparedStatement ps = dbConnect.prepareStatement("INSERT INTO UserComments values ( '"
		+uname+"', '"+comment+"');");
			System.out.println(ps);
			ps.executeUpdate();
						
			} catch (Exception e) {

				System.out.println("Comment Handler Error found : "+e.getMessage());
				throw e;
			}
		return true;
		}
	
	public ArrayList<UserComments> getAllComments(Connection connection) throws Exception {
		ArrayList<UserComments> userCommentList = new ArrayList<UserComments>();
		try {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM UserComments");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			UserComments usercomment = new UserComments();
			usercomment.setUserName(rs.getString("Username"));
			usercomment.setComments(rs.getString("Comments"));
			userCommentList.add(usercomment);
		}
		} catch (Exception e) {
			System.out.println("Inside comment handler class : "+e);

		throw e;
		}
		return userCommentList;

	}
	
	
	public ArrayList<UserComments> getCommentsByUser(Connection connection, String uname) throws Exception {
		ArrayList<UserComments> userCommentList = new ArrayList<UserComments>();
		try {
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM UserComments where Username='"+uname+"';");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			UserComments usercomment = new UserComments();
			usercomment.setUserName(rs.getString("Username"));
			usercomment.setComments(rs.getString("Comments"));
			userCommentList.add(usercomment);
		}
		} catch (Exception e) {
			System.out.println("Inside comment handler class : "+e);

		throw e;
		}
		return userCommentList;

	}
	
}


