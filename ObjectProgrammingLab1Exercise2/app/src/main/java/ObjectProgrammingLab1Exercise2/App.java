/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ObjectProgrammingLab1Exercise2;

public class App {
    
    static Age age;

    public static void main(String[] args) {
        
        age = new Age(23);
        System.out.println("Age int: " + age.age);
        age = new Age(25.5);
        System.out.println("Age double: " + age.age);
        age = new Age("27");
        System.out.println("Age string: " + age.age);
        age = new Age(21.1234);
        System.out.println("Age float: " + age.age);
    }
}