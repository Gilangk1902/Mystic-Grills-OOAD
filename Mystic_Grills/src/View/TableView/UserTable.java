package View.TableView;

import Model.MenuItem;
import Model.User;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserTable {
	private TableView<User> table_view;
	
	public UserTable() {
		InitTableView();
	}
	
	@SuppressWarnings("unused")
	private void InitTableView() {
		table_view = new TableView<>();
		
		TableColumn<User, Integer> id_column = new TableColumn<>("ID");
		id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumn<User, String> role_column = new TableColumn<>("Role");
		role_column.setCellValueFactory(new PropertyValueFactory<>("role"));
		TableColumn<User, String> name_column = new TableColumn<>("Name");
		name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<User, Integer> email_column = new TableColumn<>("Email");
		email_column.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		table_view.getColumns().addAll(id_column, name_column, role_column, email_column);
			
	}
	
	public TableView<User> getTableView(){
		return table_view;
	}
}
