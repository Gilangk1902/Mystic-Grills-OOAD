package Controller;

import java.util.ArrayList;

import Main.Session;
import Model.Order;
import Model.OrderItem;
import View.CartView;
import View.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CartController {
	private Stage primary_stage;
	private CartView cart_view;
	
	public CartController(CartView _cart_view, Stage _primary_stage) {
		this.cart_view = _cart_view;
		this.primary_stage = _primary_stage;
		LoadData();
		Listeners();
	}
	
	private void Listeners() {
		EditQuantityListeners();
		TableViewListener();
		DeleteListener();
		BackListener();
		CheckoutListener();
	}
	
	private void BackListener() {
		cart_view
		.getBack_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				MainView main_view = new MainView();
				MainController main_controller = new MainController(main_view, primary_stage);
				
				Scene scene = main_view.getScene();
				primary_stage.setScene(scene);
			}
			
		});
	}
	
	private void CheckoutListener() {
		
	}
	
	private void DeleteListener() {
		cart_view
		.getDelete_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String id_in_string = cart_view.getOrder_item_id_field().getText();
				if(!id_in_string.equals("")) {
					int id = Integer.parseInt(id_in_string);
					Order.Delete(id);
					OrderItem.Delete(id);
					LoadData();
				}
			}
			
		});
	}
	
	private void EditQuantityListeners() {
		cart_view
		.getMin_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int current_quantity = Integer.parseInt(
											cart_view.
											getQuantity_field().getText()
										);
				
				if(current_quantity > 1) {
					int new_quantity = current_quantity - 1;
					cart_view.getQuantity_field().setText(String.valueOf(new_quantity));
					
					int id  = Integer.parseInt(cart_view.getOrder_item_id_field().getText());
					
					OrderItem.UpdateQuantity(
						id, 
						new_quantity
					);
					
					LoadData();
				}
				
			}});
		
		cart_view
		.getPlus_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int current_quantity = Integer.parseInt(
											cart_view.
											getQuantity_field().getText()
										);
				
				int new_quantity = current_quantity + 1;
				cart_view.getQuantity_field().setText(String.valueOf(new_quantity));
				
				int id  = Integer.parseInt(cart_view.getOrder_item_id_field().getText());
				OrderItem.UpdateQuantity(id, new_quantity);
				LoadData();
			}});
	}
	
	private void TableViewListener() {
		cart_view.getTable_view()
		.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 1) {
		            Model.OrderItem selected_menuitem = cart_view
		            									.getTable_view()
		            									.getSelectionModel()
		            									.getSelectedItem();
		            if (selected_menuitem != null) {
		            	cart_view.getOrder_item_id_field().setText(
		            				String.valueOf(selected_menuitem.getId())
		            			);
		            	cart_view.getQuantity_field().setText(
		            				String.valueOf(selected_menuitem.getQuantity())
		            			);
		            }
		        }
			}});
	}
	
	private void LoadData() {
		ArrayList<Model.OrderItem> orders = Order.GetOrderItemByUserID(Session.getUser().getId());
		ObservableList<Model.OrderItem> observable_menuitems = FXCollections.observableArrayList(orders);
		cart_view.getTable_view().setItems(observable_menuitems);
	}
	
//	private void Listeners() {
//	cart_view.getQuantityButtonCell()
//	.getPlus_button().setOnAction(new EventHandler<ActionEvent>() {
//
//		@Override
//		public void handle(ActionEvent arg0) {
//			// Get the selected OrderItem
//	        OrderItem selectedOrderItem = cart_view.getTable_view().getSelectionModel().getSelectedItem();
//
//	        if (selectedOrderItem != null) {
//	            int current_quantity = selectedOrderItem.getQuantity();
//	            int new_quantity = current_quantity + 1;
//	            
//	            OrderItem.UpdateQuantity(selectedOrderItem.getId(), new_quantity);
//	            LoadData();
//
//	        }
//	    }
//	}
//	);
//	cart_view.getQuantityButtonCell()
//	.getMinus_button().setOnAction(new EventHandler<ActionEvent>() {
//
//		@Override
//		public void handle(ActionEvent arg0) {
//			
//			
//		}}
//	);
//}
}
