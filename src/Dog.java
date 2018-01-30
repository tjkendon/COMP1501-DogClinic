
import java.util.Calendar;
/**
 * A class to hold data about a dog at a clinic.
 *
 * @author Tyson Kendon
 * @version January 29, 2018
 */
public class Dog
{
    private final int DOG_YEARS_PER_HUMAN_YEAR = 7;
    
    private int id; // unique identifier for the dog
    private String name; // owner's name of the dog
    private Calendar dateOfBirth; // date of the dog's birth
    private Calendar lastAppointment; // last time the dog was in the clinic

    /**
     * 
     * Creates a new dog with an id, a name and a birthdate.
     * 
     * @param id the unique identifier for the dog
     * @param name the dog's name
     * @param year the year of the dog's birth
     * @param month the month of the dog's birth
     * @param day the day of the dog's birth
     * 
     */
    public Dog (int id, String name, int year, int month, int day) {

        this.id = id;
        this.name = name;

        dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(year, month, day);

    }

    /**
     * 
     * Returns the unique id of the dog.
     * 
     */
    public int getID() {
        return id;
    }

    /**
     * 
     * Returns the name of the dog.
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * Returns the dog's date of birth as a Calendar.
     * 
     */
    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * 
     * Returns the date of the dog's last appointment at the clinic.
     * 
     * @return date of last appointment, or null if no last appointment
     */
    public Calendar getLastAppointment() {
        return lastAppointment;
    }

    
    /**
     * 
     * Returns the "human" age of the dog, the actual number of years
     * since it was born.
     * 
     */
    public int getAge() {

        Calendar now = Calendar.getInstance();
        
        int age = now.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        
        return age;
    }
    
    /**
     *
     *  Returns the "dog" age of the dog. The age is adjusted so that
     *  the age would be equivelent to the same lifespan in a human.
     *
     */
    public int getAgeInDogYears() {
     
        int dogAge = getAge() * DOG_YEARS_PER_HUMAN_YEAR;
        return dogAge;
    }
    
    /**
     * 
     * Sets the year, month and day of the dog's last appointment at
     * the clinic.
     * 
     * @param year the year of the appointment
     * @param month the month of the appointment
     * @param day the day of the appointment
     * 
     */
    public void setLastAppointment(int year, int month, int day) {
        
        lastAppointment = Calendar.getInstance();
        lastAppointment.set(year, month, day);
        
    }
    
    


}
