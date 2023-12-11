package View;

import Model.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuItemTable {
	private TableView<MenuItem> table_view;
	
	public MenuItemTable() {
		InitTableView();
	}
	
	@SuppressWarnings("unused")
	private void InitTableView() {
		table_view = new TableView<>();
		
		TableColumn<MenuItem, Integer> id_column = new TableColumn<>("ID");
		id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumn<MenuItem, String> name_column = new TableColumn<>("Name");
		name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<MenuItem, String> description_column = new TableColumn<>("Description");
		description_column.setCellValueFactory(new PropertyValueFactory<>("description"));
		TableColumn<MenuItem, Integer> price_column = new TableColumn<>("Price");
		price_column.setCellValueFactory(new PropertyValueFactory<>("price"));
	
		table_view.getColumns().addAll(id_column, name_column, description_column, price_column);
			
	}
	
	public TableView<MenuItem> getTableView(){
		return table_view;
	}
}
