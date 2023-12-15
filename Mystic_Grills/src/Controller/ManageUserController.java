package Controller;

import java.util.ArrayList;

import Model.MenuItem;
import Model.OrderItem;
import Model.User;
import View.MainView;
import View.ManageUserView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ManageUserController {
	private ManageUserView manage_user_view;
	private Stage primary_stage;

	public ManageUserController(ManageUserView _manage_user_view, Stage _primary_stage) {
		this.manage_user_view = _manage_user_view;
		this.primary_stage = _primary_stage;
		LoadData();
		Listener();
	}
	
	private void Listener() {
		TableViewListener();
		UpdateButtonListener();
		BackButtonListener();
		DeleteButtonListener();
	}
	
	private void DeleteButtonListener() {
		manage_user_view
		.getDelete_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if(manage_user_view.getId_field().getText() != "") {
					int user_id = Integer.parseInt(manage_user_view.getId_field().getText());
					User.Delete(user_id);
					LoadData();
				}
				
			}});
	}
	
	private void BackButtonListener() {
		manage_user_view
		.getBack_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				MainView main_view = new MainView();
				MainController main_controller = new MainController(main_view, primary_stage);
				
				Scene scene = main_view.getScene();
				primary_stage.setScene(scene);
			}});
	}
	
	private void UpdateButtonListener() {
		manage_user_view
		.getUpdate_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if(manage_user_view.getId_field().getText() != "") {
					int user_id = Integer.parseInt(manage_user_view.getId_field().getText());
					
					RadioButton selected = (RadioButton) manage_user_view
											.getRole_togglegroup().getSelectedToggle();
					
					if(selected != null) {
						String selected_role_inString = selected.getText();
						User.UpdateUserRole(user_id, selected_role_inString);
						LoadData();
					}
				}
			}});
	}
	
	private void TableViewListener() {
		manage_user_view.getTable_view()
		.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 1) {
					User selected_user = manage_user_view.getTable_view()
															.getSelectionModel()
															.getSelectedItem();
					
					if(selected_user != null) {
						manage_user_view.getId_field().setText(
									String.valueOf(selected_user.getId())
								);
						manage_user_view.getName_field().setText(
									selected_user.getName()
								);
						if(selected_user.getRole().equals(User.ROLE.CUSTOMER)) {
							manage_user_view.getCustomer_radiobutton().setSelected(true);
							manage_user_view.getAdmin_radiobutton().setSelected(false);
						}
						else if(selected_user.getRole().equals(User.ROLE.ADMIN)) {
							manage_user_view.getCustomer_radiobutton().setSelected(false);
							manage_user_view.getAdmin_radiobutton().setSelected(true);
						}
					}
		        }
			}});
	}
	
	public void LoadData() {
		ArrayList<User> users = User.getAll();
		ObservableList<User> observable_menuitems = FXCollections.observableArrayList(users);
		manage_user_view.getTable_view().setItems(observable_menuitems);
	}
}
