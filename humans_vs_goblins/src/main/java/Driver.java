import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Land land = new Land();
        ArrayList<Object> gridArrayList = new ArrayList<>();

        for(int i = 0; i < 25; i++) {
            gridArrayList.add("| " + i + " |");
        }
        int humanPos = (int)(Math.random() * 24);
        int goblinPos = (int)(Math.random() * 24);
        Human human = new Human(humanPos,100,100);
        Goblin goblin = new Goblin(goblinPos, 120, 100);

        gridArrayList.set(human.getPosition(), human);
        gridArrayList.set(goblin.getPosition(), goblin);
        land.updateGame(gridArrayList);

        if (gridArrayList.contains("GOBLINHUMAN")) {
            System.out.println("There was no victor.");
        }

        System.out.println();
//        System.out.println(gridArrayList.indexOf(human));
//        System.out.println(human.getPosition());
//        System.out.println(goblinPos);
//        System.out.println(gridArrayList.indexOf(goblin));
//        System.out.println();
        if (human.getPosition() - goblin.getPosition() == 1 ||
                goblin.getPosition() - human.getPosition() == 1 ||
                human.getPosition() - goblin.getPosition() == 5 ||
                goblin.getPosition() - human.getPosition() == 5)
        {
            human.attackGoblin(goblin);

//            if (goblin.getHealth() <= 0) {
//
//            }
            System.out.println("Human wins");
        }

        System.out.println("Human's turn. Choose N, S, E, W");
        String userInput = sc.nextLine();

        switch (userInput) {
            case "N": {
                gridArrayList.set(gridArrayList.indexOf(human), gridArrayList.indexOf(human));
                land.moveNorth(human.getPosition(), human, gridArrayList);
                land.updateGame(gridArrayList);
                break;
            }
            case "S": {
                gridArrayList.set(gridArrayList.indexOf(human), gridArrayList.indexOf(human));
                land.moveSouth(human.getPosition(), human, gridArrayList);
                land.updateGame(gridArrayList);
                break;
            }
            case "E": {
                gridArrayList.set(gridArrayList.indexOf(human), gridArrayList.indexOf(human));
                land.moveEast(human.getPosition(), human, gridArrayList);
                land.updateGame(gridArrayList);
                break;
            }
            case "W": {
                gridArrayList.set(gridArrayList.indexOf(human), gridArrayList.indexOf(human));
                land.moveWest(human.getPosition(), human, gridArrayList);
                land.updateGame(gridArrayList);
                break;
            }
        }


        if (human.getPosition() == goblin.getPosition() + 1 ||
                human.getPosition() == goblin.getPosition() - 1 ||
                human.getPosition() == goblin.getPosition() + 5 ||
                human.getPosition() == goblin.getPosition() - 5)
        {
            human.attackGoblin(goblin);
            System.out.println("human wins");
        }
//        if (goblin.getHealth() <= 0) {
//            System.out.println("Human is the victor.");
//        }
//        if(!gridArrayList.contains(human)) {
//            System.out.println("Goblin is the vic.");
//        } else {
//            System.out.println("Human is the vic.");
//        }


    }
}
