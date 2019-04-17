package fortheProject;

import java.util.ArrayList;
import java.util.Scanner;

public class WhichIsBigger {

	static ArrayList<Integer> sidesOfFigure;
	static int sum;
	static int typeOfFigure = 0;
	
	public static void input() {
	
		
		sidesOfFigure = new ArrayList<Integer>();
		
		for (int i = 0; i < typeOfFigure; i++) {
			
				System.out.println("What is side " + (i +1));
				Scanner reading = new Scanner(System.in);
				sidesOfFigure.add(reading.nextInt());
				
		}
		ifExist();
	 
	}
	public static void perimeter() {
		
		int sizeOfList = sidesOfFigure.size();
		 sum = 0;
		for (int i = 0; i <sizeOfList; i++) {
			sum += sidesOfFigure.get(i);
		}
		System.out.println("The sum is " + sum);
	}
	public static void ifExist() {
		int sumOfSides = 0;
		
		for (int i = 0; i < sidesOfFigure.size(); i++) {
			sumOfSides += sidesOfFigure.get(i);	
		}
		
		for (int i = 0; i < sidesOfFigure.size(); i++) {
		
			while(sidesOfFigure.get(i) > sumOfSides - sidesOfFigure.get(i)) {
				System.out.println("There can not be figure with this sides: ");
				input();
			};
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reading = new Scanner(System.in);
		System.out.println("Choose how many figures you want to calc and compare: ");
		int amountOfFig = reading.nextInt();
		int lastSum = 0;
		System.out.println("choose what type of figure you want: ");
		typeOfFigure = 0;
		
		
		do {
			typeOfFigure = reading.nextInt();
		}
		while(typeOfFigure < 3);
		
		// sum and compare perimeters of all figures
		do {
			input();
			perimeter();
			 if(lastSum < sum) {
				 lastSum = sum;
			 }
			amountOfFig--;
		}while(amountOfFig > 0);
		
		System.out.println("The N-lygon with the biggest perimeter is " + lastSum);
		
		
		
		
	}

}
