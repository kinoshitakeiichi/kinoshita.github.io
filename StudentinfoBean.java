package com.bean;
public class StudentinfoBean {
	private int Student_ID;
	private int Sport;
	private int Esport;
	private int Letter;
	private int Student_DomitoryID;
	private String Student_Name;
	private String Student_Sex;
	private String Student_Class;
	public int getStudent_DomitoryID() {
		return Student_DomitoryID;
	}
	public void setStudent_DomitoryID(int student_DomitoryID) {
		Student_DomitoryID = student_DomitoryID;
	}
	private String Student_State;
	private String className;
	private String SpecializedSubgect_Name;
	private String Department_Name;	
	public int getStudent_ID() {
		return Student_ID;
	}
	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}
	public String getStudent_Name() {
		return Student_Name;
	}
	public void setStudent_Name(String student_Name) {
		this.Student_Name = student_Name;
	}
	public String getStudent_Sex() {
		return Student_Sex;
	}
	public void setStudent_Sex(String student_Sex) {
		Student_Sex = student_Sex;
	}
	public String getStudent_Class() {
		return Student_Class;
	}
	public void setStudent_Class(String student_Class) {
		Student_Class = student_Class;
	}
	public String getStudent_State() {
		return Student_State;
	}
	public void setStudent_State(String student_State) {
		Student_State = student_State;
	}
	public int getSport() {
		return Sport;
	}
	public void setSport(int sport) {
		Sport = sport;
	}
	public int getEsport() {
		return Esport;
	}
	public void setEsport(int esport) {
		Esport = esport;
	}
	public int getLetter() {
		return Letter;
	}
	public void setLetter(int letter) {
		Letter = letter;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSpecializedSubgect_Name() {
		return SpecializedSubgect_Name;
	}
	public void setSpecializedSubgect_Name(String specializedSubgect_Name) {
		SpecializedSubgect_Name = specializedSubgect_Name;
	}
	public String getDepartment_Name() {
		return Department_Name;
	}
	public void setDepartment_Name(String department_Name) {
		Department_Name = department_Name;
	}	
}
