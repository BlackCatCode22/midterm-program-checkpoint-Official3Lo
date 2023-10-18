import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;




// Main.java
// Driver class for the Zoo program
// dH
// 9/26/23

// updated Oct 5, 2023
// Updated Oct 17
// last update before code presentation on Oct 19 at 10:15 AM


public class Main {

    // Creating the genUniqueID method
    private static String genUniqueID(String theSpecies, int numOfSpecies) {
        String prefix = "";
        int suffix = numOfSpecies;

        if (theSpecies.contains("hyena")) {
            prefix = "Hy";
        }
        else if (theSpecies.contains("lion")) {
            prefix = "Li";
        }
        else if (theSpecies.contains("tiger")) {
            prefix = "Ti";
        }
        else if (theSpecies.contains("bear")) {
            prefix = "Be";
        }
        else {
            prefix = "XX";
        }

        return prefix + Integer.valueOf(suffix);
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
                monthDay = "06-21";
                break;
            case "fall":
                monthDay = "09-21";
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

    public static void main(String[] args) {

        System.out.println("\n\n Welcome to my Zoo Program\n\n");

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
        String path = "C:\\Users\\ericl\\IdeaProjects\\x\\src\\arrivingAnimals.txt";
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

                if (species.contains("hyena")) {
                    // create a hyena with what we have so far.
                    Hyena myNewHyena = new Hyena("HYXX","a name", animalBirthDate, animalColor, animalGender,
                            animalWeight,animalFrom,animalArrivalDate);

                    // Set animal ID by getting the static int numOfHyenas
                    myNewHyena.setAnimalID("HY0" + Integer.toString(Hyena.getNumOfHyenas()));

                    // Set hyena name by popping a name from the list in the Hyena class.
                    myNewHyena.setAnimalName(Hyena.popHyenaName());

                    // Add to the list of hyenas.
                    hyenaArrayList.add(myNewHyena);

                }
                else if (species.contains("lion")) {
                    // create a lion with what we have so far.
                    Lion myNewLion = new Lion("HYXX","a name", animalBirthDate, animalColor, animalGender,
                            animalWeight,animalFrom,animalArrivalDate);

                    // Set animal ID by getting the static int numOfHyenas
                    myNewLion.setAnimalID("Li0" + Integer.toString(Lion.getNumOfLions()));

                    // Set lion name by popping a name from the list in the Lion class.
                    myNewLion.setAnimalName(Lion.popLionName());

                    // Add to the list of lions.
                    lionArrayList.add(myNewLion);

                }
                else if (species.contains("tiger")) {
                    // create a tiger with what we have so far.
                    Tiger myNewTiger = new Tiger("HYXX","a name", animalBirthDate, animalColor, animalGender,
                            animalWeight,animalFrom,animalArrivalDate);

                    // Set animal ID by getting the static int numOfHyenas
                    myNewTiger.setAnimalID("Ti0" + Integer.toString(Tiger.getNumOfTigers()));

                    // Set tiger name by popping a name from the list in the Tiger class.
                    myNewTiger.setAnimalName(Tiger.popTigerName());

                    // Add to the list of tigers.
                    tigerArrayList.add(myNewTiger);

                }
                else if (species.contains("bear")) {
                    // create a bear with what we have so far.
                    Bear myNewBear = new Bear("HYXX","a name", animalBirthDate, animalColor, animalGender,
                            animalWeight,animalFrom,animalArrivalDate);

                    // Set animal ID by getting the static int numOfHyenas
                    myNewBear.setAnimalID("Be0" + Integer.toString(Tiger.getNumOfTigers()));

                    // Set bear name by popping a name from the list in the Bear class.
                    myNewBear.setAnimalName(Bear.popBearName());

                    // Add to the list of bears.
                    bearArrayList.add(myNewBear);

                }



            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for (Hyena aHyena : hyenaArrayList) {
            System.out.println(aHyena.getAnimalID() + ", " + aHyena.getAnimalName() + ", " + aHyena.getAnimalColor());
        }
        System.out.println();
        for (Lion aLion : lionArrayList) {
            System.out.println(aLion.getAnimalID() + ", " + aLion.getAnimalName() + ", " + aLion.getAnimalColor());
        }
        System.out.println();
        for (Tiger aTiger : tigerArrayList) {
            System.out.println(aTiger.getAnimalID() + ", " + aTiger.getAnimalName() + ", " + aTiger.getAnimalColor());
        }
        System.out.println();
        for (Bear aBear : bearArrayList) {
            System.out.println(aBear.getAnimalID() + ", " + aBear.getAnimalName() + ", " + aBear.getAnimalColor());
        }

    }




}

