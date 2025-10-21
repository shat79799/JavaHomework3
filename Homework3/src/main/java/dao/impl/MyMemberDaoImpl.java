package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MyMemberDao;
import model.MyMember;
import util.DbConnection;

public class MyMemberDaoImpl implements MyMemberDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MyMemberDaoImpl().selectLastId());
	}
	
	private static Connection c = DbConnection.getDb();

	@Override
	public boolean insert(MyMember member) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sql = "INSERT INTO mymember(userid, name, username, password, address, phone, role) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getUsername());
			ps.setString(4, member.getPassword());
			ps.setString(5, member.getAddress());
			ps.setString(6, member.getPhone());
			ps.setInt(7, member.getRole());
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
	public int selectLastId() {//FIXME: only one
		int lastId = 0;
		List<Integer> currentIds = new ArrayList();
		String sql = "SELECT id FROM mymember";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Integer id = rs.getInt("id");
				currentIds.add(id);
			}
			
			lastId = currentIds.getLast();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastId;
	}
	
	@Override
	public boolean selectUsername(String username) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sql = "SELECT * FROM mymember WHERE username = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("select failed!");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public MyMember selectMemberByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		MyMember m = null;
		String sql = "SELECT * FROM mymember WHERE username = ? AND password = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				m = new MyMember();
				m.setId(rs.getInt("id"));
				m.setUserId(rs.getString("userId"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setRole(rs.getInt("role"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public void update(String password, int id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE mymember SET password = ? WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("update failed!");
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean updateMemberInfo(String name, String address, String phone, int id) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sql = "UPDATE mymember SET name = ?, address = ?, phone = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setInt(4, id);
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
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM mymember WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("delete failed!");
			e.printStackTrace();
		}
	}

}
