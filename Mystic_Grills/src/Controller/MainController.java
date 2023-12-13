package Controller;

import View.CartView;
import View.MainView;
import View.OrderMenuItemView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
	private MainView main_view;
	private Stage primary_stage;
	
	public MainController(MainView main_view, Stage primary_stage) {
		this.main_view = main_view;
		this.primary_stage =  primary_stage;
		Listeners();
	}
	
	private void Listeners() {
		main_view.getMenuitem_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				OrderMenuItemView order_menuitem_view = new OrderMenuItemView();
				OrderMenuItemController order_menuitem_controller = 
										new OrderMenuItemController(order_menuitem_view, primary_stage);
				
				Scene order_menuitem_scene = order_menuitem_view.getScene();
				primary_stage.setScene(order_menuitem_scene);
			}}
		);
		
		main_view.getCart_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				CartView cart_view = new CartView();
				CartController cart_controller = new CartController(cart_view, primary_stage);
				
				Scene cart_scene = cart_view.getScene();
				primary_stage.setScene(cart_scene);
			}}
		);
	}
}
