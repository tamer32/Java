package javaPostPackage.someMoreHere;

import java.util.Scanner;

public class OfficeEmployee extends Employee {

	public static String email;

	public static String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void officeEmpGuiAfterLogin(){
		System.out.print("1. Търсене на куриер: ");
		super.guiAfterLogin();
		
	}
	public void registrationForOfficeEmp() {
		super.registration();
		Scanner scan = new Scanner(System.in);
		System.out.print("Въведете E-mail ");
		String email = scan.nextLine();
		this.setEmail(email);
	}
	
	
}
