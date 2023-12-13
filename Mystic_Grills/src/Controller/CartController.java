package Controller;

import java.util.ArrayList;

import Main.Session;
import Model.Order;
import View.CartView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class CartController {
	private Stage primary_stage;
	private CartView cart_view;
	
	public CartController(CartView _cart_view, Stage _primary_stage) {
		this.cart_view = _cart_view;
		this.primary_stage = _primary_stage;
		LoadData();
	}
	
	private void LoadData() {
		ArrayList<Model.OrderItem> orders = Order.GetOrderItemByUserID(Session.getUser().getId());
		ObservableList<Model.OrderItem> observable_menuitems = FXCollections.observableArrayList(orders);
		cart_view.getTable_view().setItems(observable_menuitems);
	}
}
