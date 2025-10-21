package controller;

import model.MyMember;
import service.impl.MyMemberServiceImpl;
import util.Tool;

public class LoginController {

	private MyMemberServiceImpl msi = new MyMemberServiceImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean login(String username, String password) {
		boolean result = false;
		
		MyMember m = msi.login(username, password);
		if (m != null) {
			Tool.saveMyMember(m);
			
			result = true;
		}
		
		return result;
	}

}
