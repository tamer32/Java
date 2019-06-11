package javaPostPackage.someMoreHere;
import java.io.*;
import java.util.Scanner;

public class Employee {
	public static String name;
	public static String lastName;
	public static String username;
	public static String password;
	
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public static String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void guiAfterLogin(){
		System.out.println("2. Изпращане на съобщение: ");
		System.out.println("3. Справка за всички съществували потребители: ");
		System.out.println("4. Прочитане на получени съобщения: ");
		System.out.println("5. Изход: ");
		
	}
	public static void registration() {
		Courier courier = new Courier();
		Scanner scan = new Scanner(System.in);
		System.out.print("Въведете име: ");
		String input = scan.nextLine();
		courier.setName(input);
		System.out.print("Въведете фамилия: ");
		String lastName = scan.nextLine();
		courier.setLastName(lastName);
		System.out.print("Въведете потребителско име: ");
		String username = scan.nextLine();
		courier.setUsername(username);
		System.out.print("Въведете парола: ");
		String password = scan.nextLine();
		courier.setPassword(password);
		
	}
}
