package Controller;

import java.util.ArrayList;

import Model.Order;
import Model.OrderItem;
import View.ManageOrderView;
import View.ManageUserView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class ManageOrderController {
	private ManageOrderView manage_order_view;
	private Stage primary_stage;

	public ManageOrderController(ManageOrderView _manage_order_view, Stage _primary_stage) {
		this.manage_order_view = _manage_order_view;
		this.primary_stage = _primary_stage;
		LoadData();
	}
	
	public void LoadData() {
		ArrayList<Order> orders = Order.getAll();
	}
//	UPDATE

}
