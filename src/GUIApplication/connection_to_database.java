package GUIApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connection_to_database {

	String dbUrl = "jdbc:mysql://db4free.net:3306/guiproject?allowPublickeyRetrieval=true&useSSL=false";
    String user="database" 	; //write your database name
    String pwd= "password"; // password name
    Connection myConn=null;
    Statement mySmt=null;
    Connection getConnect() throws SQLException
    {
    	myConn=DriverManager.getConnection(dbUrl,user,pwd);
    	mySmt=myConn.createStatement();
    	return myConn;
    	
    }
    


}
