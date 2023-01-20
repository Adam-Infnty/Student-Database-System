/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_managmentsystem;

/**
 *
 * @author adambaguma
 */

public class academics extends Person {
	
	private String Pos;
	private String Loc;
	private boolean Stat;
	private String modules;
	private String Students;
	
	public academics(int id,String fname, String sname, int age, String course, String pos, String loc, String modules, String students, boolean stat,String pass) {
		super(id,fname, sname, age, course,pass);
		this.setPos(pos);
		this.setLoc(loc);
		this.setModules(modules);
		this.setStudents(students);
		this.setStat(stat);
		//this.setPass(pass);
		
	}
	
	public String getInfo() {
		String Information = "Name: " + getFname() +" "+ getSname() + "\n";
		Information = Information + "Age: " +getAge() + "\n";
		Information = Information + "Course: " + getCourses() + "\n";
		Information = Information + "Position: " + this.Pos + "\n";
		Information = Information + "Office Location: " + this.Loc + "\n";
		Information = Information + "Employment Status: " + this.Stat + "\n";
		Information = Information + "Modules Taught: " + this.modules + "\n";
		Information = Information + "Students Taught: " + this.Students + "\n";
		Information = Information + "password: " + getPass() + "\n";
		return Information;	
	}
	/**
	 * @return the pos
	 */
	public String getPos() {
		return Pos;
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(String pos) {
		Pos = pos;
	}

	/**
	 * @return the loc
	 */
	public String getLoc() {
		return Loc;
	}

	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		Loc = loc;
	}

	/**
	 * @return the stat
	 */
	public boolean isStat() {
		return Stat;
	}

	/**
	 * @param stat the stat to set
	 */
	public void setStat(boolean stat) {
		Stat = stat;
	}

	/**
	 * @return the modules
	 */
	public String getModules() {
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	public void setModules(String modules) {
		this.modules = modules;
	}

	/**
	 * @return the students
	 */
	public String getStudents() {
		return Students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(String students) {
		Students = students;
	}
	
	
	

}

