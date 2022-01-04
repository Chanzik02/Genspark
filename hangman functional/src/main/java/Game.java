import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

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

    public String getFirstLetter(String userInput) {
            Scanner sc = new Scanner(System.in);
            while (userInput.equals("")) {
                System.out.println("Please enter a character");
                System.out.print("Guess a letter: ");
                userInput = sc.nextLine();
            }

        return userInput;
    }

    /*

     */
    public String missedLetters(String missedLetters){
        return "Missed Letters: " + missedLetters;
    }

    public String score(int lives, String missedLetters) {
        int score = 0;
        if (lives == 1) {
            score = 100;
        }
        else if (lives == 2) {
            score = 200;
        }
        else if (lives == 3) {
            score = 300;
        }
        return "\n!!!SCORE!!!" + "\nScore: " + score + "   Lives: " + lives + "   Missed Letters: " + missedLetters + "\n" + "\n";
    }

    public void score(int score) throws IOException {
//        var a =  Files.write(Paths
//                .get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_highscore"), );
//        ArrayList<String> myArrayList= new ArrayList<>(a);
//        Stream<String> myFile =myArrayList.stream().filter(n -> n.contains("lives"));
//        System.out.println(myArrayList);
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Files.lines(Paths.get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_score"));
        //game.score();
    }

}
