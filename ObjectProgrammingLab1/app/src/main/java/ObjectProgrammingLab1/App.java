package ObjectProgrammingLab1;

import java.util.Scanner;

public class App {
    
    static Dog dog;
    static Cat cat;
    static Owner owner;
    static boolean continueLoop = true;

    public static void main(String[] args) {
        
        init();
        menu();
    }
    
    private static void init() {
    	dog = new Dog(5, "Fafik", "Woof", "Teddy Bear");
        cat = new Cat(3, "Filemon", "Miau", "Ball");
        owner = new Owner(23, "Bartosz", "Dog");
    }
    
    private static void menu() {
    	
    	while(continueLoop) {
    		
    		System.out.println("Press:\n1 - properties\n2 - Call Cat\n3 - Call Dog\n4 - Play with pupils");
        	
        	Scanner s1 = new Scanner(System.in);
        	int tmp = s1.nextInt();
        	
        	switch (tmp) {
    		case 1: {
    			printProperties();
    			break;
    		}
    		case 2: {
    			owner.callCat();
    			break;
    		}
    		case 3: {
    			owner.callDog();
    			break;
    		}
    		case 4: {
    			owner.giveToyToPupils();
    			break;
    		}
        	}
        	
        	System.out.println("\n>>Do you want to continue?\ny - yes\nn - no");
        	
        	Scanner s2 = new Scanner(System.in);
        	String temp = s2.nextLine();
        	
        	if(temp.equals("y")) {
        		s1.close();
        		s2.close();
        		
        		continueLoop = false;
        	}
    	}
    	
    	
    }
    
    private static void printProperties() {
    	
    	System.out.println("Dogs age: " + dog.age
                + "\nDogs name: " + dog.name
                + "\nDogs sound" + dog.sound
                + "\nDogs favourite toy: " + dog.favouriteToy);

    	System.out.println("Cats age: " + cat.age
                + "\nCats name: " + cat.name
                + "\nCats sound" + cat.sound
                + "\nCats favourite toy: " + cat.favouriteToy);

    	System.out.println("Owners age: " + owner.age
                + "\nOwners name: " + owner.name
                + "\nOwners favourite pet: " + owner.favouritePet);
    }
}
