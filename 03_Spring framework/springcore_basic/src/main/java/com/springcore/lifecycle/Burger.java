package com.springcore.lifecycle;

public class Burger {
	private double price;

	public Burger(double price) {
		super();
		this.price = price;
	}

	public Burger() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Burger [price=" + price + "]";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public void init() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Drininig pepsi: inside init");
		
	}

	
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Throughing bottle: inside destroy method");
		
	}
}
