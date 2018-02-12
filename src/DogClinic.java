package src;

import java.util.ArrayList;
import java.util.List;

/**
 * DogClinic Class to contain departments and dogs at a clinic and it provides 
 *
 * @author Tyson Kendon
 * @version Feburary 8, 2018
 */
public class DogClinic
{

    ArrayList<Department> departments; // a list of all the departments in the clinic

    /**
     * Creates a new DogClinic with an empty list of department.
     */
    public DogClinic() {

        departments = new ArrayList<>();

    }
    /**
     * Adds a new department to the clinic 
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }

    /**
     * Returns a list of all the departments.
     */
    public List<Department> getDepartments() {
        return departments;
    }

    /**
     * Returns a list of all DogsLists from all departments that contains 
     * the dogs in that departmetn.
     */
    public List<DogList> getAllDepartmentDogLists() {
        ArrayList<DogList> lists = new ArrayList<>();
        for (Department d : getDepartments()) {
            lists.add(d.getDogList());
        }
        return lists;
    }

    /**
     * Returns a list of all DogsLists from all departments containing the dogs that need
     * an appointment.
     */
    public List<DogList> getAllDepartmentNeedsAppointmentDogLists() {
        ArrayList<DogList> lists = new ArrayList<>();
        for (Department d : getDepartments()) {
            lists.add(d.getNeedsAppointmentList());
        }
        return lists;
    }

}
