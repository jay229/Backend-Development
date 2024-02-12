package com.springcore.autowiring;

public class A {
	private B b;
	public A() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("A is created");
	}
	
	public A(B b) {
		super();
		this.b = b;
	}

	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}
	public void print() {
		System.out.println("Hello A");
	}
	public void display() {
		print();
		b.print();
	}
}
