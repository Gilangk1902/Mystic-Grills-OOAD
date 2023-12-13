package View.TableView;

import Model.MenuItem;
import Model.OrderItem;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrderItemTable {
private TableView<OrderItem> table_view;
	
	public OrderItemTable() {
		InitTableView();
	}
	
	@SuppressWarnings("unused")
	private void InitTableView() {
	    table_view = new TableView<>();

	    TableColumn<OrderItem, Integer> id_column = new TableColumn<>("ID");
	    id_column.setCellValueFactory(new PropertyValueFactory<>("id"));

	    TableColumn<OrderItem, Integer> menuitem_id_column = new TableColumn<>("MenuItem ID");
	    menuitem_id_column.setCellValueFactory(new PropertyValueFactory<>("menuitem_id"));

	    TableColumn<OrderItem, String> name_column = new TableColumn<>("Name");
	    name_column.setCellValueFactory(param -> {
	        MenuItem menuItem = MenuItem.getById(param.getValue().getMenuitem_id());
	        if (menuItem != null) {
	            return new SimpleStringProperty(menuItem.getName());
	        } else {
	            return new SimpleStringProperty("");
	        }
	    });

	    TableColumn<OrderItem, Integer> price_column = new TableColumn<>("Price");
	    price_column.setCellValueFactory(param -> {
	        MenuItem menuItem = MenuItem.getById(param.getValue().getMenuitem_id());
	        if (menuItem != null) {
	            return new SimpleIntegerProperty(menuItem.getPrice()).asObject();
	        } else {
	            return new SimpleIntegerProperty(0).asObject();
	        }
	    });
	    
	    TableColumn<OrderItem, Integer> quantity_column = new TableColumn<>("Quantity");
	    quantity_column.setCellValueFactory(new PropertyValueFactory<>("quantity"));

	    table_view.getColumns().addAll(id_column, menuitem_id_column, name_column, price_column, quantity_column);
	}
	
	public TableView<OrderItem> getTableView(){
		return table_view;
	}
}
