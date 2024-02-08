package com.springcore.ci;

public class Student {
	private int studentId;
	private String studentName;
	private String studentAddress;
	private Marksheet marksheet;
	
	
	
	
	public Student(int studentId, String studentName, String studentAddress, Marksheet marksheet) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.marksheet = marksheet;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", marksheet=" + marksheet + "]";
	}

	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getStudentAddress() {
		return studentAddress;
	}


	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Marksheet getMarksheet() {
		return marksheet;
	}

	public void setMarksheet(Marksheet marksheet) {
		this.marksheet = marksheet;
	}
	
	
}
