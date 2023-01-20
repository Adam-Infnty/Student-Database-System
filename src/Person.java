/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_managmentsystem;

/**
 *
 * @author adambaguma
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Person {
	private String fname; 
	private String sname;
	private int age;
	private String courses;
	private  String password;
	private int id;
	
	public Person(int id,String fname, String sname, int age, String course, String pass) {
		this.setId(id);
	this.setFname(fname);
	this.setSname(sname);
	this.setAge(age);
	this.setCourses(course);
	this.setPass(pass);
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the courses
	 */
	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}
	
	public static String getContent(String nfile){
		
		String response = null;
		String data = "";
		try {
		      File myObj = new File(nfile);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        data = data +","+ myReader.nextLine();//------------------------
		        //System.out.println(data);
		        response = data;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      //System.out.println("An error occurred.");
		      response = "An error occurred.";
		      e.printStackTrace();
		    }
		return response;
		}
	
	public static String WriteToFile(String Filename, String text) {
		String State ="State";
		    try {
		      FileWriter myWriter = new FileWriter(Filename);
		      myWriter.write(text);
		      myWriter.close();
		      System.out.println();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

		  return State;
		}
	/**
	 * @return the password
	 */
	public String getPass() {		
		return password;
	}
	/**
	 * @param password the password to set
	 */public void setPass(String fetch) {
		
		 password = fetch;
	 }
	public void setNewPass(String update) {
		String p = "";
		Random r = new Random();
	    String alphabet = "+SpsPPWy_.ZP!t🙈6kQ>}9(UC*)d${?k.9Qs4S♞@/Pv*/*Az@2bYu}v{URS@Ura?Yt%yVfDKdwbbv>BW)♫F4dz.V^B2V9eYFqLrUSW%Q.RrDQ4gPKE2Eh4MnNGQnr?§@Z";
		//String alphabet = "....................................................................................................................................";
	    for (int i = 0; i < alphabet.length(); i++) {
	    	//System.out.print(alphabet.charAt(r.nextInt(alphabet.length()))+""+password.charAt(r.nextInt(4)));
	    	p = p + alphabet.charAt(r.nextInt(alphabet.length()));
	    	 //System.out.println(p);
	    }
	    StringBuilder myName = new StringBuilder(p);
	    String salt = "";
	    for (int i = 0; i < update.length(); i++) {
	    	int temp = r.nextInt(p.length());
	    	salt = salt +"-"+ temp;
	    	
    	myName.setCharAt(temp, update.charAt(i));
	    }
		password = myName+""+salt;
	}

	public static String cipher(String pass, int shift) {
		String s = "";
	    int len = pass.length();
	    for(int x = 0; x < len; x++){
	        char c = (char)(pass.charAt(x) + shift);
	        if (c > 'z')
	            s += (char)(pass.charAt(x) - (26-shift));
	        else
	            s += (char)(pass.charAt(x) + shift);
	    }
	    return s;
	}
        
        public static String Ucipher(String pass, int shift) {
		String s = "";
	    int len = pass.length();
	    for(int x = 0; x < len; x++){
	        char c = (char)(pass.charAt(x) - shift);
	        if (c > 'z')
	            s += (char)(pass.charAt(x)  + (26+shift));
	        else
	            s += (char)(pass.charAt(x) - shift);
	    }
	    return s;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

		
	//creating the read to file funciton to access student and academics csv files

}

