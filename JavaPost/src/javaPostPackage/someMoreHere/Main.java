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
	
	
	static LinkedList<String> fifo = new LinkedList<String>();
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
		
		boolean correctUsername = false;
		boolean correctPass = false;
		boolean isCourier = false;
		for (int i = 0; i < fifo.size(); i++) {
			System.out.println(fifo.get(i));
			
			if(username.equals(fifo.get(i))){
				correctUsername = true;
			}if(password.equals( fifo.get(i))){
				correctPass = true;
			}if(fifo.get(i).matches("^[A-Z]{2}\\d{4}[A-Z]{2}")){
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
	
	public static boolean checkIfExists(String username, String emailOrCarNumber) {
		
		for (int i = 0; i < fifo.size(); i++) {
			if(username.equals(fifo.get(i))|| emailOrCarNumber.equals(fifo.get(i))){
				return true;
				
			}
		}
		return false;
	}
	public static boolean checkIfExists(String username) {
		
		for (int i = 0; i < fifo.size(); i++) {
			if(username.equals(fifo.get(i))){
				return true;
				
			}
		}
		return false;
	}
	public static void messedgeHandling(Scanner in,PrintStream fileWriter) {
		System.out.println("Моля въведете за кого е съобщението: ");
		String sInp = in.next();
		do {
			System.out.println("Потребителското име е сбъркано или не съществува! Моля опитайте отново");
			//messedgeHandling(in,fileWriter);
			
		}while(!(checkIfExists(sInp)));
		fileWriter.print(sInp);
		System.out.print("Моля въведете съобщението");
		sInp = in.nextLine();
				
		fileWriter.print(sInp);
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
		File fileMessages = new File("Messages.dat");
		PrintStream fileWriterMessages = new PrintStream(new FileOutputStream("Messages.dat",true));
		if(!(file.exists())) {
			file.createNewFile();	
		}	
		fileDataToList(file);
		System.out.println(fifo.size());
		Courier courier = new Courier();
		OfficeEmployee emp = new OfficeEmployee();
		//pretty much the UI
		inputField();
		Scanner in = new Scanner(System.in);
		int inp = in.nextInt();
		
		switch (inp) {
		
		case 1:
			//register
			registerField();
			inp = in.nextInt();
				switch(inp) {
				
				case 1:
					emp.registrationForOfficeEmp();
					while(checkIfExists(OfficeEmployee.getUsername(),OfficeEmployee.getEmail())){
						System.out.println("Потребителското име или Имейла вече съществуват, моля опитайте отново: ");
						emp.registrationForOfficeEmp();
					}
					fifo.clear();
					fileWriter.print(OfficeEmployee.getName() + " ");
					fileWriter.print(OfficeEmployee.getLastName() + " ");
					fileWriter.print(OfficeEmployee.getUsername() + " ");
					fileWriter.print(OfficeEmployee.getPassword() + " ");
					fileWriter.print(OfficeEmployee.getEmail() + " ");
					fileWriter.close();
					main(args);
					
				case 2:
					courier.registrationForCourier();
					while(checkIfExists(courier.getUsername(),courier.getCarNumber())) {
						System.out.println("Потребителското име или номерът на колата вече съществуват, моля опитайте отново: ");
						courier.registrationForCourier();
						
					}
					fifo.clear();
					fileWriter.print(Courier.getName() + " ");
					fileWriter.print(Courier.getLastName() + " ");
					fileWriter.print(Courier.getUsername() + " ");
					fileWriter.print(Courier.getPassword() + " ");
					fileWriter.print(Courier.getCarNumber() + " ");
					fileWriter.close();
					main(args);
				
				}
		
		case 2:
			//login
			loginField(in);
			if( isThisCourier == 1){
				courier.courierGuiAfterLogin();	
				inp =in.nextInt();
					switch(inp) {
					//after successful login as Courier
					case 1:
						break;
					case 2:
						//sending message for courier
						messedgeHandling(in,fileWriterMessages);
						break;
				}
			}else if(isThisCourier == 2) {
				emp.officeEmpGuiAfterLogin();
				in.nextInt();
				switch(inp) {
				case 1:
					break;
				case 2:
					//sending message for Office Emp
					messedgeHandling(in,fileWriterMessages);
				
				}
			
			}else {
				System.out.println("Грешно потребителско име или парола: ");
				fifo.clear();
				main(args);
			}
			
			break;
		case 3:
			break;
		}
	fileWriter.close();
	}
	

}
