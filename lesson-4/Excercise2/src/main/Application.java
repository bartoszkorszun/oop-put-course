package main;

import java.util.Scanner;

public class Application {

	private static Scanner scanner;
	
	public static void main(String[] args) {
		
		Shiritori game = new Shiritori();
		scanner = new Scanner(System.in);
		boolean play = true;
		
		while(true) {
			
			if(play)
				game.play(); play = false;
			
			System.out.println("What would you like to do now?\nR - restart\nW - print words from this game\nE - exit\n");
			String input = scanner.nextLine();
			
			if(input.equals("E")) {
				System.out.println("Thank you for playing! :)");
				break;
			}else if(input.equals("R")){
				game.restart();
				play = true;
			}else if(input.equals("W")) {
				System.out.println(game.printWords() + "\n");
			}else {
				System.out.println("Invalid input! Try again\n");
			}
		}
	}
}
