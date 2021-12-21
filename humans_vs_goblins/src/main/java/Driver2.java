import java.util.ArrayList;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Land land = new Land();
        ArrayList<Object> gridArrayList = new ArrayList<>();
        int humanStartPos = (int)(Math.random() * 19);
        Human human = new Human(humanStartPos,100,100);
        int goblinStartPos = (int)(Math.random() * 19);
        Goblin goblin = new Goblin(goblinStartPos,100,50);

        if(humanStartPos == goblinStartPos) {
            gridArrayList.set(0, human);
            gridArrayList.set(24, goblin);
        }

        for(int i = 0; i < 20; i++) {
            gridArrayList.add("Safe ");
        }

        gridArrayList.set(goblin.getPosition(), goblin);
        gridArrayList.set(human.getPosition(), human);
        land.updateGame(gridArrayList);

        //while ()
        boolean isHumanTurn = true;
        boolean isGoblinTurn = true;
        while (true) {
            do {
                System.out.println();
                System.out.println("Human's turn. Choose N, S, E, W");
                String userInput = sc.nextLine();

                switch (userInput) {
                    case "N": {
                        gridArrayList.set(land.moveNorth(human), human);
                        gridArrayList.set(gridArrayList.lastIndexOf(human), "Safe ");
                        land.updateGame(gridArrayList);
                        isHumanTurn = false;
                        break;
                    }
                    case "S": {
                        gridArrayList.set(land.moveSouth(human), human);
                        gridArrayList.set(gridArrayList.indexOf(human), "Safe ");
                        System.out.println();
                        land.updateGame(gridArrayList);
                        isHumanTurn = false;
                        break;
                    }
                    case "E": {
                        gridArrayList.set(land.moveEast(human), human);
                        gridArrayList.set(gridArrayList.indexOf(human), "Safe ");
                        System.out.println(gridArrayList);
                        land.updateGame(gridArrayList);
                        isHumanTurn = false;
                        break;
                    }
                    case "W": {
                        gridArrayList.set(land.moveWest(human), human);
                        gridArrayList.set(gridArrayList.lastIndexOf(human), "Safe ");
                        System.out.println(gridArrayList);
                        land.updateGame(gridArrayList);
                        isHumanTurn = false;
                        break;
                    }
                    default: {
                        System.out.println("nothing happens");
                    }
                }
            } while (isHumanTurn);

            do {
                System.out.println();
                System.out.println("Goblin's turn. Choose N, S, E, W");
                String userInput = sc.nextLine();

                switch (userInput) {
                    case "N": {
                        gridArrayList.set(land.moveGoblinNorth(goblin), goblin);
                        gridArrayList.set(gridArrayList.lastIndexOf(goblin), "Safe ");
                        land.updateGame(gridArrayList);
                        isGoblinTurn = false;
                        break;
                    }
                    case "S": {
                        gridArrayList.set(land.moveGoblinSouth(goblin), goblin);
                        gridArrayList.set(gridArrayList.indexOf(goblin), "Safe ");
                        land.updateGame(gridArrayList);
                        isGoblinTurn = false;
                        break;
                    }
                    case "E": {
                        gridArrayList.set(land.moveGoblinEast(goblin), goblin);
                        gridArrayList.set(gridArrayList.indexOf(goblin), "Safe ");
                        land.updateGame(gridArrayList);
                        isGoblinTurn = false;
                        break;
                    }
                    case "W": {
                        gridArrayList.set(land.moveGoblinWest(goblin), goblin);
                        gridArrayList.set(gridArrayList.lastIndexOf(goblin), "Safe ");
                        land.updateGame(gridArrayList);
                        isGoblinTurn = false;
                        break;
                    }
                    default: {
                        System.out.println("nothing happens");
                    }

                }
            } while (isGoblinTurn);

        }


    }
}
