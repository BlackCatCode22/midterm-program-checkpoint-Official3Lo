import java.util.Date;

public class Animal {
    private static int numOfAnimals = 0;

    // Animal Attributes.
    private String animalID;
    private String animalName;
    private Date animalBirthDate;
    private String animalColor;
    private char animalGender;
    private float animalWeight;
    private String arrivingFrom;

    // Animal Getters and Setters
    public String getAnimalID() {
        return animalID;
    }
    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }
    public String getAnimalName() {
        return animalName;
    }
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    public Date getAnimalBirthDate() {
        return animalBirthDate;
    }
    public void setAnimalBirthDate(Date animalBirthDate) {
        this.animalBirthDate = animalBirthDate;
    }
    public String getAnimalColor() {
        return animalColor;
    }
    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }
    public char getAnimalGender() {
        return animalGender;
    }
    public void setAnimalGender(char animalGender) {
        this.animalGender = animalGender;
    }
    public float getAnimalWeight() {
        return animalWeight;
    }
    public void setAnimalWeight(float animalWeight) {
        this.animalWeight = animalWeight;
    }
    public String getArrivingFrom() {
        return arrivingFrom;
    }
    public void setArrivingFrom(String arrivingFrom) {
        this.arrivingFrom = arrivingFrom;
    }
    // Create a getter.
    // What type of method is this? Is it static and belongs to a class or...
    // is this method used with objects.

    public int getNumOfAnimals() {
        return numOfAnimals;
    }


    // Constructor
    public Animal() {
        System.out.println("\n A new animal was created!");
        numOfAnimals++;
    }



}
