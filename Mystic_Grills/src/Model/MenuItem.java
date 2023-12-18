package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class MenuItem {
	private int id;
	private String name;
	private String description;
	private int price;
	
	public MenuItem() {}
	
	public MenuItem(int _id, String _name, String _description, int _price) {
		name = _name;
		description = _description;
		price = _price;
		id = _id;
	}
	
	public MenuItem(String _name, String _description, int _price) {
		name = _name;
		description = _description;
		price = _price;
		id = GenerateId();
	}
	
	public static int getPrice(int id) {
		DBConnector db_connector = DBConnector.getInstance();
		String query = "SELECT * FROM menuitems WHERE id = ?";
		PreparedStatement prepared_statement = db_connector.PrepareStatement(query);
		int price = 0;
		
		ResultSet result_set;
		try {
			prepared_statement.setInt(1, id);
			result_set = prepared_statement.executeQuery();
			if(result_set.next()) {
				price = result_set.getBigDecimal("price").intValue();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return price;
	}
	
	public static void AddNew(MenuItem menuitem) {
		DBConnector db_connector = DBConnector.getInstance();
    	String query = "INSERT INTO menuitems (id, name, description, price) VALUES (?, ?, ?, ?)";
    	
    	PreparedStatement prepared_statement = db_connector.getInstance().PrepareStatement(query);
    	try {
			prepared_statement.setInt(1, menuitem.getId());
	        prepared_statement.setString(2, menuitem.getName());
	        prepared_statement.setString(3, menuitem.getDescription());
	        prepared_statement.setInt(4, menuitem.getPrice());
	        prepared_statement.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Update(MenuItem updated_menuItem) {
	    DBConnector db_connector = DBConnector.getInstance();
	    String query = "UPDATE menuitems SET name = ?, description = ?, price = ? WHERE id = ?";
	    PreparedStatement prepared_statement = db_connector.PrepareStatement(query);

	    try {
	        prepared_statement.setString(1, updated_menuItem.getName());
	        prepared_statement.setString(2, updated_menuItem.getDescription());
	        prepared_statement.setInt(3, updated_menuItem.getPrice());
	        prepared_statement.setInt(4, updated_menuItem.getId());

	        prepared_statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void Delete(int menuItemId) {
	    DBConnector db_connector = DBConnector.getInstance();
	    String query = "DELETE FROM menuitems WHERE id = ?";
	    PreparedStatement prepared_statement = db_connector.PrepareStatement(query);

	    try {
	        prepared_statement.setInt(1, menuItemId);

	        prepared_statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static MenuItem getById(int id) {
		DBConnector db_connector = DBConnector.getInstance();
		String query = "SELECT * FROM menuitems WHERE id = ?";
		PreparedStatement prepared_statement = db_connector.PrepareStatement(query);
		
		MenuItem menu_item = null;
		ResultSet result_set;
		try {
			prepared_statement.setInt(1, id);
			result_set = prepared_statement.executeQuery();
			if(result_set.next()) {
				int price = result_set.getInt("price");
				String name = result_set.getString("name");
				String description = result_set.getString("description");
				
				menu_item = new MenuItem(id, name, description, price);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menu_item;
	}
	
	public static ArrayList<MenuItem> getAll(){
		DBConnector db_connector = DBConnector.getInstance();
		String query = "SELECT * FROM menuitems";
		PreparedStatement prepared_statement = db_connector.PrepareStatement(query);
		

		ArrayList<MenuItem>  menuitem_list = new ArrayList<>();
		ResultSet result_set;
		try {
			result_set = prepared_statement.executeQuery();
			while(result_set.next()) {
				int id = result_set.getInt("id");
				int price = result_set.getInt("price");
				String name = result_set.getString("name");
				String description = result_set.getString("description");
				
				MenuItem menu_item = new MenuItem(id, name, description, price);
				menuitem_list.add(menu_item);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menuitem_list;
		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
