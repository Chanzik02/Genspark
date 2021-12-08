import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int aRandomNumber = random.nextInt(21);
        int guesses = 1;

        String playOrNot = "";
        Boolean isRunning = true;

        System.out.println("Hello! What is your name?");


        String name = sc.nextLine();

        do{

            System.out.println("Well " + name + " I am thinking of a number between 1 and 20.");
            System.out.println("Take a guess.");

            String choice = sc.nextLine();
            int choiceAsInt = Integer.parseInt(choice);

            System.out.println(aRandomNumber);


            if(choiceAsInt == aRandomNumber){
                guesses++;
                System.out.println("Good job " + name + " You guessed my number in " + guesses + " guesses!");

            }
            else if(choiceAsInt != aRandomNumber) {
                while(guesses != 3) {
                    if(choiceAsInt > aRandomNumber) {
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
                guesses = 0;
            }
            else if(playOrNot.equals("n")) {
                guesses = 3;

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
                    guesses = 3;

                }
            }

        } while(guesses !=3);



    }
}
