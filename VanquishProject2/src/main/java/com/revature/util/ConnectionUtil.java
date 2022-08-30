package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	//A singleton design pattern only allows one instance of a class to exist in memory at a time.	
	private static Connection connection;		
	    
	public static Connection getConnection() throws SQLException{	    	
	    if(connection!=null && !connection.isClosed()) {
	    	return connection;
	    }else{	    		
	    	//For many frameworks, or in cases where there are multiple SQL drivers, you will need to register which
	    	//driver you are using for the connection interface. The Class.forName method will allow you to do this
	    	//This step is often unnecessary for simple projects but it is considered best practice.	    		
	    	try {
	    		Class.forName("org.postgresql.Driver");
	    	}catch (ClassNotFoundException e) {
	    			e.printStackTrace();
	    	}	    	
	    	 String url = "jdbc:postgresql://assoc220725db.cekyyol8wngg.us-east-2.rds.amazonaws.com:5432/postgres";
	    	 String user = "postgres"; //It is possible to hide raw credentials by using ENV variable;
	    	 String password = "bleedorange"; //You can access those variables with System.getenv("var-name)
	    	 connection = DriverManager.getConnection(url, user, password);	    	 
	    	 return connection;
	    }	    	
	}	
}
