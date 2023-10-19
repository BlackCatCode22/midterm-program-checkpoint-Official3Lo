import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Zoo Program Patch Notes: 10-18-23 [!] last update before code presentation on Oct 19 at 10:15 AM

public class Main {

    // Creating the genUniqueID method
    private static HashMap<String, Integer> speciesCounter = new HashMap<>(); // [!]
    private static String genUniqueID(String theSpecies) {
        String prefix = "";
        int suffix = 0;
        // Create new data ID for each animal
        if (!speciesCounter.containsKey(theSpecies)) {
            speciesCounter.put(theSpecies, 0);
        }
        // Increment counter for the animal species.
        if (theSpecies.contains("hyena")) {
            prefix = "Hy";
            speciesCounter.put(theSpecies, speciesCounter.get(theSpecies) + 1);
        }
        if (theSpecies.contains("tiger")) {
            prefix = "Ti";
            speciesCounter.put(theSpecies, speciesCounter.get(theSpecies) + 1);
        }
        if (theSpecies.contains("lion")) {
            prefix = "Li";
            speciesCounter.put(theSpecies, speciesCounter.get(theSpecies) + 1);
        }
        if (theSpecies.contains("bear")) {
            prefix = "Br";
            speciesCounter.put(theSpecies, speciesCounter.get(theSpecies) + 1);
        }
        // Get the counter for the animal species.
        suffix = speciesCounter.get(theSpecies);
        // Generate the suffix number for the unique ID.
        String suffixNumber = String.format("%02d", suffix);
        // Return the unique ID.
        return prefix + suffixNumber;
    }

    private static LocalDate calcBirthdate(int yearsOld, String birthSeason) {

        int year = 2023 - yearsOld;
        String monthDay;
        String newDate;

        switch (birthSeason) {
            case "spring":
                monthDay = "03-21";
                break;
            case "summer":
                monthDay = "05-21";
                break;
            case "fall":
                monthDay = "08-21";
                break;
            case "winter":
                monthDay = "12-21";
                break;
            default:
                monthDay = "01-01";
                break;
        }
        newDate =  Integer.toString(year) + "-" + monthDay;

        // Create a LocalDate object
        LocalDate birthDate = LocalDate.parse(newDate);

        return birthDate;
    }

    public static double calculateAgeInDecimalYears(LocalDate animalArrivalDate, LocalDate birthDate) {
        long yearsDifference = ChronoUnit.YEARS.between(birthDate, animalArrivalDate);

        LocalDate adjustedBirthDate = birthDate.plusYears(yearsDifference);

        long daysInCurrentYear = (animalArrivalDate.isLeapYear()) ? 366 : 365;
        long daysDifference = ChronoUnit.DAYS.between(adjustedBirthDate, animalArrivalDate);

        return yearsDifference + (double) daysDifference / daysInCurrentYear;
    }

    private static String genZooHabitat(String animalSpecies) {
        String habitat = "";

        switch (animalSpecies) {
            case "hyena":
                habitat = "Hyena Habitat: \n";
                break;
            case "lion":
                habitat = "Lion Habitat: \n";
                break;
            case "tiger":
                habitat = "Tiger Habitat: \n";
                break;
            case "bear":
                habitat = "Bear Habitat: \n";
                break;
            default:
                habitat = "The Void \n";
        }

        return habitat;
    }

    private static LocalDate genBirthDay(double x, LocalDate y){ // [!]
        double age = x;
        LocalDate bDay = LocalDate.now();

        return bDay;
    }

