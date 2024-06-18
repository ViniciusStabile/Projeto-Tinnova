package Entities;

public class Product {

	private String name;
	private int quantity;

	public Product(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;

	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
