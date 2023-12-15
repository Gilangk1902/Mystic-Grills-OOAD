package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import Main.Session;

public class User {
    private int id;
    private String role, name, email, password;
    public class ROLE{
    	public static final String CUSTOMER = "Customer";
    	public static final String ADMIN = "Admin";
    	public static final String CHEF = "Chef";
    }
    
    public User() {
    	
    }
    
    public User(String _username, String _email, String _password){
        id = GenerateId();
        role = ROLE.CUSTOMER;
        name = _username;
        email = _email;
        password = _password;
    }
    
    public User(int _id, String _role, String _username, String _email, String _password) {
    	id = _id;
    	role = _role;
    	name = _username;
    	email = _email;
    	password = _password;
    }
    
    public static ArrayList<User> getAll(){
    	DBConnector db_connector = DBConnector.getInstance();
    	String query = "SELECT * FROM users";
    	ArrayList<User> users = new ArrayList<>();
    	
    	PreparedStatement prepared_statement = db_connector.PrepareStatement(query);
    	try {
			ResultSet result_set = prepared_statement.executeQuery();
			while(result_set.next()) {
				int _id = result_set.getInt("id");
				String _username = result_set.getString("name");
				String _password = result_set.getString("password");
				String _role = result_set.getString("role");
				String _email = result_set.getString("email");
				
				User user = new User(
						_id, _role, _username, _email, _password
					);
				
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return users;
    }
    
    public static User getUser(String username, String password) {
    	DBConnector db_connector = DBConnector.getInstance();
    	String query = "SELECT * FROM users WHERE name = ? AND password = ?";
    	User _user = null;
    	
    	PreparedStatement prepared_statement = db_connector.PrepareStatement(query);
    	try {
			prepared_statement.setString(1, username);
			prepared_statement.setString(2, password);
			
			ResultSet result_set = prepared_statement.executeQuery();
			if(result_set.next()) {
				int _id = result_set.getInt("id");
				String _username = result_set.getString("name");
				String _password = result_set.getString("password");
				String _role = result_set.getString("role");
				String _email = result_set.getString("email");
				
				_user = new User(
							_id, _role, _username, _email, _password
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			_user = null;
		}
    	
    	return _user;
    }

    public static void Register(User user){
    	DBConnector db_connector = DBConnector.getInstance();
    	String query = "INSERT INTO users (id, role, name, email, password) VALUES (?, ?, ?, ?, ?)";
    	
    	PreparedStatement prepared_statement = db_connector.getInstance().PrepareStatement(query);
    	try {
			prepared_statement.setInt(1, user.getId());
			prepared_statement.setString(2, user.getRole());
	        prepared_statement.setString(3, user.getName());
	        prepared_statement.setString(4, user.getEmail());
	        prepared_statement.setString(5, user.getPassword());
	        prepared_statement.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    private int GenerateId(){
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
