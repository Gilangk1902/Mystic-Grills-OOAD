package View;

import Model.OrderItem;
import View.TableView.OrderItemTable;
import View.TableView.OrderItemTable.QuantityButtonCell;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CartView {
	private TableView<OrderItem> table_view;
	private TextField quantity_field, user_id_field, id_field, order_item_id_field;
	private Button delete_button, min_button, plus_button, back_button;
	private GridPane form;
	private VBox vbox;
	
	public CartView() {
		Label title = new Label("Your Cart");
		table_view = new OrderItemTable().getTableView();
		InitForm();
		vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10));
        
        vbox.getChildren().addAll(title,table_view,form);
	}
	
	private void InitForm() {
		quantity_field = new TextField();
		user_id_field = new TextField();
		order_item_id_field = new TextField();
		id_field = new TextField();
		id_field.setVisible(false);
		delete_button = new Button("delete");
		min_button = new Button("-");
		plus_button = new Button("+");
		back_button = new Button("back");
		
		form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10, 10, 10, 10));
        
        form.add(new Label("Order Item ID:"), 0, 2);
        form.add(order_item_id_field, 1, 2);
        form.add(new Label("Quantity:"), 0, 3);
        form.add(quantity_field, 1, 3);
        form.add(min_button, 0, 4);
        form.add(plus_button, 1, 4);
        form.add(delete_button, 0, 5);
        form.add(back_button, 1, 5);
        
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

	public TextField getQuantity_field() {
		return quantity_field;
	}

	public void setQuantity_field(TextField quantity_field) {
		this.quantity_field = quantity_field;
	}

	public TextField getUser_id_field() {
		return user_id_field;
	}

	public void setUser_id_field(TextField user_id_field) {
		this.user_id_field = user_id_field;
	}

	public TextField getId_field() {
		return id_field;
	}

	public void setId_field(TextField id_field) {
		this.id_field = id_field;
	}

	public TextField getOrder_item_id_field() {
		return order_item_id_field;
	}

	public void setOrder_item_id_field(TextField order_item_id_field) {
		this.order_item_id_field = order_item_id_field;
	}

	public Button getDelete_button() {
		return delete_button;
	}

	public void setDelete_button(Button delete_button) {
		this.delete_button = delete_button;
	}

	public Button getMin_button() {
		return min_button;
	}

	public void setMin_button(Button min_button) {
		this.min_button = min_button;
	}

	public Button getPlus_button() {
		return plus_button;
	}

	public void setPlus_button(Button plus_button) {
		this.plus_button = plus_button;
	}

	public GridPane getForm() {
		return form;
	}

	public void setForm(GridPane form) {
		this.form = form;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

	public Button getBack_button() {
		return back_button;
	}

	public void setBack_button(Button back_button) {
		this.back_button = back_button;
	}

	
}
