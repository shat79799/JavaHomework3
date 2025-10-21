package service.impl;

import dao.impl.MyMemberDaoImpl;
import model.MyMember;
import service.MyMemberService;

public class MyMemberServiceImpl implements MyMemberService {
	
	private MyMemberDaoImpl mdi = new MyMemberDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean register(MyMember member) {
		// TODO Auto-generated method stub
		String userId = null;
		int newId = mdi.selectLastId() + 1;
		if (0 < newId && newId < 10) {
			userId = "u000" + newId;
		} else if (10 < newId && newId < 100) {
			userId = "u00" + newId;
		} else if (100 < newId && newId < 1000) {
			userId = "u0" + newId;
		} else if (1000 < newId && newId < 10000) {
			userId = "u" + newId;
		} else {
			userId = "u0000"; 
		}
		member.setUserId(userId);
		
		return mdi.insert(member);
	}

	@Override
	public boolean checkMemberCanRegister(MyMember member) {
		// TODO Auto-generated method stub
		return !mdi.selectUsername(member.getUsername());
	}

	@Override
	public MyMember login(String username, String password) {
		// TODO Auto-generated method stub
		return mdi.selectMemberByUsernameAndPassword(username, password);
	}

	@Override
	public boolean updateMemberInfoById(String name, String address, String phone, int id) {
		// TODO Auto-generated method stub
		return mdi.updateMemberInfo(name, address, phone, id);
	}

}
