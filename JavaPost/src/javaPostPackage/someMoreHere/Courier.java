package javaPostPackage.someMoreHere;

import java.util.Scanner;

import javaPostPackage.someMoreHere.*;

public class Courier extends Employee{
	public static String carNumber;

	public static String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public void courierGuiAfterLogin(){
		System.out.println("1. Справка за изминатите километри: ");
		super.guiAfterLogin();
		
	}
	public void registrationForCourier() {
		super.registration();
		Scanner scan = new Scanner(System.in);
		System.out.print("Въведете номер на колата: ");
		String carNumber = scan.nextLine();
		while (!(carNumber.matches("^[A-Z]{2}\\d{4}[A-Z]{2}"))) { 
			System.out.println("Невалиден номер на колата! Моля проверете го и опитайте отново");
			carNumber = scan.nextLine();
		}
		this.setCarNumber(carNumber);
	}
}
