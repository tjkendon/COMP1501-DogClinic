
import java.util.Calendar;
/**
 * A class to hold data about a dog at a clinic.
 *
 * @author Tyson Kendon
 * @version February 5, 2018
 */
public class Dog
{
    // static constant to hold the number of years 
    static final int DOG_YEARS_PER_HUMAN_YEAR = 7;
    // static variable to keep track of which ID a dog should receive next
    static int nextDogID = 1000;

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
    public Dog (String name, int year, int month, int day) {

        this.id = Dog.assignNextID();
        this.name = name;

        dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(year, month, day);

    }

    /**
     *
     * Copy constructor to create a new Dog based on the model of an
     * existing dog.
     *
     * Makes a deep copy of all instance variables.
     *
     */
    public Dog (Dog otherDog) {

        this.id = otherDog.getID();
        this.name = otherDog.getName();

        dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(otherDog.getDateOfBirth().get(Calendar.YEAR), 
            otherDog.getDateOfBirth().get(Calendar.MONTH),
            otherDog.getDateOfBirth().get(Calendar.DAY_OF_MONTH));

        if (otherDog.getLastAppointment != null) {
		lastAppointment = Calendar.getInstance();
        	lastAppointment.set(
			otherDog.lastAppointment().get(Calendar.YEAR), 
            		otherDog.lastAppointment().get(Calendar.MONTH),
            		otherDog.lastAppointment().get(Calendar.DAY_OF_MONTH));
	}

        
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

    public void setName(String newName) {
        this.name = newName;
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

    /**
     *
     * Returns the ID and the name of the dog as a string.
     *
     */
    public String toString() {
        return getID() + " - " + getName();
    }

    /**
     *
     * Checks if the ID, name and date of birth are equal for the dogs
     * and if they're not null, the date of last appointment.
     *
     * @param otherDog the dog to compare to
     *
     */
    public boolean equals (Dog otherDog) {

        if ((this.getID() == otherDog.getID()) &&
        (this.getName().equalsIgnoreCase(otherDog.getName())) &&
        (this.getDateOfBirth().equals(otherDog.getDateOfBirth()))) {

            if ((this.getLastAppointment() != null) && 
            (otherDog.getLastAppointment() != null)) {
                if (this.getLastAppointment().equals(
                    otherDog.getLastAppointment())) {
                           return true;
                } else {
                    return false;
                }
            }
                return true;
        }
        return false;

    }
 
    /**
     *
     * Class method that returns the next id a dog should be given and 
     * increments the counter as IDs are given out.
     *
     */
    public static int assignNextID() {
     return nextDogID++;
    }
    

    
    
}
