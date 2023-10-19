import java.time.LocalDate;

public class Animal {
    private static int numOfAnimals = 0;

    // Animal Attributes.
    private String animalID;
    private String animalName;
    private LocalDate animalBirthDate;
    private String animalColor;
    private String animalGender;
    private String animalWeight;
    private String arrivingFrom;
    private LocalDate arrivalDate;


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
    public LocalDate getAnimalBirthDate() {
        return animalBirthDate;
    }
    public void setAnimalBirthDate(LocalDate animalBirthDate) {
        this.animalBirthDate = animalBirthDate;
    }
    public String getAnimalColor() {
        return animalColor;
    }
    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }
    public String getAnimalGender() {
        return animalGender;
    }
    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }
    public String getAnimalWeight() {
        return animalWeight;
    }
    public void setAnimalWeight(String animalWeight) {
        this.animalWeight = animalWeight;
    }
    public String getArrivingFrom() {
        return arrivingFrom;
    }
    public void setArrivingFrom(String arrivingFrom) {
        this.arrivingFrom = arrivingFrom;
    }
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(String arrivingFrom) {
        this.arrivalDate = arrivalDate;
    }


    public int getNumOfAnimals() {
        return numOfAnimals;
    }

    // Constructors
    public Animal() {
        System.out.println("\n A new animal was created!");
        numOfAnimals++;
    }

    public Animal(String animalID,
                  String animalName,
                  LocalDate animalBirthDate,
                  String animalColor,
                  String animalGender,
                  String animalWeight,
                  String arrivingFrom,
                  LocalDate arrivalDate ) {

        this.animalID = animalID;
        this.animalName = animalName;
        this.animalBirthDate = animalBirthDate;
        this.animalColor = animalColor;
        this.animalGender = animalGender;
        this.animalWeight = animalWeight;
        this.arrivingFrom = arrivingFrom;
        this.arrivalDate = arrivalDate;

        // increment the static int!
        numOfAnimals++;
    }

}
