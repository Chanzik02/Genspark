import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Playground {
    public static void main(String[] args) {
        Game game = new Game();
        Boolean stillPlaying = true;
        int highScore = 0;
        Scanner sc = new Scanner(System.in);
        Charset utf8 = StandardCharsets.UTF_8;

        try {
            game.initialDisplay();
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            String checkName = game.getName(name) + "\n";
            Files.write(Paths
                    .get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_score"),
                    checkName.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

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


                do {

//                    var lines = Files.lines(Path
//                            .of("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_display"))
//                            .collect(Collectors.toList());
//                    lines.forEach(System.out::println);
                    System.out.println("H A N G M A N");
                    System.out.println();
                    System.out.println("+--+");
                    System.out.println();
                    game.printAZero(livesCounter);

                    System.out.println();
                    game.printLineOne(livesCounter);

                    System.out.println();
                    game.printLineTwo(livesCounter);

                    System.out.println("");
                    System.out.println("  ===");
                    System.out.println(game.missedLetters(missedLetters));

                    System.out.println("");
                    System.out.println("Guess a Letter");
                    String userInput = sc.nextLine();
                    userInput = game.getFirstLetter(userInput);
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
                    else if(!randomWord.contains(firstLetter) && missedLetters.contains(firstLetter)) {
                        System.out.println("you have used this letter already.");
                    }
                    else if (missedLetters.contains(firstLetter)) {
                        System.out.println("you have used this letter already.");
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
                            Files.write(Paths.get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\highScore"),
                                    game.numberScore(livesCounter).getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                            stillPlaying = true;

                        }
                        else if (userInput.equals("no")) {
                            //records number score only
                            Files.write(Paths.get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\highScore"),
                                    game.numberScore(livesCounter).getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                            //records entire score
                            Files.write(Paths
                                            .get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_score"),
                                    game.score(livesCounter, missedLetters).getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                            stillPlaying = false;
                        }
                        else {
                            Files.write(Paths.get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\highScore"),
                                    game.numberScore(livesCounter).getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                            Files.write(Paths
                                            .get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_score"),
                                    game.score(livesCounter, missedLetters).getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                            System.out.println("That is not an option. Ending game.");
                            stillPlaying = false;
                        }

                    }

                    if(livesCounter == 0) {
                        System.out.println("You have lost");

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
                        System.out.println();

                        System.out.println("!!!SCORE!!!");
                        System.out.print("Lives: " + livesCounter);
                        System.out.println("   Missed Letters: " + missedLetters);
                        System.out.println();

                        System.out.println("Do you want to play again? (yes or no)");
                        userInput = sc.nextLine();
                        if(userInput.equals("yes")) {
                            Files.write(Paths.get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\highScore"),
                                    game.numberScore(livesCounter).getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                            stillPlaying = true;
                        }
                        else if (userInput.equals("no")) {
                            Files.write(Paths.get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\highScore"),
                                    game.numberScore(livesCounter).getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                            Files.write(Paths
                                   .get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_score"),
                                    game.score(livesCounter, missedLetters).getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                            stillPlaying = false;
                        }
                        else {
                            Files.write(Paths.get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\highScore"),
                                    game.numberScore(livesCounter).getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

                            Files.write(Paths
                                            .get("C:\\Pyramid-Academy\\hangman functional\\src\\main\\resources\\hangman_score"),
                                    game.score(livesCounter, missedLetters).getBytes(StandardCharsets.UTF_8),
                                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                            System.out.println("That is not an option. Ending game.");
                            stillPlaying = false;
                        }
                    }


                } while (livesCounter != 0 && stillPlaying);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new StringIndexOutOfBoundsException("You did not enter anything");
        }


    }
}