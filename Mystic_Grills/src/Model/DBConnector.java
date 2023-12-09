package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/mystic-grills";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String HOST = "localhost:3306";
    private static final String DATABASE = "mystic-grills";
    private static final String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
    
    private static Connection connection;
    private Statement statement;
    private static DBConnector DB_connector;
    public ResultSet result_set;
    
    public void ExecuteUpdate(String query) {
    	try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public ResultSet ExecuteQuery(String query) {
    	try {
			result_set = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result_set;
    }
    
    public PreparedStatement PrepareStatement(String query) {
    	PreparedStatement prepared_statement = null;
    	
    	try {
			prepared_statement = connection.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return prepared_statement;
    }
    
    public DBConnector(){
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
			statement = connection.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static DBConnector getInstance() {
    	if(DB_connector == null) {
    		DB_connector = new DBConnector();
    	}
    	return DB_connector;
    	
    }
}
