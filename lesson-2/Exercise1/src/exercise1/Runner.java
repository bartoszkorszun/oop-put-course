package exercise1;

import java.awt.Color;
import java.util.Scanner;

public class Runner {

	private static Vehicle vehicle;
	private static String[] type = {"Car", "Plane", "Ship"};
	private static Color[] color = {Color.BLACK, Color.RED, Color.BLUE};
	
	public static void main(String[] args) {
		
		createYourVehicle();
		
		System.out.println("Great you made your vehicle!\n" + vehicle.toString());
	}
	
	private static void createYourVehicle() {
		
		System.out.println("Please choose the typeof the vehicle: ");
		for (int i=0; i<type.length; i++) {
			int tmp = i+1;
			System.out.println(tmp + " - " + type[i]);
		}
		
		Scanner sc1 = new Scanner(System.in);
		int choosenType = sc1.nextInt();
		
		String finalType = type[choosenType-1];
		
		System.out.println("\nPlease insert make of your vehicle");
		
		Scanner sc2 = new Scanner(System.in);
		String choosenMake = sc2.nextLine();
		
		System.out.println("\nPlease insert model of the vahicle");
		
		Scanner sc3 = new Scanner(System.in);
		String choosenModel = sc2.nextLine();
		
		System.out.println("\nPlease choose color of the vehicle");
		
		for (int i=0; i<color.length; i++) {
			int tmp = i+1;
			System.out.println(tmp + " - " + color[i]);
		}
		
		Scanner sc4 = new Scanner(System.in);
		int choosenColor = sc2.nextInt();
		
		Color finalColor = color[choosenColor-1];
		
		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
		
		vehicle = new Vehicle(finalType, choosenMake, choosenModel, finalColor);
	}
}
