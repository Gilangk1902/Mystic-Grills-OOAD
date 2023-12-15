package Controller;

import Main.Session;
import Model.User;
import View.ManageMenuItemView;
import View.LoginView;
import View.MainView;
import View.OrderMenuItemView;
import View.RegisterView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class LoginController {
    private LoginView login_view;
    private Stage primary_stage;

    public LoginController(LoginView _login_view, Stage _primary_stage){
        login_view = _login_view;
        primary_stage = _primary_stage;
        Listeners();
    }

    public void Listeners(){
        login_view.getRegister_button().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                RegisterView register_view = new RegisterView();
                RegisterController register_controller = new RegisterController(register_view, primary_stage);

                Scene register_scene = register_view.getScene();
                primary_stage.setScene(register_scene);
            }
        });;
        
        login_view.getLogin_button().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Login();
				
				if(Session.getUser().getName()!=null) {
					String current_user_role =  Session.getUser().getRole().toLowerCase();
					
					if(current_user_role.equals(User.ROLE.ADMIN.toLowerCase())) {
						MainView main_view = new MainView();
						MainController main_controller = new MainController(main_view, primary_stage);
						
						Scene order_menuitem_scene = main_view.getScene();
						primary_stage.setScene(order_menuitem_scene);
					}
					
					else if(current_user_role.equals(User.ROLE.CUSTOMER.toLowerCase())) {
						MainView main_view = new MainView();
						MainController main_controller = new MainController(main_view, primary_stage);
						
						Scene order_menuitem_scene = main_view.getScene();
						primary_stage.setScene(order_menuitem_scene);
					}
					else if(current_user_role.equals(User.ROLE.CHEF.toLowerCase())) {
						MainView main_view = new MainView();
						MainController main_controller = new MainController(main_view, primary_stage);
						
						Scene order_menuitem_scene = main_view.getScene();
						primary_stage.setScene(order_menuitem_scene);
					}
				}
			}
        });
    }
    
    private void Login() {
    	String username = login_view.getUsername_field().getText().toString();
    	String validated_username = Validator.ValidateName(username);
    	if(validated_username != Validator.VALID) {
    		ShowInfoAlert("invalid username", validated_username, "error");
            return;
    	}
    	String password = login_view.getPassword_field().getText().toString();
    	String validated_password = Validator.ValidatePassWord(password);
    	if(Validator.ValidatePassWord(password) != Validator.VALID) {
    		ShowInfoAlert("invalid password", validated_password, "error");
            return;
    	}
    	
    	//check if account is available
    	User authenticated_user = User.getUser(username, password);
    	if(authenticated_user!=null) {
        	Session.setUser(authenticated_user);
    	}
    	else {
    		ShowInfoAlert("user not found", "", "error");
    	}
    }
    
    private void ShowInfoAlert(String title, String content, String alert_type) {
        Alert alert;
        if(alert_type == "error"){
            alert = new Alert(Alert.AlertType.ERROR);
        }
        else{
            alert = new Alert(Alert.AlertType.INFORMATION);
        }
        
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}


