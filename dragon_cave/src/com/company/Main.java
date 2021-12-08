package com.company;

import javax.xml.soap.Text;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("You are in a land of dragons. In front of you," + "\n" + "you see two caves." +
        "In one cave, the dragon is friendly" + "\n" + "and will share his treasure with you." +
        "The other dragon\nis greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");

        Scanner sc = new Scanner(System.in);
        String aNumber = sc.nextLine();

        if(Integer.parseInt(aNumber) == 1) {
            System.out.println("You did not get eaten.");
            sc.close();
        }
        else if(Integer.valueOf(aNumber).doubleValue() == 2) {
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in one bite.");
            sc.close();
        }
        else {
            System.out.println("Please choose the number 1 or 2.");
        }


        sc.close();
    }
}
