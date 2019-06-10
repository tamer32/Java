package javaPostPackage.someMoreHere;
import java.io.*;

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
		System.out.print("2. Изпращане на съобщение: ");
		System.out.print("3. Справка за всички съществували потребители: ");
		System.out.print("4. Прочитане на получени съобщения: ");
		System.out.print("5. Изход: ");
		
	}
}
