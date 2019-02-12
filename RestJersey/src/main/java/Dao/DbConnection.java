package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

public Connection getConnection() throws Exception
{
try
{
String connectionURL = "jdbc:mysql://localhost:3306/UserDetails";
Connection connection = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "upes@123");
return connection;
}
catch (SQLException e)
{
throw e;
}
catch (Exception e)
{System.out.println("Database Connection class error :"+e.getMessage());
throw e;
}
}

}