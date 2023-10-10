import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Hyena extends Animal {
    // Create a static member variable that accumulates the number of hyenas created.
    private static int numOfHyenas = 0;


    // Create an ArrayList to store the split values read from animalNames.txt
    private static List<String> myListOfHyenaNames = new ArrayList<>();

    // write a Getter method to look at the static int numOfHyenas
    public static int getNumOfHyenas() {
        return numOfHyenas;
    }

    // Create a constructor that will increment numOfHyenas when a new Hyena object is created.
    public Hyena() {
        System.out.println("\n A new Hyena object was created!!!");
        numOfHyenas++;
   }

   // Create a method that input hyena names from a file named: animalNames.txt
   public static void inputHyenaNames()  {
       // Define the file path
       String filePath = "C:\\Users\\BE218\\javaDataFiles\\animalNames.txt";

       try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
            Scanner scanner = new Scanner(System.in)) {
           String line;
           int lineNum = 1;
           while ((line = fileReader.readLine()) != null) {

               if (lineNum == 3) {
                   // Split the line into an array of values using a comma as the delimiter
                   String[] values = line.split(",");
                   // Process the values and add them to the ArrayList
                   for (String value : values) {
                       myListOfHyenaNames.add(value.trim()); // Trim removes leading/trailing spaces
                   }
               }

               lineNum++;
           }
       } catch (IOException e) {
           e.printStackTrace();
       }


   }

    // output the list.
    public static void listOut() {
        for (String name : myListOfHyenaNames) {
            System.out.println(name);

        }
    }

    // pop one name off the list
    public static String popHyenaName() {
        // Remove the first element from the ArrayList
        String removedHyenaName = "";
        if (!myListOfHyenaNames.isEmpty()) {
            removedHyenaName = myListOfHyenaNames.remove(0);


        } else {
            System.out.println("The ArrayList is empty. Nothing to remove.");
        }
        return removedHyenaName;
    }





}