    public static void main(String[] args) {
        System.out.println("\n\n+------------------------------------+");
        System.out.println("|             Welcome to             |");
        System.out.println("|          Sit's Zoo Program         |");
        System.out.println("+------------------------------------+\n\n");
        // Load all species classes with name.
        // Call the static methods to create a lists of names.
        Lion.inputLionNames();
        Tiger.inputTigerNames();
        Bear.inputBearNames();
        Hyena.inputHyenaNames();

        // Create ArrayLists to hold the animal objects.
        ArrayList<Hyena> hyenaArrayList = new ArrayList<>();
        ArrayList<Lion> lionArrayList = new ArrayList<>();
        ArrayList<Tiger> tigerArrayList = new ArrayList<>();
        ArrayList<Bear> bearArrayList = new ArrayList<>();

        // Open a csv file using the split() method on a string object
        String path = "C:\\Users\\BE218\\IdeaProjects\\untitled\\src\\arrivingAnimals.txt";
        String myFileLine = "";

        // Variables for constructing animal objects.
        String animalID;
        String animalName;
        LocalDate animalBirthDate;
        String animalColor;
        String animalGender;
        String animalWeight;
        String animalFrom;
        LocalDate animalArrivalDate;

        // Variable that help us create animal data
        int ageInYears = 0;
        String species = "";
        String birthSeason = "";

        // Habitat Variables and Lists
        HashMap<Animal, String> habitatMap = new HashMap<>();
        HashSet<String> uniqueHabitats = new HashSet<>();
        List<Animal> animalsInHabitat = new ArrayList<>();

        // FileReader to Read arrivingAnimals.txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int myCounter = 1;
            while ((myFileLine = reader.readLine()) != null) {
                // The input data from arrivingAnimals looks like this:
                // 4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia

                // Create a String array named myArrayOfAnimalData
                String[] myArrayOfAnimalData = myFileLine.split(",");

                // Create another String array named
                String[] myArrayOfAgeGenderSpecies = myArrayOfAnimalData[0].split(" ");

                // Get what we can from myArrayOfAgeGenderSpecies
                ageInYears = Integer.parseInt(myArrayOfAgeGenderSpecies[0]);
                animalGender = myArrayOfAgeGenderSpecies[3];
                species = myArrayOfAgeGenderSpecies[4];

                // Split the next group of words by a space.
                String[] myArrayOfBirthSeason = myArrayOfAnimalData[1].split(" ");

                // Get birthSeason
                birthSeason = myArrayOfBirthSeason[3];

                // Get color.
                animalColor = myArrayOfAnimalData[2];

                // Get weight.
                animalWeight = myArrayOfAnimalData[3];

                // Get from.
                animalFrom = myArrayOfAnimalData[4] + ", " + myArrayOfAnimalData[5];

                // Calculate Animal BirthDate.
                animalBirthDate = calcBirthdate(ageInYears, birthSeason);

                // Calculate Animal Arrival Date.
                animalArrivalDate = LocalDate.now();

                // Assign a Variable for the gen methods
                String animID = genUniqueID(species);
                String animHabitat = genZooHabitat(species);
                LocalDate animBirthDay = genBirthDay(ageInYears, animalBirthDate);


                // Add the habitat to the HashMap, if it doesn't already exist.
                /*
                if (!habitatMap.containsKey(animHabitat)) {
                    habitatMap.put(Animal, animHabitat);
                }
                 */

                // If the habitat is not already in the HashSet, add it to the HashSet and print it to the console.
                if (!uniqueHabitats.contains(animHabitat)) {
                    uniqueHabitats.add(animHabitat);
                    //System.out.println("Habitat: " + animHabitat);
                }


                if (species.contains("hyena")) { // [!] WORK ON BDAY
                    // create a hyena with what we have so far.
                    Hyena myNewHyena = new Hyena("HYXX","a name", animalBirthDate, animalColor, animalGender,
                            animalWeight,animalFrom,animalArrivalDate);

                    // Set animal ID by getting the static int numOfHyenas
                    //myNewHyena.setAnimalID("HY0" + Integer.toString(Hyena.getNumOfHyenas()));

                    // Set animal ID by getting the animID String that calls on the generateUniqueID method
                    myNewHyena.setAnimalID(animID);


                    // Set hyena name by popping a name from the list in the Hyena class.
                    myNewHyena.setAnimalName(Hyena.popHyenaName());

                    // Set animal birthday
                    myNewHyena.setAnimalBirthDate(animBirthDay);

                    // Add to the list of hyenas.
                    hyenaArrayList.add(myNewHyena);
                    animalsInHabitat.add(myNewHyena);
                    if (!habitatMap.containsKey(animHabitat)) {
                        habitatMap.put(myNewHyena, animHabitat);
                    }
                }

                else if (species.contains("lion")) {
                    // create a lion with what we have so far.
                    Lion myNewLion = new Lion("HYXX","a name", animalBirthDate, animalColor, animalGender,
                            animalWeight,animalFrom,animalArrivalDate);

                    // Set animal ID by getting the animID String that calls on the generateUniqueID method
                    myNewLion.setAnimalID(animID);

                    // Set lion name by popping a name from the list in the Lion class.
                    myNewLion.setAnimalName(Lion.popLionName());

                    // Set animal birthday
                    myNewLion.setAnimalBirthDate(animBirthDay);

                    // Add to the list of lions.
                    lionArrayList.add(myNewLion);
                    animalsInHabitat.add(myNewLion);
                    if (!habitatMap.containsKey(animHabitat)) {
                        habitatMap.put(myNewLion, animHabitat);
                    }
                }

                else if (species.contains("tiger")) {
                    // create a tiger with what we have so far.
                    Tiger myNewTiger = new Tiger("HYXX","a name", animalBirthDate, animalColor, animalGender,
                            animalWeight,animalFrom,animalArrivalDate);

                    // Set animal ID by getting the animID String that calls on the generateUniqueID method
                    myNewTiger.setAnimalID(animID);

                    // Set tiger name by popping a name from the list in the Tiger class.
                    myNewTiger.setAnimalName(Tiger.popTigerName());

                    // Set animal birthday
                    myNewTiger.setAnimalBirthDate(animBirthDay);

                    // Add to the list of tigers.
                    tigerArrayList.add(myNewTiger);
                    animalsInHabitat.add(myNewTiger);
                    if (!habitatMap.containsKey(animHabitat)) {
                        habitatMap.put(myNewTiger, animHabitat);
                    }
                }

                else if (species.contains("bear")) {
                    // create a bear with what we have so far.
                    Bear myNewBear = new Bear("HYXX","a name", animalBirthDate, animalColor, animalGender,
                            animalWeight,animalFrom,animalArrivalDate);

                    // Set animal ID by getting the animID String that calls on the generateUniqueID method
                    myNewBear.setAnimalID(animID);

                    // Set bear name by popping a name from the list in the Bear class.
                    myNewBear.setAnimalName(Bear.popBearName());

                    // Set animal birthday
                    myNewBear.setAnimalBirthDate(animBirthDay);

                    // Add to the list of bears.
                    bearArrayList.add(myNewBear);
                    animalsInHabitat.add(myNewBear);
                    if (!habitatMap.containsKey(animHabitat)) {
                        habitatMap.put(myNewBear, animHabitat);
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //Output for the final Animal Data
        for (String habitat : uniqueHabitats) {
            System.out.println(habitat);
            for (Animal animal : animalsInHabitat) {
                if (habitatMap.get(animal).equals(habitat)) {
                    System.out.println(animal.getAnimalID() + ", " + animal.getAnimalName() +  ", "
                            + animal.getAnimalBirthDate() + ", " + animal.getAnimalColor() + ", " + animal.getAnimalGender()
                            + ", " + animal.getAnimalWeight() + ", " + animal.getArrivingFrom() + ", " + animal.getArrivalDate());
                }
            }
            System.out.println();
        }


































        System.out.println("========================\nSit©'s Programming Inc.\n========================");
    }

}
