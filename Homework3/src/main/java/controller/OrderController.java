package controller;

import config.MyProduct;
import model.MyMember;
import model.MyOrder;
import service.impl.MyOrderServiceImpl;
import util.Tool;

public class OrderController {
	
	private MyOrder o = null;
	private MyOrderServiceImpl osi = new MyOrderServiceImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public MyMember getCurrentMember() {
		return Tool.readMyMember();
	}
	
	public void resetCurrentOrder() {
		o = new MyOrder(0, 0, 0, 0, 0, 1, getCurrentMember().getUserId());
	}
	
	public MyOrder getCurrentOrder() {
		if (o == null) {
			resetCurrentOrder();
		}
		
		return o;
	}
	
	public void saveCurrentOrder() {
		String orderId = "o" + System.currentTimeMillis();
		o.setOrderId(orderId);
		if (osi.createOrder(o)) {
			Tool.saveMyOrder(o);
		}
	}
	
	public void exportExcel() {
		String fileName = "MyOrder.xls";
    	String sheetName = "我的訂單";
    	Tool.createExcelFile(fileName, sheetName);
    	Tool.insertExcelFile(fileName, sheetName, getCurrentOrder());
	}
	
	public void setBlackTeaCount(int count) {
		o.setBlackTea(count);
	}
	
	public void setGreenTeaCount(int count) {
		o.setGreenTea(count);
	}
	
	public void setOolongTeaCount(int count) {
		o.setOolongTea(count);
	}
	
	public void setMilkTeaCount(int count) {
		o.setMilkTea(count);
	}
	
	public int getBlackTeaTotal() {
		return o.getBlackTea() * MyProduct.BlackTea.getPrice();
	}
	
	public int getGreenTeaTotal() {
		return o.getGreenTea() * MyProduct.GreenTea.getPrice();
	}
	
	public int getOolongTeaTotal() {
		return o.getOolongTea() * MyProduct.OolongTea.getPrice();
	}
	
	public int getMilkTeaTotal() {
		return o.getMilkTea() * MyProduct.MilkTea.getPrice();
	}
	
	public long calculate(boolean isVip, boolean isPay) {
		double blackTea = getBlackTeaTotal();
		double greenTea = getGreenTeaTotal();
		double oolongTea = getOolongTeaTotal();
		double milkTea = getMilkTeaTotal();
		double result = blackTea + greenTea + oolongTea + milkTea;
		
		if (isVip) {
			getCurrentMember().setRole(3);
			result = result * 0.4;
		} else {
			getCurrentMember().setRole(2);
			result = result * 1;
		}
		
		if (isPay) {
			getCurrentOrder().setPayType(2);
			if (result >= 1500) {
				result = result * 0.87;
			} else {
				result = result * 1;
			}
		} else {
			getCurrentOrder().setPayType(1);
		}
		getCurrentOrder().setTotal(Long.valueOf(Math.round(result)).intValue());
		
		return Math.round(result);
	}

}
