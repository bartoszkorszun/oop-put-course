package ObjectProgrammingLab1;

/**
 * @author inf154030
 */
public class Dog {
 
    int age;
    String name;
    String sound;
    String favouriteToy;
    
    public Dog(int age, String name, String sound, String favouriteToy){
        
        this.age = age;
        this.name = name;
        this.sound = sound;
        this.favouriteToy = favouriteToy;
    }
    
    public String reaction() {
    	return "Dog came to the owner";
    }
    
    public String giveToy() {
    	return "Dog has been given a: " + favouriteToy;
    }
}
