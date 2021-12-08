package com.company;

import javax.xml.soap.Text;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Main main = new Main();

        System.out.println("You are in a land of dragons. In front of you," + "\n" + "you see two caves." +
        "In one cave, the dragon is friendly" + "\n" + "and will share his treasure with you." +
        "The other dragon\nis greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");



        try {
            Scanner sc = new Scanner(System.in);
            int aNumber = sc.nextInt();
            main.userInput(aNumber);
            sc.close();
        } catch (Exception e) {
            throw new InputMismatchException("That is not number");
        }




    }

    /*
        *Accepts the number 1 or 2
     */
    public String userInput(int userInput) {
        try {
            if(userInput == 1) {
                System.out.println("You did not get eaten.");
                return "You did not get eaten.";
            }
            else if(userInput == 2) {
                String twoAnswer = "You approach the cave..." +
                        "\nIt is dark and spooky..." +
                        "\nA large dragon jumps out in front of you! He opens his jaws and..." +
                        "\nGobbles you down in one bite.";

                System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
                System.out.println("Gobbles you down in one bite.");

                return twoAnswer;
            }
            else {
                System.out.println("Please choose the number 1 or 2.");
                return "Please choose the number 1 or 2.";
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public String hello() {
        return "hello";
    }
}
