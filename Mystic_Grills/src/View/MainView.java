package View;

import Main.Session;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainView {
	private Label label;
	private StackPane root;
	
	public MainView() {
		Init();
		// Create a StackPane layout and add the label to it
        root = new StackPane();
		root.getChildren().add(label);
        
	}
	
	public Scene getScene() {
        return new Scene(root, 400, 400);
	}
	
	private void Init() {
		label = new Label("Username: " + Session.getUser().getUsername().toString());
	}
	
	public Label getLabel() {
		return label;
	}
	
}
