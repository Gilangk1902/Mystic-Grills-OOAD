package View;

import Model.OrderItem;
import View.TableView.OrderItemTable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class CartView {
	private TableView<OrderItem> table_view;
	private VBox vbox;
	
	public CartView() {
		table_view = new OrderItemTable().getTableView();
		
		vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10));
        
        vbox.getChildren().addAll(table_view);
	}
	
	public Scene getScene() {
		return new Scene(vbox, 400, 400);
	}

	public TableView<OrderItem> getTable_view() {
		return table_view;
	}

	public void setTable_view(TableView<OrderItem> table_view) {
		this.table_view = table_view;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}
	
	
}
