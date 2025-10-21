package service;

import java.util.List;

import model.MyOrder;

public interface MyOrderService {
	
	boolean createOrder(MyOrder order);
	
	MyOrder readOrderById(int id);
	List<MyOrder> readAllOrder();
	
	boolean updateOrder(MyOrder order);
	
	boolean deleteOrderById(int id);

}
