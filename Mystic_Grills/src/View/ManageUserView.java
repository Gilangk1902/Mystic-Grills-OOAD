package View;

import Model.User;
import View.TableView.UserTable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class ManageUserView {
	TableView<User> table_view;
	VBox vbox;
	public ManageUserView() {
		table_view = new UserTable().getTableView();
		
		vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10));
        
        vbox.getChildren().addAll(table_view);
	}
	
	public Scene getScene() {
		return new Scene(vbox, 400, 400);
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
	
	
}
