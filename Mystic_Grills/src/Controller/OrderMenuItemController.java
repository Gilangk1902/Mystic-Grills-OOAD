package Controller;

import View.OrderMenuItemView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

import Model.*;

public class OrderMenuItemController {
	private Stage primary_stage;
	private OrderMenuItemView order_menuitem_view;

	public OrderMenuItemController(OrderMenuItemView _order_menuitem_view, Stage _primary_stage) {
		primary_stage = _primary_stage;
		order_menuitem_view = _order_menuitem_view;
		LoadData();
		Listeners();
	}
	
	private void Listeners() {
		TableViewListener();
		OrderButtonListener();
		EditQuantityListeners();
	}
	
	private void EditQuantityListeners() {
		order_menuitem_view
		.getMin_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int current_quantity = Integer.parseInt(
											order_menuitem_view.
											getQuantity_field().getText()
										);
				
				if(current_quantity > 1) {
					int new_quantity = current_quantity - 1;
					order_menuitem_view.getQuantity_field().setText(String.valueOf(new_quantity));
				}
				
			}});
		
		order_menuitem_view
		.getPlus_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int current_quantity = Integer.parseInt(
											order_menuitem_view.
											getQuantity_field().getText()
										);
				
				int new_quantity = current_quantity + 1;
				order_menuitem_view.getQuantity_field().setText(String.valueOf(new_quantity));
			}});
	}
	
	private void OrderButtonListener() {
		order_menuitem_view.getOrder_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String id_menuitem = order_menuitem_view.getId_field()
						.getText().toString();
				String quantity_in_string = order_menuitem_view.getQuantity_field()
											.getText().toString();
				
				if(!id_menuitem.isEmpty() && !quantity_in_string.isEmpty()) {
					OrderItem order_item = new OrderItem(
												Integer.parseInt(id_menuitem), 
												Integer.parseInt(quantity_in_string)
											);
					OrderItem.Order(order_item);
				}
			}});
	}
	
	private void TableViewListener() {
		order_menuitem_view.getTableView()
		.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 1) {
		            Model.MenuItem selected_menuitem = order_menuitem_view
		            									.getTableView()
		            									.getSelectionModel()
		            									.getSelectedItem();
		            if (selected_menuitem != null) {
		            	order_menuitem_view.getId_field().setText(
		            				String.valueOf(selected_menuitem.getId())
		            			);
		            	order_menuitem_view.getName_field().setText(
		            				selected_menuitem.getName()
		            			);
		            	order_menuitem_view.getQuantity_field().setText("1");
		            }
		        }
			}});
	}
	
	public void LoadData() {
		ArrayList<Model.MenuItem> menuitems = Model.MenuItem.getAll();
		ObservableList<Model.MenuItem> observable_menuitems = FXCollections.observableArrayList(menuitems);
		order_menuitem_view.getTable_view().setItems(observable_menuitems);
	}
}
