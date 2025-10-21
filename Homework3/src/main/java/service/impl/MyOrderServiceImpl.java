package service.impl;

import java.util.List;

import dao.impl.MyOrderDaoImpl;
import model.MyOrder;
import service.MyOrderService;

public class MyOrderServiceImpl implements MyOrderService {
	
	private MyOrderDaoImpl odi = new MyOrderDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean createOrder(MyOrder order) {
		// TODO Auto-generated method stub
		return odi.insert(order);
	}

	@Override
	public MyOrder readOrderById(int id) {
		// TODO Auto-generated method stub
		return odi.selectOrderById(id);
	}
	
	@Override
	public List<MyOrder> readAllOrder() {
		// TODO Auto-generated method stub
		return odi.selectAllOrder();
	}

	@Override
	public boolean updateOrder(MyOrder order) {
		// TODO Auto-generated method stub
		return odi.update(order);
	}

	@Override
	public boolean deleteOrderById(int id) {
		// TODO Auto-generated method stub
		return odi.delete(id);
	}

}
