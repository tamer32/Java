package javaPostPackage.someMoreHere;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	//!!!! Na4i Iliq vij po nadolu shte ti go markiram
	
	
	static ArrayList<String> fifo = new ArrayList<String>();
	public static int isThisCourier = 0;
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
		System.out.println("Потребителско име: ");
		String username = in.next();
		System.out.println("Парола: ");
		String password = in.next();
		Courier courier = new Courier();
			//check for username and password
		loginCheck(username, password);
		
		
				
	}
	public static int loginCheck(String username, String password) {
		// Ei tva se ebava... A otgore go vikam
		boolean correctUsername = false;
		boolean correctPass = false;
		boolean isCourier = false;
		for (int i = 0; i < fifo.size(); i++) {
			System.out.println(fifo.get(i));
			if(username == ("ime")){
				correctUsername = true;
			}if(password == (fifo.get(i))){
				correctPass = true;
			}if(fifo.get(i).matches("^[A-Z]{2}\\d{4}[A-Z]")){
				isCourier = true;
			}
		}	
		if(correctUsername == true && correctPass == true && isCourier == true) {
			return isThisCourier = 1;
		}else if (correctUsername == true && correctPass == true) {
			return isThisCourier = 2;
		}
		return 0;
	}
	
	public static void registrationLogicForOfficeEmp(){
		//creating the obj
		OfficeEmployee empN = new OfficeEmployee();
		Scanner scan = new Scanner(System.in);
		System.out.print("Въведете име: ");
		String input = scan.nextLine();
		empN.setName(input);
		System.out.print("Въведете фамилия: ");
		String lastName = scan.nextLine();
		empN.setLastName(lastName);
		System.out.print("Въведете потребителско име: ");
		String username = scan.nextLine();
		empN.setUsername(username);
		System.out.print("Въведете парола: ");
		String password = scan.nextLine();
		empN.setPassword(password);
		System.out.print("Въведете e-mail: ");
		String email = scan.nextLine();
		empN.setEmail(email);
		
	}
	
	public static void fileDataToList(File file) throws FileNotFoundException {
		
		Scanner fileReader = new Scanner(new File(file.getName())); 
		while(fileReader.hasNext()) {
			fifo.add(fileReader.next());
				
		}
		fileReader.close();
	}
	public static void listDataToFile(File file, PrintStream fileWriter) {
		for (int i = 0; i < fifo.size(); i++) {
			
			fileWriter.print(fifo.get(i));
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("users.dat");
		PrintStream fileWriter = new PrintStream(new FileOutputStream("users.dat",true));
		if(!(file.exists())) {
			file.createNewFile();	
		}	
		
		System.out.println(fifo.size());
		
		//pretty much the UI
		inputField();
		Scanner in = new Scanner(System.in);
		int inp = in.nextInt();
		
		switch (inp) {
		//for Registration
		case 1:
			registerField();
			inp = in.nextInt();
				switch(inp) {
				
				case 1:
					registrationLogicForOfficeEmp();
					fileWriter.print(OfficeEmployee.getName() + " ");
					fileWriter.print(OfficeEmployee.getLastName() + " ");
					fileWriter.print(OfficeEmployee.getUsername() + " ");
					fileWriter.print(OfficeEmployee.getPassword() + " ");
					fileWriter.print(OfficeEmployee.getEmail() + " ");
					fileWriter.close();
					if(file.exists()) {	
						fileDataToList(file);
					}
					main(args);
					
					break;
				}

			break;
		case 2:
			fileDataToList(file);
			loginField(in);
			if( isThisCourier == 1){
				Courier courier = new Courier();
				courier.courierGuiAfterLogin();
			}else if(isThisCourier == 2) {
				OfficeEmployee emp = new OfficeEmployee();
				emp.officeEmpGuiAfterLogin();
			}else {
				System.out.println("Грешно потребителско име или парола: ");
				main(args);
			}
			
			break;
		case 3:
			break;
		}
	fileWriter.close();
	}
	

}
