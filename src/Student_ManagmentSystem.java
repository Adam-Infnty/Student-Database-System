/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.student_managmentsystem;

/**
 *
 * @author adambaguma
 */
public class Student_ManagmentSystem {

    public static void main(String[] args) {
        application.load("module.csv");
	    application.load("sFile.csv");
	    application.load("aFile.csv");
        Gui start = new Gui();
        start.setVisible(true);
        
    }
}
