import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String name = "";
        int aRandomNumber = random.nextInt(21);
        int guesses = 1;
        String playOrNot = "";
        Boolean hasLettersOnly = true;
        //Boolean isRunning = true;


        try {
            System.out.println("Hello! What is your name?");


            name = sc.nextLine();

            ;
            hasLettersOnly = main.checkName(name);
            //System.out.println(hasLettersOnly);

            if(hasLettersOnly == false) {
                while (hasLettersOnly == false) {
                    System.out.println("Your name should only include letters.");

                    System.out.println("Hello! What is your name?");

                    name = sc.nextLine();

                    hasLettersOnly = name.matches("[a-zA-Z]+");
                }

            }
        } catch(Exception e) {
            e.printStackTrace();
        }


        try {

            do{

                System.out.println("Well " + name + " I am thinking of a number between 1 and 20.");
                System.out.println("Take a guess.");
                //System.out.println(aRandomNumber);

                String choice = sc.nextLine();
                int choiceAsInt = Integer.parseInt(choice);



                if(choiceAsInt == aRandomNumber){
                    guesses++;
                    System.out.println("Good job " + name + " You guessed my number in " + guesses + " guesses!");

                }
                else if(choiceAsInt != aRandomNumber) {
                    while(guesses != 6 || choiceAsInt == aRandomNumber) {
                        if(choiceAsInt == aRandomNumber) {
                            //guesses++;
                            System.out.println("Good job " + name + " You guessed my number in " + guesses + " guesses!");
                            break;
                        }
                        else if(choiceAsInt > aRandomNumber) {
                            System.out.println("Your guess is too high");
                            guesses++;
                            System.out.println("Try again.");
                            choice = sc.nextLine();
                            choiceAsInt = Integer.parseInt(choice);
                        }
                        else if(choiceAsInt < aRandomNumber) {
                            System.out.println("Your guess is too low.");
                            guesses++;
                            System.out.println("Try again.");
                            choice = sc.nextLine();
                            choiceAsInt = Integer.parseInt(choice);

                        }

                    }

                }


                System.out.println("Would you like to play again? (y/n)");
                playOrNot = sc.nextLine();
                if(playOrNot.equals("y")) {
                    guesses = 1;
                }
                else if(playOrNot.equals("n")) {
                    guesses = 6;

                }
                else {
                    System.out.println("Please pick y/n");
                    System.out.println("Would you like to play again? (y/n)");
                    playOrNot = sc.nextLine();
                    if(playOrNot.equals("y")) {
                        guesses = 1;
                        aRandomNumber = random.nextInt(21);

                    }
                    else if(playOrNot.equals("n")) {
                        guesses = 6;
                        //break;
                    }
                }

            } while(guesses !=6);

        } catch (Exception e) {
            //e.printStackTrace();
            throw new Exception("This is not a number.");
        }


    }

    public boolean checkName(String input) {
        Boolean a = input.matches("[a-zA-Z]+");
        if(a == true) {
            return true;
        }else {
            return false;
        }

    }
}
