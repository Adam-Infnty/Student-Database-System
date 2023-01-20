/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_managmentsystem;

/**
 *
 * @author adambaguma
 */
import java.util.List;

public class modules {
	private String moduleName;
	private static String StudentId; 
	private static int ModuleId;
	private static String Leader;
	private static String Moderator;
	
	
	public modules(int ModuleId,String name,String leader,String moderator,String Students) {
		this.setModuleName(name);
		this.setModuleId(ModuleId);
		this.setLeader(leader);
		this.setModerator(moderator);
		this.setStudentId(Students);
		}




	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return StudentId;
	}
	/**
	 * @param students the studentId to set
	 */
	public void setStudentId(String students) {
		StudentId = students;
	}
	/**
	 * @return the moduleId
	 */
	public String getModuleId() {
		String module = Integer.toString(ModuleId);
		return module;
	}
	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(int moduleId) {
		ModuleId = moduleId;
	}


	/**
	 * @return the leader
	 */
	public String getLeader() {
		return Leader;
	}


	/**
	 * @param leader the leader to set
	 */
	public void setLeader(String leader) {
		Leader = leader;
	}


	/**
	 * @return the moderator
	 */
	public String getModerator() {
		return Moderator;
	}
	/**
	 * @param moderator the moderator to set
	 */
	public void setModerator(String moderator) {
		Moderator = moderator;
	}


	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}


	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	int avg =0;
	
	
	
	public int calculate(int moduleId, List<String> studentList) {
		for(int i=0;i<studentList.size();i++) {
			//System.out.println(acess.sFile[Integer.parseInt(studentList.get(i))].getModuleGrade());
			avg = avg +application.sFile[Integer.parseInt(studentList.get(i))].getModuleGrade(moduleId);
		}
		avg = avg/studentList.size();
		//avg = avg +average;
	return avg;
	}

}

