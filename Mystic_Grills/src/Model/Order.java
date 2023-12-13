package Model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Order {
	private int id, user_id, order_item_id;
	private int total;
	private String status;
	private Date date;
	
	public Order(int user_id, int order_item_id) {
		this.id = IDGeneratorUtil.GenerateId();
		this.user_id =  user_id;
		this.order_item_id = order_item_id;
		this.total = CalculateTotal();
		this.date = new Date(System.currentTimeMillis());
		this.status = "Pending";
	}
	
	private int CalculateTotal() {
		return 0;
	}
	
	public static ArrayList<OrderItem> GetOrderItemByUserID(int user_id) {
		DBConnector db_connector = DBConnector.getInstance();
    	String query = "SELECT * FROM orders WHERE user_id = ?";
    	ArrayList<OrderItem> order_items = new ArrayList<>();
    	
    	PreparedStatement prepared_statement = db_connector.PrepareStatement(query);
    	try {
			prepared_statement.setInt(1, user_id);
			
			ResultSet result_set = prepared_statement.executeQuery();
			while(result_set.next()) {
				int order_item_id = result_set.getInt("order_item_id");
				OrderItem order_item = OrderItem.getOrderById(order_item_id);
				order_items.add(order_item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			order_items = null;
		}
    	
    	return order_items;
	}
	
	public static void Delete(int order_item_id) {
		DBConnector db_connector = DBConnector.getInstance();
    	String query = "DELETE FROM orders WHERE order_item_id = ?";
    	
    	PreparedStatement prepared_statement = db_connector.PrepareStatement(query);
    	try {
			prepared_statement.setInt(1, order_item_id);
	        prepared_statement.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void InsertOrder(Order order) {
		DBConnector db_connector = DBConnector.getInstance();
    	String query = "INSERT INTO orders "
    					+  "(id, user_id, order_item_id, total, status, date)"
						+ " VALUES (?, ?, ?, ?, ?, ?)";
    	
    	
    	PreparedStatement prepared_statement = db_connector.PrepareStatement(query);
    	try {
			prepared_statement.setInt(1, order.getId());
			prepared_statement.setInt(2, order.getUser_id());
	        prepared_statement.setInt(3, order.getOrder_item_id());
	        prepared_statement.setInt(4, order.getTotal());
	        prepared_statement.setString(5, order.getStatus());
	        prepared_statement.setDate(6, order.getDate());
	        prepared_statement.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
