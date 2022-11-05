package ObjectProgrammingLab1Exercise2;

/**
 * @author inf154030
 */

public class Age {
    
    int age;
    
    public Age(double age){
        this((int)age);
    }
    
    public Age(String age){
        this(Integer.parseInt(age));
    }
    
    public Age(float age){
        this((int)age);
    }
    
    public Age(int age){
        this.age = age;
    }
}
