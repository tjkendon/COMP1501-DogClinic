package src;

import java.util.Calendar;

/**
 * The Department holds a group of dogs for an administrative purpose. We are using
 * it to demonstrate how a composite class relation works between this and the 
 * {@link DogClinic DogClinic} class.
 *     
 * @author Tyson Kendon
 * @version February 8, 2018
 */
public class Department
{

    private DogList dogs; // a list of dogs attached to this department

    private String name; // the name of the department, should uniquely identify the department

    /**
     * Creates a new department with an empty list of dogs with the given name.
     */
    public Department(String name) {

        this.name = name;

        dogs = new DogList(name);

        
    }

    /**
     * Returns the name of this department.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds the new dog to this department's list of dogs.
     */
    public void addDog(Dog newDog) {

        dogs.addDog(newDog);

    }

    /**
     * Removes the dog with the given id from this department's list of dogs.
     */
    public void removeDog(int dogID) {

        dogs.removeDog(dogs.getDogByID(dogID));

    }

    /**
     * Sets the dog with dogID to have a last appointment of today;
     */
    public void setDogAppointment(int dogID) {
        Dog d = dogs.getDogByID(dogID);
        if (d != null) {
            d.setLastAppointmentNow();
        }
    }

    /**
     * Sets the dog with the dogId to have a last appointment on the given year month and day.
     */
    public void setDogAppointment(int dogID, int year, int month, int day) {
        Dog d = dogs.getDogByID(dogID);
        d.setLastAppointment(year, month, day);
    }

    /**
     * Returns a list of all the dogs in this department.
     */
    public DogList getDogList() {
        DogList safeDogs = DogList.deepCopy(dogs);
        safeDogs.setName(name + ":All Dogs");
        return safeDogs;
    }

    /**
     * Returns a list of all dogs in the this department which have not had an appointment
     * in the last year. Includes any dogs which have never had an appointment.
     */
    public DogList getNeedsAppointmentList() {

        DogList appointments = new DogList();

        Calendar cutOff = Calendar.getInstance();
        cutOff.set(Calendar.YEAR, cutOff.get(Calendar.YEAR) - 1);

        for (Dog d : dogs.getDogs()) {
            if ((d.getLastAppointment() == null) || 
            (d.getLastAppointment().before(cutOff))) {
                appointments.addDog(d);

            } 
        }

        DogList safeDogs = DogList.deepCopy(appointments);
        safeDogs.setName(name + ":Need Appointments");
        return safeDogs;

    }

}
