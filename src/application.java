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
import java.util.List;

public class application {
	//String strMain = Person.getContent("sFile.csv");
	static int EOF;
	static Student[] sFile = new Student[500];
	static academics[] aFile = new academics[21];
	static modules[] list = new modules[6];
	static int position;
	static List<String> studentListAdd = new ArrayList<String>();
	
public static String load(String a) {
	String FileName=a;
	
	//retrieving the student/academics details as a string
	String strMain = Person.getContent(FileName);
	String[] arrSplit = strMain.split(",");
	
	for (int j = 0; j < arrSplit.length; j++) {
	}
	
	int counter = 0;
	//turning the string given into an object for both sutdents and academics
	//if file is pulled from student then;
	if (FileName =="sFile.csv") {
		for (int j = 0; j < arrSplit.length/8; j++) {
			sFile[counter/8] = new Student(Integer.parseInt(arrSplit[counter+1]), arrSplit[counter + 2], arrSplit[counter + 3], Integer.parseInt(arrSplit[counter + 4]), arrSplit[counter + 5],arrSplit[counter + 6],arrSplit[counter+7],arrSplit[counter+8]);
			
			
			EOF = counter/8;
			counter = counter +8;
			
			}
		
	}else if (FileName=="aFile.csv") {
			for (int j = 0; j < arrSplit.length/11 ; j++) {
				aFile[counter/11] = new academics(Integer.parseInt(arrSplit[counter+1]),arrSplit[counter + 2], arrSplit[counter + 3], Integer.parseInt(arrSplit[counter + 4]), arrSplit[counter + 5], arrSplit[counter + 6], arrSplit[counter + 7], arrSplit[counter + 8], arrSplit[counter + 9], Boolean.parseBoolean(arrSplit[counter + 10]),arrSplit[counter + 11]);																													
				counter = counter +11;
				} 
		}else if((FileName=="module.csv")){
			for (int j = 0; j < arrSplit.length/5 ; j++) {
			list[counter/5] = new modules(Integer.parseInt(arrSplit[counter+1]),arrSplit[counter + 2], arrSplit[counter + 3], arrSplit[counter + 4],arrSplit[counter + 5]);	
			counter = counter +5;
			}
		}
		else{
			System.out.println("Error in file name");
		}
	
	return strMain;
}

//this searches the array of students comparing the user input with each student from within the array untill a match is found
public static String Search(String file,String input) {
	int c;
	//Testing the search feature;
			//if searching for academics change file to aFile
	if (file == "sFile.csv") {
		for (int j = 0; j < EOF+1; j++) {
			
			if(sFile[j] == null) {
				
				System.out.println("Student either does not exist or could not be found   : "+ j +"  --  "+EOF);
				 sFile[j].getInfo();
				j = sFile.length;
			}else if (sFile[j].getFname().toLowerCase().equals(input.toLowerCase())){
				c =j;
				position = c;
				
				return sFile[c].getInfo();
				
			}else {
				//System.out.println("Student either does not exist or could not be found");
				 //System.out.println(sFile[j].getInfo());
			}
			position = -1;
			}
			return "Student not found";
	}else {
		for (int j = 0; j <= EOF; j++) {
			if (aFile[j].getFname().toLowerCase().equals(input.toLowerCase())) {
				c =j;
				position = c;
				
				return aFile[c].getInfo();
			}else{
				//System.out.println("this is the module:   "+Module[j].getStudentId() +"   "+sFile[j].getId());
			}
			position = -1;
			}
			return "user not found";
	}}

public static String Edit(String Filename,String name,int num, String input) {
	String Information = "";
	/* the search feature compares every student in the database with the person being searched
        if the user is found it then looks at the position that needs to be edited and impliemtns the edit.*/
	if (Filename == "sFile.csv") {
		for (int j = 0; j < EOF; j++) {
			if (sFile[j].getFname().toLowerCase().equals(name.toLowerCase())) {
				System.out.println("attempting edit");
				
				switch (num) {
				  case 1:
					  sFile[j].setFname(input);
				    break;
				  case 2:
					  sFile[j].setSname(input);
				    break;
				  case 3:
					  sFile[j].setAge(Integer.parseInt(input));
				    break;
				  case 4:
					  sFile[j].setCourses(input);
				    break;
				  case 5:
					  sFile[j].setModule(input);
				    break;
				  case 6:
					  sFile[j].setNewPass(Person.cipher(input, sFile[j].getFname().length()+sFile[j].getSname().length()));
				    break;
				}
				Information = Information + sFile[j].getId() +",";
				Information = Information + sFile[j].getFname() +","+ sFile[j].getSname()+ ",";
				Information = Information + sFile[j].getAge()+ ",";
				Information = Information + sFile[j].getCourses()+ ",";
				Information = Information + sFile[j].getModule()+ ",";
				Information = Information + sFile[j].getPass();
				Information = Information + "\n";
				//System.out.println(Information);
			}else if(sFile[j].getFname().toLowerCase() != null){
				Information = Information + sFile[j].getId() +",";
				Information = Information + sFile[j].getFname() +","+ sFile[j].getSname()+ ",";
				Information = Information +sFile[j].getAge()+ ",";
				Information = Information + sFile[j].getCourses()+ ",";
				Information = Information + sFile[j].getModule()+ ",";
				Information = Information + sFile[j].getPass();
				Information = Information + "\n";
			}else {
				System.out.println("empty");
			}
			//System.out.println(j);
			Person.WriteToFile(Filename,Information);
			
			}
		Information ="";
			return "Edit Successful";
			
			
	}else if(Filename == "aFile.csv"){
		for (int j = 0; j < EOF; j++) {
			if (aFile[j].getFname().toLowerCase().equals(name.toLowerCase())) {
				System.out.println("attempting edit");
				
				switch (num) {
				  case 1:
					  aFile[j].setFname(input);
				    break;
				  case 2:
					  aFile[j].setSname(input);
				    break;
				  case 3:
					  aFile[j].setAge(Integer.parseInt(input));
				    break;
				  case 4:
					  aFile[j].setCourses(input);
				    break;
				  case 5:
					  aFile[j].setModules(input);
				    break;
				  case 6:
					  aFile[j].setFname(input);
				    break;
				  case 7:
					  aFile[j].setSname(input);
				    break;
				  case 8:
					  aFile[j].setAge(Integer.parseInt(input));
				    break;
				  case 9:
					  aFile[j].setCourses(input);
				    break;
				  case 10:
					  aFile[j].setModules(input);
				    break;
				  case 11:
					  aFile[j].setNewPass(Person.cipher(input, aFile[j].getFname().length()+aFile[j].getSname().length()));
				    break;
				}
				Information =  Information + aFile[j].getId() +",";
				Information = Information +aFile[j].getFname() +","+ aFile[j].getSname() + ",";
				Information =  Information  + aFile[j].getAge() + ",";
				Information = Information  + aFile[j].getCourses() + ",";
				Information = Information  + aFile[j].getPos() + ",";
				Information = Information + aFile[j].getLoc() + ",";
				Information = Information + aFile[j].getModules() + ",";
				Information = Information  + aFile[j].isStat() + ",";
				Information = Information +aFile[j].getStudents() + ",";
				Information = Information  +aFile[j].getPass();
				Information = Information + "\n";
			}else if(aFile[j].getFname().toLowerCase() != null){
				Information = Information + aFile[j].getId() +",";
				Information = Information + aFile[j].getFname() +","+ aFile[j].getSname() + ",";
				Information = Information  + aFile[j].getAge() + ",";
				Information = Information  + aFile[j].getCourses() + ",";
				Information = Information  + aFile[j].getPos() + ",";
				Information = Information + aFile[j].getLoc() + ",";
				Information = Information + aFile[j].getModules() + ",";
				Information = Information  + aFile[j].isStat() + ",";
				Information = Information +aFile[j].getStudents() + ",";
				Information = Information  +aFile[j].getPass();
				Information = Information + "\n";
			}else {
				System.out.println("empty");
			}
				Person.WriteToFile(Filename,Information);
		}
		Information ="";
	}else {
		System.out.println("file not found");
	}
	return "Edit Successful";
}



public static String Remove(String Filename,String name) {
	String Information = "";
			for (int j = 0; j < EOF; j++) {
			if (sFile[j].getFname().toLowerCase().equals(name.toLowerCase())) {
				System.out.println("attempting deletion");
			}else if(sFile[j].getFname().toLowerCase() != null){
				Information = Information + sFile[j].getId() +",";
				Information = Information + sFile[j].getFname() +","+ sFile[j].getSname()+ ",";
				Information = Information +sFile[j].getAge()+ ",";
				Information = Information + sFile[j].getCourses()+ ",";
				Information = Information + sFile[j].getModule()+ ",";
				Information = Information + sFile[j].getPass();
				Information = Information + "\n";
			}else {
				System.out.println("empty");
			}
				Person.WriteToFile(Filename,Information);
			}
			EOF = EOF -1;
			return "remove Successful";
}


public static String Add(String Filename,String fname,String sName,int age, String courses,String Module, String pass) {
	String Information ="";
			for (int j = 0; j < EOF+1; j++) {
				if(sFile[j].getFname().toLowerCase() == null){
					System.out.println("empty");	
			}else if(sFile[j].getFname().toLowerCase().equals(fname.toLowerCase())) {
				System.out.println("Student already exists");
				Information = Information + sFile[j].getId() +",";
				Information = Information + sFile[j].getFname() +","+ sFile[j].getSname()+ ",";
				Information = Information + sFile[j].getAge()+ ",";
				Information = Information + sFile[j].getCourses()+ ",";
				Information = Information + sFile[j].getModule()+ ",";
				Information = Information + sFile[j].getPass()+",";
				Information = Information +sFile[j].getResults() +"\n";
				
			}else {
				Information = Information + sFile[j].getId() +",";
				Information = Information + sFile[j].getFname() +","+ sFile[j].getSname()+ ",";
				Information = Information +sFile[j].getAge()+ ",";
				Information = Information + sFile[j].getCourses()+ ",";
				Information = Information + sFile[j].getModule()+ ",";
				Information = Information + sFile[j].getPass() +",";				
				Information = Information +sFile[j].getResults() +"\n";
			
			}
				
				//System.out.println( Information+","+EOF);
			}
			EOF = EOF +2;
			sFile[EOF] = new Student(EOF, fname, sName, age, courses, Module, pass,"4-08/12/2022-68-continue the hard work&4-08/12/2022-82-continue the hard work&4-08/12/2022-68-continue the hard work&4-08/12/2022-82-continue the hard work");
			sFile[EOF].setNewPass(Person.cipher(pass, sFile[EOF].getFname().length()+sFile[EOF].getSname().length()));
				Information = Information + sFile[EOF].getId() +",";
				Information = Information + sFile[EOF].getFname() +","+ sFile[EOF].getSname()+ ",";
				Information = Information + sFile[EOF].getAge()+ ",";
				Information = Information + sFile[EOF].getCourses()+ ",";
				Information = Information + sFile[EOF].getModule()+ ",";
				Information = Information + sFile[EOF].getPass()+",";
				Information = Information + sFile[EOF].getResults() +"\n";
					System.out.println(sFile[EOF].getInfo());
			Person.WriteToFile(Filename,Information);
			return "adding student Successful";
}
public static boolean login(String file,String string) {
	boolean state = false;
			if (file=="aFile.csv") {
				if (position >= 0){
					if (Decrypt(aFile[position].getPass()).toLowerCase().equals(string.toLowerCase())){
						System.out.println("success");
						state = true;
					}else {
						state = false;
					} 
				}else {}
			}else {
				if (position >= 0){
					if (Decrypt(sFile[position].getPass()).toLowerCase().equals(string.toLowerCase())){
						System.out.println("success");
						state = true;
					}else {
						state = false;
					} 
				}else {}
			}
	return state;
}
static List<String> studentList = new ArrayList<String>();
public static String getModulestudents(String module) {

	for (int j = 0; j < list.length; j++) {
		if(list[j].getModuleName().toLowerCase().equals(module.toLowerCase())) {
			String strMain = list[j].getStudentId();
			String[] arrSplit = strMain.split("-");
			for (int i = 1; i < arrSplit.length; i++) {
				studentList.add(arrSplit[i]);
			}		    
			j = list.length;  
		}else {
			
		}
	}
	String SLIST = "\n";
	for (int i =0; i < studentList.size(); i++) {
		//System.out.println(sFile[Integer.parseInt(studentList.get(i))].getInfo());
		SLIST = SLIST +""+sFile[Integer.parseInt(studentList.get(i))].getInfo()+"\n";
	}
	return SLIST;
}
public static String moduleDetails(String search) {
	String Information = null;
	for (int j = 0; j < list.length; j++) {
		if (list[j].getModuleName().toLowerCase().equals(search.toLowerCase())) {
			Information = "Module Id: " + list[j].getModuleId() +"\n"+"Module name:"+ list[j].getModuleName() + "\n";
			Information = Information + "Leader: " + aFile[Integer.parseInt(list[j].getLeader())-400].getFname()+" "+ aFile[Integer.parseInt(list[j].getLeader())-400].getSname() + "\n";
			Information = Information + "Moderator: " + aFile[Integer.parseInt(list[j].getModerator())-400].getFname()+" "+aFile[Integer.parseInt(list[j].getModerator())-400].getSname() + "\n";
			Information = Information + "Students Taking Module: " + "\n"+ getModulestudents(search) + "\n";
			Information = Information + "Module Average Grade:  " + list[j].calculate(Integer.parseInt(list[j].getModuleId()),studentList);
			j = list.length;
		}else {
			//System.out.println(list[j].getModuleName()+"   "+j);
			System.out.println("module not found");
		}
		
	}
	return Information;
};

public static String ModuleAdd(String module,String Add) {
	int addcounter = 0;
	//get student id
	
	for (int j = 0; j < list.length; j++) {
		if(list[j].getModuleName().toLowerCase().equals(module.toLowerCase())) {
			String strMain = list[j].getStudentId();
			String[] arrSplit = strMain.split("-");
			for (int i = 1; i < arrSplit.length; i++) {
				//studentList.add(arrSplit[i]);
			}		    
			j = list.length;  
		}else {
			
		}
	}
	for (int i =0; i < EOF; i++) {
		//System.out.println(sFile[Integer.parseInt(studentList.get(i))].getInfo());
		if (sFile[i].getFname().toLowerCase().equals(Add.toLowerCase())) {
			addcounter = i;
		
	}else {
		}
	}
	studentList.add(Integer.toString(sFile[addcounter-1].getId()));
	//write to module database.
	
	String Information = "";
	for (int j = 0; j < list.length; j++) {
		if (list[j].getModuleName().toLowerCase().equals(module.toLowerCase())) {
			//list[j].getStudentId() = studentListAdd;
			//System.out.println(sFile[addcounter].getId()+"  --"+studentList);
			Information = Information + list[j].getModuleId() +"," +  list[j].getModuleName() + ",";
			Information = Information +  aFile[Integer.parseInt(list[j].getLeader())-400].getId()+",";
			Information = Information +  aFile[Integer.parseInt(list[j].getModerator())-400].getId()+",";
			for (int i=0; i < studentList.size()-1;i++) {
				Information = Information +  studentList.get(i)+ "-";
			}
			Information = Information +  studentList.get(studentList.size()-1)+"\n";
			
		}else {
			Information = Information + list[j].getModuleId() +"," + list[j].getModuleName() + ",";
			Information = Information +  list[j].getLeader()+",";
			Information = Information +  list[j].getModerator()+",";
			Information = Information +  list[j].getStudentId() + "\n";
		}
		//Person.WriteToFile("module.csv",Information);
		
	}
	
	System.out.println(Information);
	String a = "Student "+sFile[Integer.parseInt(studentList.get(studentList.size()-1))].getInfo()+"Added to module";
	return a;
}
public static String RemoveStudentFromModule(String module,String Remove) {
	int removecount=0;
	for (int i =0; i < EOF; i++) {
		//System.out.println(sFile[Integer.parseInt(studentList.get(i))].getInfo());
		if (sFile[i].getFname().toLowerCase().equals(Remove.toLowerCase())) {
			removecount = i;
		
	}else {
		}
	}
	
	studentList.remove(Integer.toString(sFile[removecount-1].getId()));
	//write to module database.
	
	String Information = "";
	for (int j = 0; j < list.length; j++) {
		if (list[j].getModuleName().toLowerCase().equals(module.toLowerCase())) {
			//list[j].getStudentId() = studentListAdd;
			//System.out.println(sFile[addcounter].getId()+"  --"+studentList);
			Information = Information + list[j].getModuleId() +"," +  list[j].getModuleName() + ",";
			Information = Information +  aFile[Integer.parseInt(list[j].getLeader())-400].getId()+",";
			Information = Information +  aFile[Integer.parseInt(list[j].getModerator())-400].getId()+",";
			for (int i=0; i < studentList.size()-1;i++) {
				Information = Information +  studentList.get(i)+ "-";
			}
			Information = Information +  studentList.get(studentList.size()-1)+"\n";
			
		}else {
			Information = Information + list[j].getModuleId() +"," + list[j].getModuleName() + ",";
			Information = Information +  list[j].getLeader()+",";
			Information = Information +  list[j].getModerator()+",";
			Information = Information +  list[j].getStudentId() + "\n";
		}
		//Person.WriteToFile("module.csv",Information);
		
	}
	System.out.println(Information);
	return Remove;
}
public static String Decrypt(String input) {
	String word= "";
	List<String> pass = new ArrayList<String>();
	String strMain = input;
	String[] arrSplit = strMain.split("-");
	for (int j = 1; j < arrSplit.length; j++) {
		pass.add(arrSplit[j]);
	}
    for (int i = 0; i < pass.size(); i++) {
	word = word +""+input.charAt(Integer.parseInt(pass.get(i)));
    }
   String word2 = Person.Ucipher(word,sFile[position].getFname().length()+sFile[position].getSname().length());
   System.out.println(word2+"    "+input);
  return word2;
};
}


