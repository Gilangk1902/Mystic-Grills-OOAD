package View;

import Main.Session;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainView {
	private Label label;
	private Button menuitem_button;
	private Button cart_button;
	private StackPane root;
	
	public MainView() {
        Init();
        root = new StackPane();
        VBox vBox = new VBox(label, menuitem_button, cart_button);
        root.getChildren().add(vBox);
    }

    public Scene getScene() {
        return new Scene(root, 400, 400);
    }

    private void Init() {
        label = new Label("Username: " + Session.getUser().getUsername().toString());
        menuitem_button = new Button("view our menu");
        cart_button = new Button("view ur cart");
    }

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
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

	
}
