package com.techelevator;

public class Item {
	
	private String name;
	private double price;
	private String type;
	private String slotNum;
	private int quantity;
	
	public Item() {
		
	}

	public Item(String slotNum, String name, double price, String type, int quantity) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.slotNum = slotNum;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public void getSound() {
	}
	
	@Override
	public String toString() {
		return(name + " - $" + price);
	}
	
	
}
