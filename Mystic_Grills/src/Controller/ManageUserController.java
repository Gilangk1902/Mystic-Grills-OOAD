package Controller;

import java.util.ArrayList;

import Model.MenuItem;
import Model.User;
import View.ManageUserView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class ManageUserController {
	private ManageUserView manage_user_view;
	private Stage primary_stage;

	public ManageUserController(ManageUserView _manage_user_view, Stage _primary_stage) {
		this.manage_user_view = _manage_user_view;
		this.primary_stage = _primary_stage;
		LoadData();
	}
	
	public void LoadData() {
		ArrayList<User> users = User.getAll();
		ObservableList<User> observable_menuitems = FXCollections.observableArrayList(users);
		manage_user_view.getTable_view().setItems(observable_menuitems);
	}
}
