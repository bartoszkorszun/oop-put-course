package ObjectProgrammingLab1;

/**
 * @author inf154030
 */
public class Cat {
    
    int age;
    String name;
    String sound;
    String favouriteToy;
    
    public Cat(int age, String name, String sound, String favouriteToy){
        
        this.age = age;
        this.name = name;
        this.sound = sound;
        this.favouriteToy = favouriteToy;
    }
    
    public String reaction() {
    	return "Cat came to the owner";
    }
    
    public String giveToy() {
    	return "Cat has been given a: " + favouriteToy;
    }
}
