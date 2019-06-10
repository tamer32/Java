package javaPostPackage.someMoreHere;

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
	
	
}
