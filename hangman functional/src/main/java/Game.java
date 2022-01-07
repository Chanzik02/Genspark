import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
     *
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

    public void addUnderScore(String randomWord, ArrayList<String> randomWordUnderscore) {
        for(int i = 0; i < randomWord.length(); i ++) {
            randomWordUnderscore.add("_");
            System.out.print(randomWordUnderscore.get(i));
        }
    }

    public void displayState(int livesCounter, String missedLetters) {
        Scanner sc = new Scanner(System.in);
        System.out.println("H A N G M A N");
        System.out.println();
        System.out.println("+--+");
        System.out.println();
        this.printAZero(livesCounter);

        System.out.println();
        this.printLineOne(livesCounter);

        System.out.println();
        this.printLineTwo(livesCounter);

        System.out.println("");
        System.out.println("  ===");
        System.out.println(this.missedLetters(missedLetters));

        System.out.println("");
        System.out.println("Guess a Letter");
        String userInput = sc.nextLine();
        userInput = this.getFirstLetter(userInput);
    }

    /*
     *Records entire file
     */
    public void updateHighScoreFile(int livesCounter) throws IOException {
        Files.write(Paths.get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\highScore"),
                this.numberScore(livesCounter).getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /*
     *Records entire file
     */
    public void updateHangmanScoreFile(int livesCounter, String missedLetters) throws IOException {
        Files.write(Paths
                        .get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_score"),
                this.score(livesCounter, missedLetters).getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

}
