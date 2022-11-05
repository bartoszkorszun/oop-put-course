package ObjectProgrammingLab1;

/**
 * @author inf154030
 */
public class Owner {
    
    int age;
    String name;
    String favouritePet;
    App app;
    
    public Owner(int age, String name, String favouritePet){
        
        this.age = age;
        this.name = name;
        this.favouritePet = favouritePet;
    }
    
    public void callCat() {
    	System.out.println("\nOwner: Come here cat");
    	System.out.println(app.cat.reaction());
    }
    
    public void callDog() {
    	System.out.println("\nOwner: Come here dog");
    	System.out.println(app.dog.reaction());
    }
    
    public void giveToyToPupils() {
    	System.out.println("\nOwner: Let's play");
    	System.out.println(app.cat.giveToy() + "\n" + app.dog.giveToy());
    }
}
