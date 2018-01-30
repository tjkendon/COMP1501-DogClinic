
/**
 * DogClinic Class to drive examples of the Dog Class.
 *
 * @author Tyson Kendon
 * @version January 29, 2018
 */
public class DogClinic
{

    private Dog dog1;
    private Dog dog2;

    /**
     * Constructor for objects of class DogClinic
     */
    public DogClinic()
    {
        dog1 = new Dog(1, "Fido", 2010, 1, 28);
        
        System.out.println(dog1.getAge());
    }

}
