package service;

import model.MyMember;

public interface MyMemberService {
	
	boolean register(MyMember member);
	
	boolean checkMemberCanRegister(MyMember member);

	MyMember login(String username, String password);
	
	boolean updateMemberInfoById(String name, String address, String phone, int id);
	
	
}
