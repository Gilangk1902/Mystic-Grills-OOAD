package Main;

import Controller.LoginController;
import Controller.RegisterController;
import View.LoginView;
import View.RegisterView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        
        LoginView login_view = new LoginView();
        LoginController login_controller = new LoginController(login_view, primaryStage);

        Scene scene = login_view.getScene();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}