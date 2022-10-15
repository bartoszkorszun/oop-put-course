/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObjectProgrammingLab1Exercise2;

/**
 *
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
