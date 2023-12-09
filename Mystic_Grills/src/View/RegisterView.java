package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RegisterView {
    private TextField username_field, email_field;
    private PasswordField password_field;
    private Button register_button;
    private Button back_button;
    private VBox vbox;
    private HBox button_box;

    public RegisterView() {
        username_field = new TextField();
        email_field = new TextField();
        password_field = new PasswordField();
        
        register_button = new Button("Register");
        back_button = new Button("Back");  

        vbox = new VBox(10);  
        vbox.setPadding(new Insets(20, 20, 20, 20));

        vbox.getChildren().addAll(
            new Label("Username:"), username_field,
            new Label("Email:"), email_field,
            new Label("Password:"), password_field
        );

        button_box = new HBox(10);
        button_box.getChildren().addAll(
            register_button, 
            back_button
        );

        vbox.getChildren().add(button_box);
    }

    public Scene getScene(){
        return new Scene(vbox, 400, 400);
    }

    public TextField getUsername_field() {
        return username_field;
    }

    public void setUsername_field(TextField username_field) {
        this.username_field = username_field;
    }

    public TextField getEmail_field() {
        return email_field;
    }

    public void setEmail_field(TextField email_field) {
        this.email_field = email_field;
    }

    public PasswordField getPassword_field() {
        return password_field;
    }

    public void setPassword_field(PasswordField password_field) {
        this.password_field = password_field;
    }

    public Button getRegister_button() {
        return register_button;
    }

    public void setRegister_button(Button register_button) {
        this.register_button = register_button;
    }

    public Button getBack_button() {
        return back_button;
    }

    public void setBack_button(Button back_button) {
        this.back_button = back_button;
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
