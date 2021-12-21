import java.util.ArrayList;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Land land = new Land();
        ArrayList<Object> gridArrayList = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
//            gridArrayList.add("| " + i + " |");
            gridArrayList.add("Safe ");
        }
        int humanStartPos = (int)(Math.random() * 19);
        Human human = new Human(humanStartPos,100,100);

        gridArrayList.set(human.getPosition(), human);
        land.updateGame(gridArrayList);

        while (true) {
            System.out.println();
            System.out.println("Human's turn. Choose N, S, E, W");
            String userInput = sc.nextLine();

            switch (userInput) {
                case "N": {
                    gridArrayList.set(land.moveNorth(human), human);
                    gridArrayList.set(gridArrayList.lastIndexOf(human), "Safe ");
                    land.updateGame(gridArrayList);
                    break;
                }
                case "S": {
                    gridArrayList.set(land.moveSouth(human), human);
                    gridArrayList.set(gridArrayList.indexOf(human), "Safe ");
                    System.out.println();
                    land.updateGame(gridArrayList);
                    break;
                }
                case "E": {
                    gridArrayList.set(land.moveEast(human), human);
                    gridArrayList.set(gridArrayList.indexOf(human), "Safe ");
                    System.out.println(gridArrayList);
                    land.updateGame(gridArrayList);
                    break;
                }
                case "W": {
                    gridArrayList.set(land.moveWest(human), human);
                    gridArrayList.set(gridArrayList.lastIndexOf(human), "Safe ");
                    System.out.println(gridArrayList);
                    land.updateGame(gridArrayList);
                    break;
                }
                default: {
                    System.out.println("nothing happens");
                }
            }
        }


    }
}
