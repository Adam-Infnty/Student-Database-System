/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_managmentsystem;

/**
 *
 * @author adambaguma
 */

import java.util.ArrayList;

public class Student extends Person{
	private String module;
	private String results;
	ArrayList<String> resultsList = new ArrayList<String>();
	ArrayList<String> resultsList2 = new ArrayList<String>();
	ArrayList<String> Mgrade = new ArrayList<String>();
	private int average = 0;
	private int max = 0;
	private int min = 100;
	private int moduleGrade = 0;
	
	public Student(int id,String fname, String sname, int age, String course,String module,String Pass,String result) {
		super(id,fname, sname, age, course,Pass);
		setModule(module);
		setResults(result);
	}
	
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	public int getAverage() {
		return average;
	}
	public void setAverage(int average) {
		this.average = average;
	}
	
	public String getInfo() {						
		String Information = "Name: " + getFname() +" "+ getSname() + "\n";
		Information = Information + "Age: " +getAge() + "\n";
		Information = Information + "Course: " + getCourses() + "\n";
		Information = Information + "Modules: " + this.module + "\n";
		Information = Information + "password: " + getPass() + "\n";
		for (int i= 0; i<resultsList.size();i++) {
			Information = Information + "all results:  " + getResults(getResults()) +"\n";
		}
		Information = Information + "all Assessments:  " + getResults(getResults()) +"\n";
		return Information;	
	}


	/**
	 * @return the results
	 */public String getResults() {
		
		 return results;
	 }
	    
	public String getResults(String input) {
		String a = "";
		String strMain = input;
		String[] arrSplit = strMain.split("&");
		
		for (int j = 0; j < arrSplit.length; j++) {
			
			String[] arrSplit2 = arrSplit[j].split("-");
			resultsList.add(arrSplit[j]);
			for (int i=0; i< resultsList.size();i++) {
				resultsList2.add(arrSplit2[2]);
				Mgrade.add(arrSplit2[0]);
			}
		}
		for (int i =0; i< resultsList.size();i++) { 
			a = a +resultsList.get(i)+"  |  ";
			}
			a = a +"\n \n"+Comput(resultsList2);
			
		return a;
	}
public String Comput(ArrayList<String> Grade) {
	moduleGrade = Integer.parseInt(Grade.get(0).toString());
	
	for (int i =0; i< resultsList2.size();i++) {
		average = average + Integer.parseInt(Grade.get(0).toString());
		 setModuleGrade(Integer.parseInt(Grade.get(0).toString()));
		if (Integer.parseInt(Grade.get(0).toString()) > max) {
			max = Integer.parseInt(Grade.get(0).toString());
	}else if(min > Integer.parseInt(Grade.get(0).toString())) {
		min =i;
		}
	}
	average = average / resultsList.size();
	String p ="Average Grade: "+average+"  |  Max Grade: "+max +"  |  Min Grade: "+min;
	 average = 0;
	 max = 0;
	 min = 0;
	 
return p;
}

	/**
	 * @param results the results to set
	 */
	public void setResults(String setresults) {
		this.results = setresults;
	}


	/**
	 * @return the moduleGrade
	 */
	public int getModuleGrade(int Module) {
		for (int i =0;i<Mgrade.size();i++) {
			
			if (Integer.parseInt(Mgrade.get(i))== Module) {
				return Integer.parseInt(resultsList2.get(2));
			}else {
				//System.out.println("not ");
			}
		}

		
		return moduleGrade;
	}


	/**
	 * @param moduleGrade the moduleGrade to set
	 */
	public void setModuleGrade(int moduleGrade) {
		this.moduleGrade = moduleGrade;
	}


}

