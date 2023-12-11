package Controller;

import Model.User;
import View.LoginView;
import View.RegisterView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class RegisterController {
    RegisterView register_view;
    Stage primary_stage;

    public RegisterController(RegisterView _register_view, Stage _primary_stage){
        register_view = _register_view;
        primary_stage = _primary_stage;
        Listeners();
    }

    public void Listeners(){
        register_view.getRegister_button().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                Register();
                LoginView login_view = new LoginView();
                LoginController login_controller = new LoginController(login_view, primary_stage);
                
                Scene login_scene = login_view.getScene();
                primary_stage.setScene(login_scene);
                
            }
            
        });
    }

    public void Register(){
        String name = register_view.getUsername_field().getText().toString();
        if(Validator.ValidateName(name) != Validator.VALID){
            ShowInfoAlert("invalid username", "invalid username", "error");
            return;
        }

        String email = register_view.getEmail_field().getText().toString();
        String validated_email = Validator.ValidateEmail(email);
        if(validated_email != Validator.VALID){
            ShowInfoAlert("invalid email", validated_email, "error");
            return;
        }

        String password = register_view.getPassword_field().getText().toString();
        String validated_password = Validator.ValidatePassWord(password);
        if(validated_password != Validator.VALID){
            ShowInfoAlert("invalid password", validated_password, "error");
            return;
        }
        
        User new_user = new User(name, email, password);
        User.Register(new_user);
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


