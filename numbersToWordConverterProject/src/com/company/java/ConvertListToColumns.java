import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertListToColumns {
    public ArrayList<String> oneToSevenToArrayList() throws IOException {
        Imports imports = new Imports();
        List <String> list = imports.oneToSevenImports();
        ArrayList<String> wordsByColumns = new ArrayList<>();

        int i = 0;
        int columns = (int)Math.floor(list.size() / 2);
        while(i < columns){
            //combine the first and third word from the original list (not the last word... it'll throw and exception) and add them to a new ArrayList
            wordsByColumns.add(list.get(i) +" "+list.get(i + 4) + "\n");
            i++;
        }
        //add the last number from the original list into the list
        wordsByColumns.add(list.get(list.size() - 1));
        System.out.println(wordsByColumns);
        //return the arrayList we just created so that it can be processed into a file
        return wordsByColumns;
    }

    public String OneToSevenArrayListToFile() throws IOException {
        //convert the final Arraylist containing the matched strings to a string
        String string = String.join("", oneToSevenToArrayList());
        //write to a file the results
        Files.write(Paths.get("src/com/company/resources/OneToSevenSolution"), Collections.singleton(string), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        return string;
    }

    /*
     * This method is intended for 1 to  25 lines, but can be adjusted.
     * This method will read the current line of the file. Starting with line 1.
     * Next, find the next two lines in increments of 9 and append to line 1.
     * For example, lines 1, 10, and 19 will append to create one String
     * Then write the new String to another file.
     * This loop end before and IndexOutOfBounds is achieved.
     */
    public void oneToTwentyFive() throws IOException {
        //Create list containing 25 elements
        Imports imports = new Imports();
        List myList = imports.oneToTwentyFiveImports();

        //Write list to a file.
        Files.write(Paths.get("src/com/company/resources/OneToTwentyFive"), myList, StandardCharsets.UTF_8, StandardOpenOption.CREATE);

        //This loop will read the current line and append the next 2 lines that are increments of 9.
        //Ex: String newString = Line 1 + line 10 + line 19
        //newString will be written to a new file and loop until done.
        int x = 0;
        int y = x + 9;
        int z = x + 9 + 9;
        while(x < myList.size() - 9) {
            var firstLine = Files.readAllLines(Paths.get("src/com/company/resources/OneToTwentyFive")).get(x);
            var secondLine = Files.readAllLines(Paths.get("src/com/company/resources/OneToTwentyFive")).get(y);
            var thirdLine = Files.readAllLines(Paths.get("src/com/company/resources/OneToTwentyFive")).get(z);
            var stringToWrite = firstLine + " " + secondLine + " "  + thirdLine + "\n";
            Files.write(Paths.get("src/com/company/resources/OneToTwentyFiveSolution.txt"), stringToWrite.getBytes(StandardCharsets.UTF_8),StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            x = x + 1;
            y = x + 9;
            z = x + 9 + 9;

            if (z == myList.size()) {
                break;
            }
        }
    }


}
