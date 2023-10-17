//https://github.com/BlackCatCode22/tJavaMidtermCheckPoint
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.*;

public class Main {
    // Creating the genUniqueID method
    private static String genUniqueID(String theSpecies, int numOfSpecies) {
        String prefix = "";
        int suffix = numOfSpecies + 1;
        if (theSpecies.contains("hyena")) {
            prefix = "Hy";
        }
        if (theSpecies.contains("tiger")) {
            prefix = "Ti";
        }
        if (theSpecies.contains("lion")) {
            prefix = "Li";
        }
        if (theSpecies.contains("bear")) {
            prefix = "Br";
        }
        return prefix + Integer.valueOf(suffix);
    }


    public static void main(String[] args) {
        System.out.println("********************************");
        System.out.println("* Welcome to Sit's and Heng's Zoo Program *");
        System.out.println("********************************\n");
            // Load all species classes with name.
            // Call the static methods to create a lists of names.****
            Lion.inputLionNames();//VVV calling... VVV
            Tiger.inputTigerNames();
            Bear.inputBearNames();
            Hyena.inputHyenaNames();

            // Open a csv file using the split() method on a string object
            String path = "C:\\Users\\ericl\\IdeaProjects\\x\\src\\arrivingAnimals.txt"; //change all pathfile on classes
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

                    System.out.println("Animal Number: " + myCounter + "\n*********************");
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
                    String myAnimalBD = " ";

                    int animalYearsOfBirthDate = year - Integer.parseInt(myArrayOfAgeGenderSpecie[0]);

                    //Split the next group of words
                    String[] myArrayOfBirthSeason = myArrayOfAnimalData[1].split(" ");

                    String birthSeason = myArrayOfBirthSeason[3];
                    System.out.println("\nbirthSeason is: " + birthSeason + "\n\n");

                    //String myAnimalBD = " ";
                    if (birthSeason.contains("spring")) {
                        myAnimalBD = "March 21, " + animalYearsOfBirthDate;
                        //calculate anim age
                        // create localdata
                        //Define
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
                        //parse string
                        LocalDate localDateAnimalBirthday = LocalDate.parse("Mar 21, 2017",formatter);
                        //print
                        System.out.println("Animal birthday "+localDateAnimalBirthday);
                        //do the math
                        //first argument is birthday and second argument is now
                        long animalAgeInYears = ChronoUnit.YEARS.between(localDateAnimalBirthday,currentData);
                        System.out.println("Animal birth date is: "+ myAnimalBD +"\n\n");
                        System.out.println("\nAnimal age in years is: " + animalAgeInYears + "\n\n");
                    }
                    else if(birthSeason.contains("summer")){
                        myAnimalBD = "Jun 21, " + animalYearsOfBirthDate;
                        //calculate anim age
                        // create localdata
                        //Define
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
                        //parse string
                        LocalDate localDateAnimalBirthday = LocalDate.parse("Mar 21, 2017",formatter);
                        //print
                        System.out.println("Animal birthday "+localDateAnimalBirthday);
                        //do the math
                        //first argument is birthday and second argument is now
                        long animalAgeInYears = ChronoUnit.YEARS.between(localDateAnimalBirthday,currentData);
                        System.out.println("Animal birth date is: "+ myAnimalBD +"\n\n");
                        System.out.println("\nAnimal age in years is: " + animalAgeInYears + "\n\n");
                    }
                    else if(birthSeason.contains("fall")){
                        myAnimalBD = "Aug 21, " + animalYearsOfBirthDate;
                        //calculate anim age
                        // create localdata
                        //Define
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
                        //parse string
                        LocalDate localDateAnimalBirthday = LocalDate.parse("Mar 21, 2017",formatter);
                        //print
                        System.out.println("Animal birthday "+localDateAnimalBirthday);
                        //do the math
                        //first argument is birthday and second argument is now
                        long animalAgeInYears = ChronoUnit.YEARS.between(localDateAnimalBirthday,currentData);
                        System.out.println("Animal birth date is: "+ myAnimalBD +"\n\n");
                        System.out.println("\nAnimal age in years is: " + animalAgeInYears + "\n\n");
                    }
                    else if(birthSeason.contains("winter")){
                        myAnimalBD = "Dec 21, " + animalYearsOfBirthDate;
                        //calculate anim age
                        // create localdata
                        //Define
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
                        //parse string
                        LocalDate localDateAnimalBirthday = LocalDate.parse("Mar 21, 2017",formatter);
                        //print
                        System.out.println("Animal birthday "+localDateAnimalBirthday);
                        //do the math
                        //first argument is birthday and second argument is now
                        long animalAgeInYears = ChronoUnit.YEARS.between(localDateAnimalBirthday,currentData);
                        System.out.println("Animal birth date is: "+ myAnimalBD +"\n\n");
                        System.out.println("\nAnimal age in years is: " + animalAgeInYears + "\n\n");
                    }
                    else if(birthSeason.contains("unknown")){
                        myAnimalBD = "Jan 21, " + animalYearsOfBirthDate;
                        //calculate anim age
                        // create localdata
                        //Define
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
                        //parse string
                        LocalDate localDateAnimalBirthday = LocalDate.parse("Mar 21, 2017",formatter);
                        //print
                        System.out.println("Animal birthday "+localDateAnimalBirthday);
                        //do the math
                        //first argument is birthday and second argument is now
                        long animalAgeInYears = ChronoUnit.YEARS.between(localDateAnimalBirthday,currentData);
                        System.out.println("Animal birth date is: "+ myAnimalBD +"\n\n");
                        System.out.println("\nAnimal age in years is: " + animalAgeInYears + "\n\n");
                    }
                    else {
                        myAnimalBD = "Unable to process..."+ animalYearsOfBirthDate;
                        //calculate anim age
                        // create localdata
                        //Define
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
                        //parse string
                        LocalDate localDateAnimalBirthday = LocalDate.parse("Mar 21, 2017",formatter);
                        //print
                        System.out.println("Animal birthday "+localDateAnimalBirthday);
                        //do the math
                        //first argument is birthday and second argument is now
                        long animalAgeInYears = ChronoUnit.YEARS.between(localDateAnimalBirthday,currentData);
                        System.out.println("Animal birth date is: "+ myAnimalBD +"\n\n");
                        System.out.println("\nAnimal age in years is: " + animalAgeInYears + "\n\n");
                    }

                    System.out.println("\nAnimal birth date is: " + myAnimalBD + "\n\n");

                    //subtract 4 yrs
                    calendar.add(Calendar.YEAR, -4);

                    //set new date after sub
                    Date yearsAgo = calendar.getTime();

                    //print date
                    System.out.println("Todays Date: " + today);
                    System.out.println("Date: " + myArrayOfAgeGenderSpecie[0] + " years ago " + yearsAgo);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}

