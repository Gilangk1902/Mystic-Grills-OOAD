package Controller;

import Main.Session;
import Model.User;
import View.CartView;
import View.LoginView;
import View.MainView;
import View.ManageMenuItemView;
import View.ManageUserView;
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
		String user_role = Session.getUser().getRole().toString();
		if(user_role.equals(User.ROLE.CUSTOMER)) {
			CustomerListeners();
		}
		else if(user_role.equals(User.ROLE.ADMIN)) {
			AdminListener();
		}
		
		main_view
		.getLogout_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Session.logout();
				LoginView login_view = new LoginView();
				LoginController login_controller = new LoginController(login_view, primary_stage);
				
				Scene scene = login_view.getScene();
				primary_stage.setScene(scene);
			}
			
		});
	}
	
	private void AdminListener() {
		main_view
		.getMenuitem_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ManageMenuItemView manage_menuitem_view = new ManageMenuItemView();
				ManageMenuItemController 
				manage_menuitem_controller = new ManageMenuItemController(
												manage_menuitem_view, primary_stage
											);
				
				Scene scene = manage_menuitem_view.getScene();
				primary_stage.setScene(scene);
			}
			
		});
		
		main_view
		.getManage_user_button().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ManageUserView manage_user_view = new ManageUserView();
				ManageUserController 
				manage_user_controller = new ManageUserController(
							manage_user_view, primary_stage
						);
				
				Scene scene = manage_user_view.getScene();
				primary_stage.setScene(scene);
			}
			
		});
	}
	
	private void CustomerListeners() {
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
