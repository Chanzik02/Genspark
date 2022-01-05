import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public void initialDisplay() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_display"));
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    public String numberScore(int lives) throws IOException {
        int score = 0;
        score = lives * 100;
        ArrayList<Integer> a = new ArrayList<>();
        a.add(score);
        return a.get(0).toString() + "\n";
    }

    public int highScore() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\highScore"));
        int newHighScore = 0;
        while (sc.hasNextLine()) {
            var a = Integer.parseInt(sc.next());
            if (a > newHighScore) {
                newHighScore = a;
                sc.close();
            }

            System.out.println(highScore());
        }
        sc.close();
        return newHighScore;
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
//        Files.lines(Paths.get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_score"));
//        game.initialDisplay();
        //game.score();
        game.highScore();

    }

}
