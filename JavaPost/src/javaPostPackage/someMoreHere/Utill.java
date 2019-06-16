package javaPostPackage.someMoreHere;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utill {
	public static void inputField() {
		System.out.println("Моля, въведете номера на желаната функция");
		System.out.println("1. Регистрация");
		System.out.println("2. Вход в системата");
		System.out.println("3. Изход");
		
	}
	public static void registerField() {
		System.out.println("Изберете вида на профила: ");
		System.out.println("1. Офис-служител");
		System.out.println("2. Куриер");
		System.out.println("3. Назад");
	}
	public static void loginField(Scanner in) {
		
		System.out.println("Моля въведете данните си: ");
		System.out.print("Потребителско име: ");
		String username = in.next();
		System.out.print("Парола: ");
		String password = in.next();
		Courier courier = new Courier();
			//check for username and password
		Main.loginCheck(username, password);		
	}
	
	public static void registrationForOfficeEmployee(PrintStream fileWriter) {
	
				OfficeEmployee emp = new OfficeEmployee();
				emp.registrationForOfficeEmp();
				while(Main.checkIfExists(OfficeEmployee.getUsername(),OfficeEmployee.getEmail())){
					System.out.println("Потребителското име или Имейла вече съществуват, моля опитайте отново: ");
					emp.registrationForOfficeEmp();
				}
				fileWriter.print(OfficeEmployee.getName() + " ");
				fileWriter.print(OfficeEmployee.getLastName() + " ");
				fileWriter.print(OfficeEmployee.getUsername() + " ");
				fileWriter.print(OfficeEmployee.getPassword() + " ");
				fileWriter.println(OfficeEmployee.getEmail() + " ");
				fileWriter.close();
			}
	
	public static void registrationForCourier(PrintStream fileWriter){
		Courier courier = new Courier();
		courier.registrationForCourier();
		while(Main.checkIfExists(courier.getUsername(),courier.getCarNumber())) {
			System.out.println("Потребителското име или номерът на колата вече съществуват, моля опитайте отново: ");
			courier.registrationForCourier();
			
		}
		fileWriter.print(Courier.getName() + " ");
		fileWriter.print(Courier.getLastName() + " ");
		fileWriter.print(Courier.getUsername() + " ");
		fileWriter.print(Courier.getPassword() + " ");
		fileWriter.println(Courier.getCarNumber() + " ");
		fileWriter.close();
	}
	public static void courierLogin(Scanner in, Courier courier) {
		courier.courierGuiAfterLogin();	
		try {
			int inp =in.nextInt();
		}catch(InputMismatchException ex) {
			System.out.println("Стойността не е цяло число!");
			courier.courierGuiAfterLogin();	
		}
		
	}
	public static void employeeLogin(Scanner in, OfficeEmployee emp) {
		emp.officeEmpGuiAfterLogin();
		try {in.nextInt();
		
		} catch(InputMismatchException ex) {
			System.out.println("Стойността не е цяло число!");
			emp.officeEmpGuiAfterLogin();
		}
	}

}
