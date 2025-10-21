package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MyOrderDao;
import model.MyOrder;
import util.DbConnection;

public class MyOrderDaoImpl implements MyOrderDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MyOrderDaoImpl().selectAllOrder().size());
	}
	
	private static Connection c = DbConnection.getDb();

	@Override
	public boolean insert(MyOrder order) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sql = "INSERT INTO myorder(orderid, blacktea, greentea, oolongtea, milktea, total, paytype, userid) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, order.getOrderId());
			ps.setInt(2, order.getBlackTea());
			ps.setInt(3, order.getGreenTea());
			ps.setInt(4, order.getOolongTea());
			ps.setInt(5, order.getMilkTea());
			ps.setInt(6, order.getTotal());
			ps.setInt(7, order.getPayType());
			ps.setString(8, order.getUserId());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert failed!");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public MyOrder selectOrderById(int id) {
		// TODO Auto-generated method stub
		MyOrder o = null;
		String sql = "SELECT * FROM myorder WHERE id = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				o = new MyOrder();
				o.setId(rs.getInt("id"));
				o.setOrderId(rs.getString("orderid"));
				o.setBlackTea(rs.getInt("blacktea"));
				o.setGreenTea(rs.getInt("greentea"));
				o.setOolongTea(rs.getInt("oolongtea"));
				o.setMilkTea(rs.getInt("milktea"));
				o.setTotal(rs.getInt("total"));
				o.setPayType(rs.getInt("paytype"));
				o.setUserId(rs.getString("userid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("select failed!");
			e.printStackTrace();
		}
		
		return o;
	}
	
	@Override
	public List<MyOrder> selectAllOrder() {//FIXME: only one
		// TODO Auto-generated method stub
		List<MyOrder> allOrder = new ArrayList();
		String sql = "SELECT * FROM myorder";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				MyOrder o = new MyOrder();
				o.setId(rs.getInt("id"));
				o.setOrderId(rs.getString("orderid"));
				o.setBlackTea(rs.getInt("blacktea"));
				o.setGreenTea(rs.getInt("greentea"));
				o.setOolongTea(rs.getInt("oolongtea"));
				o.setMilkTea(rs.getInt("milktea"));
				o.setTotal(rs.getInt("total"));
				o.setPayType(rs.getInt("paytype"));
				o.setUserId(rs.getString("userid"));
				
				allOrder.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("select failed!");
			e.printStackTrace();
		}
		
		return allOrder;
	}

	@Override
	public boolean update(MyOrder order) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sql = "UPDATE myorder SET orderid = ?, blacktea = ?, greentea = ?, oolongtea = ?, milktea = ?, total = ?, paytype = ?, userid = ? WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, order.getOrderId());
			ps.setInt(2, order.getBlackTea());
			ps.setInt(3, order.getGreenTea());
			ps.setInt(4, order.getOolongTea());
			ps.setInt(5, order.getMilkTea());
			ps.setInt(6, order.getTotal());
			ps.setInt(7, order.getPayType());
			ps.setString(8, order.getUserId());
			ps.setInt(9, order.getId());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("update failed!");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sql = "DELETE FROM myorder WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("delete failed!");
			e.printStackTrace();
		}
		return result;
	}

}
