package model;

import java.io.Serializable;

public class MyOrder implements Serializable {
	
	private Integer id;
	private String orderId;
	private Integer blackTea;
	private Integer greenTea;
	private Integer oolongTea;
	private Integer milkTea;
	private Integer total;
	private Integer payType;
	private String userId;
	
	public MyOrder() {
		super();
	}

	public MyOrder(Integer blackTea, Integer greenTea, Integer oolongTea, Integer milkTea, Integer total, Integer payType, String userId) {
		super();
		this.blackTea = blackTea;
		this.greenTea = greenTea;
		this.oolongTea = oolongTea;
		this.milkTea = milkTea;
		this.total = total;
		this.payType = payType;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getBlackTea() {
		return blackTea;
	}

	public void setBlackTea(Integer blackTea) {
		this.blackTea = blackTea;
	}

	public Integer getGreenTea() {
		return greenTea;
	}

	public void setGreenTea(Integer greenTea) {
		this.greenTea = greenTea;
	}

	public Integer getOolongTea() {
		return oolongTea;
	}

	public void setOolongTea(Integer oolongTea) {
		this.oolongTea = oolongTea;
	}

	public Integer getMilkTea() {
		return milkTea;
	}

	public void setMilkTea(Integer milkTea) {
		this.milkTea = milkTea;
	}

	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getPayType() {
		return payType;
	}
	
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
