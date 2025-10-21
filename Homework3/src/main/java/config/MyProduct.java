package config;

public enum MyProduct {
	BlackTea(30, "紅茶"),
	GreenTea(30, "綠茶"),
	OolongTea(35, "烏龍茶"),
	MilkTea(40, "奶茶");
	
	private int price;
	private String description;
	
	MyProduct(int price, String description) {
		this.price = price;
		this.description = description;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
}
