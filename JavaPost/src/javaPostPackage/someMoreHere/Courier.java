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
		this.setCarNumber(carNumber);
	}
}
