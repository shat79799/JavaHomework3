package controller;

import model.MyMember;
import service.impl.MyMemberServiceImpl;
import util.Tool;

public class RegisterController {

	private MyMemberServiceImpl msi = new MyMemberServiceImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean register(MyMember member) {
		boolean result = false;
		
		if (isValidPhone(member.getPhone())) {
			if (msi.checkMemberCanRegister(member)) {
				member.setRole(2);
				if (msi.register(member)) {
					Tool.saveMyMember(member);
				
					result = true;
				}
			}
		}
		
		return result;
	}
	
	private boolean isValidPhone(String phone) {
		String regex = "^09\\d{8}$";
		
		return phone != null && phone.matches(regex);
	}

}
