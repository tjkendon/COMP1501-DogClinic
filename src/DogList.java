package src;

/**
 * Write a description of class DogList here.
 *
 * @author (your name)
 * @version February 7, 2018
 */
public class DogList
{

    private static final int LIST_SIZE = 100; // total number of dogs we can track
    private Dog[] dogs;
    private int fill;

    private String name;

    public DogList () {
        dogs = new Dog[100];
        fill = 0;
    }
    
    public DogList(String name) {
        dogs = new Dog[100];
        fill = 0;
        
        this.name = name;
    }
    
    public DogList (Dog[] dogs) {
        int i = 0;
        for (i = 0; i < dogs.length; i++) {
            this.dogs[i] = dogs[i];
        }
        fill = i;
    }

    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void addDog (Dog dog) {
        this.dogs[fill] = dog;
        fill++;
    }

    public void removeDog(Dog d) {

        int dogIndex = getIndexByID(d.getID());

        for (int i = dogIndex; (i < fill) && (i < LIST_SIZE - 1); i++) {
            dogs[i] = dogs[i + 1];
        }

    }

    public Dog getDog(int dogIndex) {
        return dogs[dogIndex];
    }
    
    public Dog getDogByID(int dogID) {
        for (int i = 0; i < fill; i++) {
            if (dogs[i].getID() == dogID) {
                return dogs[i];
            }
        }
        return null;
    }

    private int getIndexByID(int dogID) {
        for (int i = 0; i < fill; i++) {
            if (dogs[i].getID() == dogID) {
                return i;
            }
        }
        return -1;
    }    
    
    public Dog[] getDogs() {
        Dog[] shallowCopy = new Dog[fill];
        for (int i = 0; i < fill; i++) {
            shallowCopy[i] = dogs[i];
        }

        return shallowCopy;
    }

    public static DogList deepCopy (DogList original) {
        DogList deepCopy = new DogList();
        for (Dog d : original.getDogs()) {
            deepCopy.addDog(new Dog (d));
        }
        return deepCopy;

    }

}
