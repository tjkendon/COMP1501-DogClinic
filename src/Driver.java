package src;

/**
 * A class to allow us to use and test our Dog Class and our Dog Clinic Class.
 *
 * @author Tyson
 * @version February 7, 2018
 */
public class Driver
{

    public static void main(String[] args){ 

        System.out.println("-----");

        DogClinic clinic = new DogClinic();

        Department general = new Department("General Practice");
        Department grooming = new Department("Grooming");
        Department boarding = new Department("Boarding");

        //current appointment
        Dog fluffy = new Dog("Fluffy", 2010, 1, 1);
        fluffy.setLastAppointment(2017, 7, 21);
        Dog spot = new Dog("Spot", 2008, 1, 1);
        spot.setLastAppointment(2018, 0, 2);

        //old appointment
        Dog rover = new Dog("Rover", 2015, 11, 25);
        rover.setLastAppointment(2016, 11, 20);
        Dog fido = new Dog("Fido", 2018, 1, 7);
        fido.setLastAppointment(2017, 2, 1);

        // no appointment
        Dog yeller = new Dog("Yeller", 1957, 11, 25);
        Dog gromet = new Dog("Gromet", 1989, 4, 18);

        general.addDog(fluffy);
        general.addDog(spot);
        general.addDog(gromet);
        general.addDog(yeller);        
        
        grooming.addDog(fluffy);
        grooming.addDog(rover);

        boarding.addDog(fluffy);
        boarding.addDog(yeller);
        boarding.addDog(rover);

        clinic.addDepartment(general);
        clinic.addDepartment(grooming);
        clinic.addDepartment(boarding);

        System.out.println("All Dogs");
        for (DogList list : clinic.getAllDepartmentDogLists()) {
            printDogList(list);
        }

        System.out.println("Needs Appointments");
        for (DogList list : clinic.getAllDepartmentNeedsAppointmentDogLists()) {
            printDogList(list);
        }

        

    }
    public static void printDogList(DogList dogs) {
        System.out.println(dogs.getName());
        for (Dog d: dogs.getDogs()) {
            System.out.println(d);
        }

    }

}
