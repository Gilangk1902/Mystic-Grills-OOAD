package View;

import Model.MenuItem;
import View.TableView.MenuItemTable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OrderMenuItemView {
	private TableView<MenuItem> table_view;
	private TextField quantity_field, name_field, id_field;
	private Button order_button, min_button, plus_button, back_button;
	private GridPane form;
	private VBox vbox;
	
	public OrderMenuItemView() {
		Label title = new Label("lets get shopping");
		table_view = new MenuItemTable().getTableView();
		InitForm();
		
		vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10));
        
        vbox.getChildren().addAll(title, table_view, form);
	}
	
	
	private void InitForm() {
		quantity_field = new TextField();
		name_field = new TextField();
		id_field = new TextField();
		id_field.setVisible(false);
		order_button = new Button("add to cart");
		min_button = new Button("-");
		plus_button = new Button("+");
		back_button = new Button("back");
		
		form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10, 10, 10, 10));
        
        form.add(new Label("Name:"), 0, 1);
        form.add(name_field, 1, 1);
        form.add(new Label("Quantity:"), 0, 2);
        form.add(quantity_field, 1, 2);
        form.add(min_button, 0, 3);
        form.add(plus_button, 1, 3);
        form.add(order_button, 0, 4);
        form.add(back_button, 1, 4);
        
	}
	
	public Scene getScene() {
		return new Scene(vbox, ViewProperties.WIDTH, ViewProperties.HEIGHT);
	}
	
	public TableView<MenuItem> getTableView(){
		return table_view;
	}


	public TableView<MenuItem> getTable_view() {
		return table_view;
	}


	public void setTable_view(TableView<MenuItem> table_view) {
		this.table_view = table_view;
	}


	public TextField getQuantity_field() {
		return quantity_field;
	}


	public void setQuantity_field(TextField quantity_field) {
		this.quantity_field = quantity_field;
	}


	public TextField getName_field() {
		return name_field;
	}


	public void setName_field(TextField name_field) {
		this.name_field = name_field;
	}


	public TextField getId_field() {
		return id_field;
	}


	public void setId_field(TextField id_field) {
		this.id_field = id_field;
	}


	public Button getOrder_button() {
		return order_button;
	}


	public void setOrder_button(Button order_button) {
		this.order_button = order_button;
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


	public Button getBack_button() {
		return back_button;
	}


	public void setBack_button(Button back_button) {
		this.back_button = back_button;
	}
	
	

}
