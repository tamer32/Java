package javaPostPackage.someMoreHere;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static LinkedList<String> fifo = new LinkedList<String>();
	public static int isThisCourier = 0;
	
	
	public static int loginCheck(String username, String password) {
		
		boolean correctCreditentials = false;
		
		boolean isCourier = false;
		for (int i = 0; i < fifo.size(); i++) {
			//System.out.println(fifo.get(i));
			
			if(username.equals(fifo.get(i)) && password.equals(fifo.get(i + 1))){
				correctCreditentials = true;
				if(fifo.get(i + 4).matches("^[A-Z]{2}\\d{4}[A-Z]{2}")){
					isCourier = true;
					break;
				}
			}
		}	
		if(correctCreditentials == true && isCourier == true) {
			return isThisCourier = 1;
		}else if (correctCreditentials == true) {
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
		while(!checkIfExists(sInp)) {
			System.out.println("Потребителското име е сбъркано или не съществува! Моля опитайте отново");
			messedgeHandling(in,fileWriter);
			break;
		};
		fileWriter.print(sInp + " ");
		System.out.print("Моля въведете съобщението: ");
		String messedgeInput = in.nextLine();		
		Date date = new Date();
		fileWriter.print(messedgeInput + " ");
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("E yyyy.MM.dd");
		fileWriter.print(ft.format(date));
		
		System.out.println("Съобщението е изпратено успешно!");
	}
	
	public static void fileDataToList(File file) throws FileNotFoundException {
		
		Scanner fileReader = new Scanner(new File(file.getName())); 
		while(fileReader.hasNext()) {
			fifo.add(fileReader.next());
		}
		for (int i = 0; i < fifo.size(); i++) {
			if(checkIfExists(fifo.get(i))) {
				fifo.remove(i);
			}
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
		System.out.println(fifo.size());

		//pretty much the UI
		Utill.inputField();
		Scanner in = new Scanner(System.in);	
		int inp = 0;
		try {
			inp = in.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Стойността не е цяло число!");
			main(args);
		}
		switch (inp) {
		case 1:
			//register
			Utill.registerField();
			inp = in.nextInt();
				switch(inp) {
				
				case 1:
					Utill.registrationForOfficeEmployee(fileWriter);
					fileDataToList(file);
					main(args);
					
				case 2:
					Utill.registrationForCourier(fileWriter);
					fileDataToList(file);
					main(args);
				}
		case 2:
			//login
			fileDataToList(file);
			Utill.loginField(in);
			//inp = in.nextInt();
			if( isThisCourier == 1){
				Courier courier = new Courier();		
				Utill.courierLogin(in,courier);
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
				OfficeEmployee emp = new OfficeEmployee();
				Utill.employeeLogin(in,emp);
				switch(inp) {
				case 1:
					break;
				case 2:
					//sending message for Office Emp
					messedgeHandling(in,fileWriterMessages);
					emp.officeEmpGuiAfterLogin();
				}
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
