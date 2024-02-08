package com.springcore.ci;

import java.util.List;

public class Marksheet {
	private int rollnum;
	private String fullName;
	List<Integer>marks;
	
	public Marksheet(int rollnum, String fullName, List<Integer> marks) {
		super();
		this.rollnum = rollnum;
		this.fullName = fullName;
		this.marks = marks;
	}

	public Marksheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Marksheet [rollnum=" + rollnum + ", fullName=" + fullName + ", marks=" + marks + "]";
	}

	public int getRollnum() {
		return rollnum;
	}

	public void setRollnum(int rollnum) {
		this.rollnum = rollnum;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}
	
	
	

}
