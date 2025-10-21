package dao;

import java.util.List;

import model.MyOrder;

public interface MyOrderDao {

	boolean insert(MyOrder order);
	
	MyOrder selectOrderById(int id);
	List<MyOrder> selectAllOrder();
	
	boolean update(MyOrder order);
	
	boolean delete(int id);
	
}
