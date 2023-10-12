import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.*;

/*
Obj: group by animal or species
1. listofanimals
hyena -> lion ->...
^
hyena
Lion
tiger
bears
2.listofspecies [x]
 listofhyena...[0] ->[1]...
 */

public class Main {
    // Creating the genUniqueID method
    private static String genUniqueID(String theSpecies, int numOfSpecies) {
        String prefix = "";
        int suffix = numOfSpecies + 1;


        if (theSpecies.contains("hyena")) {
            prefix = "Hy";
        }

        return prefix + Integer.valueOf(suffix);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        System.out.println("********************************");
        System.out.println("* Welcome to Sit's Zoo Program *");
        System.out.println("********************************\n");
        System.out.println("CHOOSE YOUR ANIMAL: \n");
        System.out.println("1. Hyena");
        System.out.println("2. Tiger");
        System.out.println("3. Bear");
        System.out.println("4. Lion");
        num1 = Integer.parseInt(sc.nextLine());
        System.out.println("You chose: [" + num1 + "] is that correct?");
        String yesNo = sc.nextLine();
        if (yesNo == "yes") {
                System.out.println("loading");

        }
            // Load all species classes with name.
            // Call the static methods to create a lists of names.****
            Lion.inputLionNames();//VVV calling... VVV
            Tiger.inputTigerNames();
            Bear.inputBearNames();
            Hyena.inputHyenaNames();


            // Open a csv file using the split() method on a string object
            String path = "C:\\Users\\BE218\\IdeaProjects\\untitled\\arrivingAnimals.txt"; //change all pathfile on classes
            String myFileLine = "";

            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                int myCounter = 0;
                while ((myFileLine = reader.readLine()) != null) {
                    //The input data of arrivingAnimals.txt looks like this
                    //4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia

                    //Create a String array name myArrayOfAnimalData
                    String[] myArrayOfAnimalData = myFileLine.split(",");

                    //Create another String array name to read the start of each split from myarrayofanimaldata
                    String[] myArrayOfAgeGenderSpecie = myArrayOfAnimalData[0].split(" ");//this is the assign for reading the line before ","
                    System.out.println("\nText for Age: " + myArrayOfAgeGenderSpecie[0]);
                    System.out.println("\nText for Years: " + myArrayOfAgeGenderSpecie[1]);
                    System.out.println("\nText for Old: " + myArrayOfAgeGenderSpecie[2]);
                    System.out.println("\nText for Gender: " + myArrayOfAgeGenderSpecie[3]);
                    System.out.println("\nText for Specie: " + myArrayOfAgeGenderSpecie[4]);

                    //output
                    System.out.println("\nSpecie: " + myArrayOfAgeGenderSpecie[4]);
                    System.out.println("\nAnimal Number: " + myCounter + "\n*********************");
                    System.out.println("\nmyArrayOfAnimalData[0] is " + myArrayOfAnimalData[0]); //reads before , all words
                    System.out.println("\nmyArrayOfAnimalData[1] is " + myArrayOfAnimalData[1]);
                    System.out.println("\nmyArrayOfAnimalData[2] is " + myArrayOfAnimalData[2]);
                    System.out.println("\nmyArrayOfAnimalData[3] is " + myArrayOfAnimalData[3]);
                    System.out.println("\nmyArrayOfAnimalData[4] is " + myArrayOfAnimalData[4]);
                    System.out.println("\nmyArrayOfAnimalData[5] is " + myArrayOfAnimalData[5]);
                    //incrament for animal counter
                    myCounter++;

                    //Create a birthdate from the first 2 "," splits (a method) also using season
                    Calendar calendar = Calendar.getInstance();
                    Date today = calendar.getTime();
                    //Set todays date
                    LocalDate currentData = LocalDate.now();
                    int year = currentData.getYear();

                    //print out year
                    System.out.println("Current year " + year);

                    //Code up calculating animal age
                    //animal age = now - animal birthdate
                    //must create dateTime objects so we can do math on them
                    //LocalDate myDate = LocalDate.now();
                    //This
                    //LocalDate myDate = LocalDate.of(myAnimalBD);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM, dd, yyyy");
                    LocalDate myBirthDayTest = LocalDate.parse(myAnimalBD, formatter);

                    System.out.println("my datTime is" + myBirthDayTest);

                    //this was code class oct 22
                    //Calculate animal age using local date object

                    //look at java.time.period, etc.
                    LocalDate myNow = LocalDate.now();
                    LocalDate myAnimalAge = myBirthDayTest-myNow;

                    int animalYearsOfBirthDate = year - Integer.parseInt(myArrayOfAgeGenderSpecie[0]);

                    //Split the next group of words
                    String[] myArrayOfBirthSeason = myArrayOfAnimalData[1].split(" ");

                    String birthSeason = myArrayOfBirthSeason[3];
                    System.out.println("\nbirthSeason is: " + birthSeason + "\n\n");

                    String myAnimalBD = " ";

                    if (birthSeason.contains("spring")) {
                        myAnimalBD = "March 21, " + animalYearsOfBirthDate;

                    }
                    else if(birthSeason.contains("summer")){
                        myAnimalBD = "Jun 21, " + animalYearsOfBirthDate;
                    }
                    else if(birthSeason.contains("fall")){
                        myAnimalBD = "Aug 21, " + animalYearsOfBirthDate;
                    }
                    else if(birthSeason.contains("winter")){
                        myAnimalBD = "Dec 21, " + animalYearsOfBirthDate;
                    }
                    else if(birthSeason.contains("unknown")){
                        myAnimalBD = "Jan 21, " + animalYearsOfBirthDate;
                    }
                    else {
                        myAnimalBD = "Unable to process..."+ animalYearsOfBirthDate;
                    }

                    System.out.println("\nAnimal birth date is: " + myAnimalBD + "\n\n");

                    //subtract 4 yrs
                    calendar.add(Calendar.YEAR, -4);

                    //set new date after sub
                    Date yearsAgo = calendar.getTime();

                    //print date
                    System.out.println("Todays Date: " + today);
                    System.out.println("Date: " + myArrayOfAgeGenderSpecie[0] + " years ago " + yearsAgo);

                /*
                String myStr = myArrayOfAnimalData[0];
                System.out.println("\nmyArrayOfAnimalData[0] is " + myArrayOfAnimalData[0]);
                myArrayOfAnimalData = myStr.split(" "); //this reads in sequence of each word by spaces
                String mySpecies = myArrayOfAnimalData[4];
                System.out.println("\nmyArrayOfAnimalData[4] is " + myArrayOfAnimalData[4]);
                System.out.println("\n myStr = " + myStr);
                */

                /*
                System.out.println(" First element: " + myArrayOfAnimalData[0]);
                System.out.println(" Second element: " + myArrayOfAnimalData[1]);
                System.out.println(" Third item: " + myArrayOfAnimalData[2]);
                System.out.println(" Fourth element: " + myArrayOfAnimalData[3]);
                System.out.println(" Fifth item: " + myArrayOfAnimalData[4]);
                */

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}

