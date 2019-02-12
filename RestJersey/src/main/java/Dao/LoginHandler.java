package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoginHandler {

public ArrayList<UserVo> getAllUsers(Connection connection) throws Exception {
ArrayList<UserVo> userList = new ArrayList<UserVo>();
try {
// String uname = request.getParameter("uname");
PreparedStatement ps = connection.prepareStatement("SELECT * FROM LoginCredentials");
// ps.setString(1,uname);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
UserVo uservo = new UserVo();
uservo.setUsername(rs.getString("uname"));
uservo.setPassword(rs.getString("password"));
userList.add(uservo);
}
return userList;
} catch (Exception e) {
throw e;
}
}

public String getParticularUser(Connection connection, String username) throws Exception {

	String password = null;
try {
// String uname = request.getParameter("uname");
PreparedStatement ps = connection.prepareStatement("SELECT password FROM LoginCredentials WHERE uname='"+username+"';");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
	password = rs.getString(1);
//	System.out.println("reahed here");

}
return password;
} catch (Exception e) {
throw e;
}
}


}