package dao;

import model.MyMember;

public interface MyMemberDao {
	
	boolean insert(MyMember member);
	
	int selectLastId();
	boolean selectUsername(String username);
	MyMember selectMemberByUsernameAndPassword(String username, String password);
	
	void update(String password, int id);
	boolean updateMemberInfo(String name, String address, String phone, int id);
	
	void delete(int id);

}
