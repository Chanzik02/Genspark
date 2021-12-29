import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public Game() {

    }


    /*
     *Method provides a random word from selection
     *hello, mower, or scooby
     */
    public String selectionOfWords() {
        Random random = new Random();
        int aRandomNumber = random.nextInt(3);

        if (aRandomNumber == 0) {
            return "null";
        }
        else if (aRandomNumber == 1) {
            return "mower";
        }
        return "scooby";
    }


    /*

     */
    public void printAZero(int a) {
        if (a == 3) {
            System.out.println("   |");
        }
        else if (a < 3)
            System.out.println("0  |");
    }

    /*

     */
    public void printLineOne(int a) {
        if (a == 3) {
            System.out.println("   |");
        }
        else if (a == 2) {
            System.out.println("   |");
        }
        else {
            System.out.println("|  |");


        } }

    /*

     */
    public void printLineTwo(int a) {
        if (a == 3) {
            System.out.println("   |");
        }
        else if(a == 2) {
            System.out.println("   |");
        }
        else if (a == 1) {
            System.out.println("   |");
        }
        else {
            System.out.println("|  |");

        }

    }

    public String getName(String name) {
        try {
            Scanner sc = new Scanner(System.in);
            while (name.equals("")) {
                System.out.println("Name must have characters");
                System.out.print("Enter your name: ");
                name = sc.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return name;
    }

    /*

     */
    public String missedLetters(String a){
        return "Missed Letters: " + a;
    }

}
