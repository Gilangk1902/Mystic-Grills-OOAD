package View;

import Main.Session;
import Model.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainView {
	private Label username_label, role_label;
	private Button menuitem_button, cart_button, manage_order_button, payment_button ;
	private Button manage_user_button;
	private StackPane root;
	
	public MainView() {
        Init();
        root = new StackPane();
        VBox vBox = null;
        if(Session.getUser().getRole().toString().equals(User.ROLE.CUSTOMER)) {
        	 vBox = new VBox(
        			 	username_label, role_label, menuitem_button, 
        			 	cart_button, logout_button
        			 );
        }
        else if(Session.getUser().getRole().toString().equals(User.ROLE.ADMIN)) {
        	vBox = new VBox(
        				username_label, role_label, manage_user_button, 
        				menuitem_button, logout_button
        			);
        }
        else if(Session.getUser().getRole().toString().equals(User.ROLE.CHEF)) {
        	vBox = new VBox(username_label, role_label, manage_order_button);
        }
        else if(Session.getUser().getRole().toString().equals(User.ROLE.WAITER)) {
        	vBox = new VBox(username_label, role_label, manage_order_button);
        }
        else if(Session.getUser().getRole().toString().equals(User.ROLE.CASHIER)) {
        	vBox = new VBox(username_label, role_label, payment_button);
        }
        root.getChildren().add(vBox);
    }
	
	

    public Button getManage_order_button() {
		return manage_order_button;
	}

	public void setManage_order_button(Button manage_order_button) {
		this.manage_order_button = manage_order_button;
	}

	public Button getPayment_button() {
		return payment_button;
	}

	public void setPayment_button(Button payment_button) {
		this.payment_button = payment_button;
	}

	public Scene getScene() {
        return new Scene(root, 400, 400);
    }

    private void Init() {
        username_label = new Label("Username: " + Session.getUser().getName().toString());
        role_label = new Label("Role: " + Session.getUser().getRole().toString());
        
        if(Session.getUser().getRole().toString().equals(User.ROLE.CUSTOMER)) {
        	menuitem_button = new Button("view our menu");
            cart_button = new Button("view ur cart");
        }
        else if(Session.getUser().getRole().toString().equals(User.ROLE.ADMIN)) {
        	manage_user_button = new Button("Manage User");
        	menuitem_button = new Button("Manage Menu");
        }
        else if(Session.getUser().getRole().toString().equals(User.ROLE.CHEF)) {
        	manage_order_button = new Button("Manage Order");
        }
    }

	public Label getLabel() {
		return username_label;
	}

	public void setLabel(Label label) {
		this.username_label = label;
	}

	public Button getMenuitem_button() {
		return menuitem_button;
	}

	public void setMenuitem_button(Button menuitem_button) {
		this.menuitem_button = menuitem_button;
	}

	public Button getCart_button() {
		return cart_button;
	}

	public void setCart_button(Button cart_button) {
		this.cart_button = cart_button;
	}

	public StackPane getRoot() {
		return root;
	}

	public void setRoot(StackPane root) {
		this.root = root;
	}

	public Label getUsername_label() {
		return username_label;
	}

	public void setUsername_label(Label username_label) {
		this.username_label = username_label;
	}

	public Label getRole_label() {
		return role_label;
	}

	public void setRole_label(Label role_label) {
		this.role_label = role_label;
	}

	public Button getManage_user_button() {
		return manage_user_button;
	}

	public void setManage_user_button(Button manage_user_button) {
		this.manage_user_button = manage_user_button;
	}

	public Button getLogout_button() {
		return logout_button;
	}

	public void setLogout_button(Button logout_button) {
		this.logout_button = logout_button;
	}

	
}
