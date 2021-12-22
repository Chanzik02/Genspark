import java.util.ArrayList;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Land land = new Land();
        ArrayList<Object> gridArrayList = new ArrayList<>();
        int humanStartPos = (int)(Math.random() * 19);
        Human human = new Human(humanStartPos,100,200);
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


        while(gridArrayList.contains(human) && gridArrayList.contains(goblin))   {


                System.out.println();
                System.out.println("Human's turn. Choose N, S, E, W");
                String firstInput = sc.nextLine();
                String firstLetter = firstInput.charAt(0) + "";
                String userInput = firstLetter.toLowerCase();

                switch (userInput) {
                    case "n": {
                        gridArrayList.set(land.moveNorth(human), human);
                        gridArrayList.set(gridArrayList.lastIndexOf(human), "Safe ");
                        land.updateGame(gridArrayList);
                        land.combat(human, goblin);
                        if (human.getHealth() == 0) {
                            gridArrayList.set(human.getPosition(), "Safe ");

                        } else if (goblin.getHealth() == 0) {
                            gridArrayList.set(goblin.getPosition(), "Safe ");
                        }
                        break;
                    }
                    case "s": {
                        gridArrayList.set(land.moveSouth(human), human);
                        gridArrayList.set(gridArrayList.indexOf(human), "Safe ");
                        land.updateGame(gridArrayList);
                        land.combat(human, goblin);
                        if (human.getHealth() == 0) {
                            gridArrayList.set(human.getPosition(), "Safe ");

                        } else if (goblin.getHealth() == 0) {
                            gridArrayList.set(goblin.getPosition(), "Safe ");
                        }
                        break;
                    }
                    case "e": {
                        gridArrayList.set(land.moveEast(human), human);
                        gridArrayList.set(gridArrayList.indexOf(human), "Safe ");
                        land.updateGame(gridArrayList);
                        land.combat(human, goblin);
                        if (human.getHealth() == 0) {
                            gridArrayList.set(human.getPosition(), "Safe ");

                        } else if (goblin.getHealth() == 0) {
                            gridArrayList.set(goblin.getPosition(), "Safe ");
                        }
                        break;
                    }
                    case "w": {
                        gridArrayList.set(land.moveWest(human), human);
                        gridArrayList.set(gridArrayList.lastIndexOf(human), "Safe ");
                        land.updateGame(gridArrayList);
                        land.combat(human, goblin);
                        if (human.getHealth() == 0) {
                            gridArrayList.set(human.getPosition(), "Safe ");

                        } else if (goblin.getHealth() == 0) {
                            gridArrayList.set(goblin.getPosition(), "Safe ");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Attack");
                        land.combat(human, goblin);
                        if (human.getHealth() == 0) {
                            gridArrayList.set(human.getPosition(), "Safe ");

                        } else if (goblin.getHealth() == 0) {
                            gridArrayList.set(goblin.getPosition(), "Safe ");
                        }
                        break;
                        }
                    }





            if(gridArrayList.contains(goblin)) {
                System.out.println();
                System.out.println("Goblin's turn. Choose N, S, E, W");
                userInput = sc.nextLine();

                switch (userInput) {
                    case "n": {
                        gridArrayList.set(land.moveGoblinNorth(goblin), goblin);
                        gridArrayList.set(gridArrayList.lastIndexOf(goblin), "Safe ");
                        break;
                    }
                    case "s": {
                        gridArrayList.set(land.moveGoblinSouth(goblin), goblin);
                        gridArrayList.set(gridArrayList.indexOf(goblin), "Safe ");
                        break;
                    }
                    case "e": {
                        gridArrayList.set(land.moveGoblinEast(goblin), goblin);
                        gridArrayList.set(gridArrayList.indexOf(goblin), "Safe ");
                        break;
                    }
                    case "w": {
                        gridArrayList.set(land.moveGoblinWest(goblin), goblin);
                        gridArrayList.set(gridArrayList.lastIndexOf(goblin), "Safe ");
                        break;
                    }
                    default: {
                        System.out.println("nothing happens");
                        break;
                    }

                }
                land.updateGame(gridArrayList);
            }



            //System.out.println(land.didGoblinsWin(gridArrayList, human, goblin));


        }




    }
}
