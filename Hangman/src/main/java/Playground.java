import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Playground {

    public static void main(String[] args) throws MyStringException {
        Game game = new Game();
        Boolean stillPlaying = true;

        try {
            while (stillPlaying) {
                ArrayList<String> availableWords = new ArrayList<>();
                availableWords.add("null");
                availableWords.add("mower");
                availableWords.add("courage");
                Random random = new Random();
                String randomWord = availableWords.get((random.nextInt(availableWords.size())));
                //System.out.println(randomWord);
                int livesCounter = 3;
                ArrayList<String> randomWordUnderscore = new ArrayList<>();
                String missedLetters = "";

                for(int i = 0; i < randomWord.length(); i ++) {
                    randomWordUnderscore.add("_");
                    System.out.print(randomWordUnderscore.get(i));
                }
                System.out.println();

                Scanner sc = new Scanner(System.in);



                do {

                    System.out.println("H A N G M A N");
                    System.out.println();
                    System.out.println("+--+");
                    System.out.println();
                    game.printAZero(livesCounter);
                    //System.out.println(hangManLives.get(0));
                    System.out.println();
                    game.printLineOne(livesCounter);
                    //System.out.println(hangManLives.get(1));
                    System.out.println();
                    game.printLineTwo(livesCounter);
                    //System.out.println(hangManLives.get(2));
                    System.out.println("");
                    System.out.println("  ===");
                    System.out.println(game.missedLetters(missedLetters));

                    System.out.println("");
                    System.out.println("Guess a Letter");
                    String userInput = sc.nextLine();
                    String firstLetter = userInput.charAt(0) + "";

                    String charIsAt = "";

                    if (randomWord.contains(firstLetter)) {
                        for (int i = 0; i < randomWord.length(); i++) {

                            charIsAt = randomWord.charAt(i) + "";
                            if (firstLetter.equals(charIsAt)) {
                                randomWordUnderscore.set(i, charIsAt);
                            }
                        }

                        if(randomWordUnderscore.contains(firstLetter)) {
                            System.out.println("You have already guessed that letter. Choose again.");
                        }

                        System.out.println(randomWordUnderscore);
                    }
                    else {
                        missedLetters = missedLetters + " " + firstLetter;
                        livesCounter--;


                    }



                    if (!randomWordUnderscore.contains("_")) {
                        System.out.println("Yes! The secret word is " + '"' + randomWord + '"' + ". You have won!");
                        System.out.println("Do you want to play again? (yes or no)");
                        userInput = sc.nextLine();
                        if(userInput.equals("yes")) {
                            stillPlaying = true;

                        }
                        else if (userInput.equals("no")) {
                            livesCounter = 0;
                        }
                        else {
                            stillPlaying = false;
                        }

                    }

                    if(livesCounter == 0) {
                        System.out.println("You have lost");
                        System.out.println("Do you want to play again? (yes or no)");
                        userInput = sc.nextLine();
                        if(userInput.equals("yes")) {
                            System.out.println("That is not an option. Ending game.");
                            stillPlaying = true;

                        }
                        else if (userInput.equals("no")) {
                            livesCounter = 0;
                        }
                        else {
                            System.out.println("That is not an option. Ending game.");
                            stillPlaying = false;
                        }
                    }


                } while (livesCounter != 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new StringIndexOutOfBoundsException("You did not enter anything");
        }


    }
}
