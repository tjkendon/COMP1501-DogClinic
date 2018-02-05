
/**
 * A class to allow us to use and test our Dog Class and our Dog Clinic Class.
 *
 * @author Tyson
 * @version February 5, 2018
 */
public class Driver
{
    
    public static void main(String[] args) {
        System.out.println("---");
        
        Dog d = new Dog("TestDog", 2010, 01, 01);
        Dog newDog = new Dog("OtherDog", 2011, 01, 01);

        System.out.println(d);
        System.out.println(newDog);
        
    }
    
    
}
