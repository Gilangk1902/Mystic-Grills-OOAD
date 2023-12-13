package View;

import Model.MenuItem;
import View.TableView.MenuItemTable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class AddMenuItemView {
	private TableView<MenuItem> table_view;
	private TextField name_field, id_field, description_field, price_field;
	private Button add_button, update_button, delete_button;
	private GridPane form;
	private VBox vbox;
	
	public AddMenuItemView() {
		//InitTableView();
		table_view = new MenuItemTable().getTableView();
		
		InitForm();
		
		vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10));
        
        vbox.getChildren().addAll(table_view, form);
	}
	
	
	private void InitForm() {
		name_field = new TextField();
		id_field = new TextField();
		id_field.setVisible(false);
		description_field = new TextField();
		price_field = new TextField();
		add_button = new Button("Add");
		update_button = new Button("Update");
		delete_button = new Button("Delete");
	
		form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10, 10, 10, 10));
        
        
        form.add(new Label("Name:"), 0, 1);
        form.add(name_field, 1, 1);
        form.add(new Label("Description:"), 0, 2);
        form.add(description_field, 1, 2);
        form.add(new Label("Price:"), 0, 3);
        form.add(price_field, 1, 3);
        
        
        form.add(add_button, 0, 4, 2, 1);
        form.add(update_button, 2, 4, 2, 1);
        form.add(delete_button, 4, 4, 2, 1);
	}
	
	public Scene getScene() {
		return new Scene(vbox, 400, 400);
	}

	public TableView<MenuItem> getTable_view() {
		return table_view;
	}

	public void setTable_view(TableView<MenuItem> table_view) {
		this.table_view = table_view;
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

	public TextField getDescription_field() {
		return description_field;
	}

	public void setDescription_field(TextField description_field) {
		this.description_field = description_field;
	}

	public TextField getPrice_field() {
		return price_field;
	}

	public void setPrice_field(TextField price_field) {
		this.price_field = price_field;
	}

	public Button getAdd_button() {
		return add_button;
	}

	public void setAdd_button(Button add_button) {
		this.add_button = add_button;
	}

	public GridPane getForm() {
		return form;
	}

	public void setForm(GridPane form) {
		this.form = form;
	}

	public Button getUpdate_button() {
		return update_button;
	}

	public void setUpdate_button(Button update_button) {
		this.update_button = update_button;
	}

	public Button getDelete_button() {
		return delete_button;
	}

	public void setDelete_button(Button delete_button) {
		this.delete_button = delete_button;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}
	
	
}
