package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Shiritori implements ShiritoriInterface {

	private ArrayList<String> words;
	public boolean gameOver;
	private Scanner scanner;
	
	public Shiritori() {
		words = new ArrayList<String>();
		scanner = new Scanner(System.in);
	}
	
	@Override
	public String play() { 
	    
	    System.out.println("Wellcome to Shiritori game!");
	    
	    String currentWord = "";
	    
	    while(true) {
	    	System.out.println("Enter a word:");
	    	String input = scanner.nextLine();
	    	
	    	if(words.contains(input)) {
	    		System.out.println(input + " has already been used!\n");
	    		gameOver = true;
	    		return "Game Over!";
	    	}else if(currentWord.length() > 0 && !input.startsWith(currentWord.substring(currentWord.length() - 1))) {
	    		System.out.println(input + " should start with the last letter of the previous word!\n");
	    		gameOver = true;
	    		return "Game Over!";
	    	}else {
	    		words.add(input);
	    		currentWord = input;
	    	}
	    }
	}

	@Override
	public String restart() {
		
		words.clear();
		gameOver = false;
		return "Game restarted\n";
	}

	@Override
	public String printWords() {
		
		return words.toString();
	}
}
