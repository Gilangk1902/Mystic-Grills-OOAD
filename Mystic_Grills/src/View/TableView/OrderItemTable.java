package View.TableView;

import Model.MenuItem;
import Model.OrderItem;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

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
	    
//	    TableColumn<OrderItem, Integer> button_column = new TableColumn<>("Quantity");
//	    button_column.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//	    button_column.setCellFactory(column -> new QuantityButtonCell());

	    table_view.getColumns().addAll(
	    		id_column, menuitem_id_column, name_column, 
	    		price_column, quantity_column);
	}
	
	public TableView<OrderItem> getTableView(){
		return table_view;
	}
	
	
	
	public TableView<OrderItem> getTable_view() {
		return table_view;
	}

	public void setTable_view(TableView<OrderItem> table_view) {
		this.table_view = table_view;
	}

	public class QuantityButtonCell extends TableCell<OrderItem, Integer> {

	    private final Button plus_button = new Button("+");
	    private final Button minus_button = new Button("-");

	    @Override
	    protected void updateItem(Integer item, boolean empty) {
	        super.updateItem(item, empty);

	        if (empty || item == null) {
	            setGraphic(null);
	        } else {
	            setGraphic(createButtonPane());
	        }
	    }

	    private HBox createButtonPane() {
	        HBox buttonPane = new HBox(5);
	        buttonPane.getChildren().addAll(minus_button, plus_button);
	        return buttonPane;
	    }

		public Button getPlus_button() {
			return plus_button;
		}

		public Button getMinus_button() {
			return minus_button;
		}
	    
	    
	}
}
