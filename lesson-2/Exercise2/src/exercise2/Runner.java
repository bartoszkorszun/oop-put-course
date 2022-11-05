package exercise2;

import java.util.Scanner;

public class Runner {

	private static FreshMovie fMovie;
	public static void main(String[] args) {
		
		fMovie = new FreshMovie("Kung Fu Panda", "Mark Osborne and John Stevenson");
		
		init();
	}
	
	private static void init() {
		
		System.out.println("Give grade to " + fMovie.title + " movie");
		
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		
		System.out.println(fMovie.giveGrade(grade));
		sc.close();
	}
}
