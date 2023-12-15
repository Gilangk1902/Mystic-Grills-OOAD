package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView {
    private TextField username_field;
    private TextField password_field;
    private Button login_button, register_button;
    private VBox vbox;
    private HBox button_box;

    public LoginView(){
        Init();

        vbox = new VBox(10);  // Adjusted the spacing between text fields
        vbox.setPadding(new Insets(20, 20, 20, 20));

        vbox.getChildren().addAll(
                new Label("Username:"), username_field,
                new Label("Password:"), password_field
        );

        // Create layout for buttons
        button_box = new HBox(10);  // Adjusted the spacing between buttons
        button_box.getChildren().addAll(login_button, register_button);

        // Combine text fields and buttons vertically
        vbox.getChildren().add(button_box);
    }

    public Scene getScene(){
        return new Scene(vbox, ViewProperties.WIDTH, ViewProperties.HEIGHT);
    }

    private void Init(){
        username_field = new TextField();
        password_field = new PasswordField();
        login_button = new Button("Login");
        register_button = new Button("Register");
    }

    public TextField getUsername_field() {
        return username_field;
    }

    public void setUsername_field(TextField username_field) {
        this.username_field = username_field;
    }

    public TextField getPassword_field() {
        return password_field;
    }

    public void setPassword_field(TextField password_field) {
        this.password_field = password_field;
    }

    public Button getLogin_button() {
        return login_button;
    }

    public void setLogin_button(Button login_button) {
        this.login_button = login_button;
    }

    public Button getRegister_button() {
        return register_button;
    }

    public void setRegister_button(Button register_button) {
        this.register_button = register_button;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public HBox getButton_box() {
        return button_box;
    }

    public void setButton_box(HBox button_box) {
        this.button_box = button_box;
    }

    
}
