package controller;

import model.MyMember;
import service.impl.MyMemberServiceImpl;
import util.Tool;

public class MemberController {
	
	private MyMember m = null;
	private MyMemberServiceImpl msi = new MyMemberServiceImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MemberController().isValidPhone("o987654321") ? "pass" : "fail");
	}

	public MyMember getCurrentMember() {
		m = Tool.readMyMember();
		
		return m;
	}
	
	public boolean isUpdatingMemberInfoSuccess(String name, String address, String phone) {
		boolean result = false;
		
		if (isValidPhone(phone)) {
			msi.updateMemberInfoById(name, address, phone, getCurrentMember().getId());
			
			result = true;
		}
		
		return result;
	}
	
	private boolean isValidPhone(String phone) {
		String regex = "^09\\d{8}$";
		
		return phone != null && phone.matches(regex);
	}
	
}
