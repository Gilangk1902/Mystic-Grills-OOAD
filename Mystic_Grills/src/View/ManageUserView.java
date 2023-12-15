package View;

import Model.User;
import View.TableView.UserTable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ManageUserView {
	private TableView<User> table_view;
	private TextField name_field, id_field;
	private Button update_button, delete_button, back_button;
	private RadioButton customer_radiobutton, admin_radiobutton;
	private ToggleGroup role_togglegroup = new ToggleGroup();
	private GridPane form;
	private VBox vbox;
	public ManageUserView() {
		table_view = new UserTable().getTableView();
		
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
		
		delete_button = new Button("delete");
		update_button = new Button("update");
		back_button = new Button("back");
		
		admin_radiobutton = new RadioButton(User.ROLE.ADMIN);
		admin_radiobutton.setToggleGroup(role_togglegroup);
		customer_radiobutton = new RadioButton(User.ROLE.CUSTOMER);
		customer_radiobutton.setToggleGroup(role_togglegroup);
		
		form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.setPadding(new Insets(10, 10, 10, 10));
        
        form.add(new Label("Name:"), 0, 1);
        form.add(name_field, 1, 1);
        form.add(new Label("Role:"), 0, 2);
        form.add(customer_radiobutton, 1, 2);
        form.add(admin_radiobutton, 2, 2);
        
        form.add(update_button, 3, 3, 1, 1);  
        form.add(delete_button, 4, 3, 1, 1);
        form.add(back_button, 4, 4, 1, 1);
	}
	
	public Scene getScene() {
		return new Scene(vbox, ViewProperties.WIDTH, ViewProperties.HEIGHT);
	}

	public TableView<User> getTable_view() {
		return table_view;
	}

	public void setTable_view(TableView<User> table_view) {
		this.table_view = table_view;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
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

	public GridPane getForm() {
		return form;
	}

	public void setForm(GridPane form) {
		this.form = form;
	}

	public RadioButton getCustomer_radiobutton() {
		return customer_radiobutton;
	}

	public void setCustomer_radiobutton(RadioButton customer_radiobutton) {
		this.customer_radiobutton = customer_radiobutton;
	}

	public RadioButton getAdmin_radiobutton() {
		return admin_radiobutton;
	}

	public void setAdmin_radiobutton(RadioButton admin_radiobutton) {
		this.admin_radiobutton = admin_radiobutton;
	}

	public ToggleGroup getRole_togglegroup() {
		return role_togglegroup;
	}

	public void setRole_togglegroup(ToggleGroup role_togglegroup) {
		this.role_togglegroup = role_togglegroup;
	}

	public Button getBack_button() {
		return back_button;
	}

	public void setBack_button(Button back_button) {
		this.back_button = back_button;
	}
	
	
}
