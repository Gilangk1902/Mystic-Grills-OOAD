package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItem {
	int id, menuitem_id, quantity;
	
	public OrderItem(int _menuitem_id, int _quantity) {
		id = IDGeneratorUtil.GenerateId();
		menuitem_id = _menuitem_id;
		quantity = _quantity;
	}
	
	public static OrderItem getOrderById(int id) {
		DBConnector db_connector = DBConnector.getInstance();
    	String query = "SELECT * FROM orderitems WHERE name = ?";
    	OrderItem _order_item = null;
    	
    	PreparedStatement prepared_statement = db_connector.PrepareStatement(query);
    	try {
			prepared_statement.setInt(1, id);
			
			ResultSet result_set = prepared_statement.executeQuery();
			if(result_set.next()) {
				int _menuitem_id = result_set.getInt("menu_item_id");
				int _quantity = result_set.getInt("quantity");
				
				_order_item = new OrderItem(_menuitem_id, _quantity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			_order_item = null;
		}
    	
    	return _order_item;
	}
	
	public static void Order(OrderItem order_item) {
		DBConnector db_connector = DBConnector.getInstance();
    	String query = "INSERT INTO orderitems (id, menu_item_id, quantity) VALUES (?, ?, ?)";
    	
    	PreparedStatement prepared_statement = db_connector.PrepareStatement(query);
    	try {
			prepared_statement.setInt(1, order_item.getId());
			prepared_statement.setInt(2, order_item.getMenuitem_Id());
	        prepared_statement.setInt(3, order_item.getQuantity());
	        prepared_statement.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}
	
	public int getMenuitem_Id() {
		return menuitem_id;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public int getMenuitem_id() {
		return menuitem_id;
	}

	public void setMenuitem_id(int menuitem_id) {
		this.menuitem_id = menuitem_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
