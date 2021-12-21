import java.util.ArrayList;

public class Land {


    public Land() {

    }

    public void updateGame(ArrayList<Object> grid) {
        for(int i = 0; i < 5; i++) {
            System.out.print(grid.get(i));
        }
        System.out.println();
        for(int i = 5; i < 10; i++) {
            System.out.print(grid.get(i));
        }
        System.out.println();
        for(int i = 10; i < 15; i++) {
            System.out.print(grid.get(i));
        }
        System.out.println();
        for(int i = 15; i < 20; i++) {
            System.out.print(grid.get(i));
        }
        System.out.println();
//        for(int i = 20; i < 25; i++) {
//            System.out.print(grid.get(i));
//        }
    }

    public int moveNorth(Human human) {
        human.setPosition(human.getPosition() - 5);
        return human.getPosition();
    }

    public int moveSouth(Human human) {
        human.setPosition(human.getPosition() + 5);
        return human.getPosition();
    }

    public int moveEast(Human human) {
        human.setPosition(human.getPosition() + 1);
        return human.getPosition();
    }

    public int moveWest(Human human) {
        human.setPosition(human.getPosition() - 1);
        return human.getPosition();
    }

    public int moveGoblinNorth(Goblin goblin) {
        goblin.setPosition(goblin.getPosition() - 5);
        return goblin.getPosition();
    }

    public int moveGoblinSouth(Goblin goblin) {
        goblin.setPosition(goblin.getPosition() + 5);
        return goblin.getPosition();
    }

    public int moveGoblinEast(Goblin goblin) {
        goblin.setPosition(goblin.getPosition() + 1);
        return goblin.getPosition();
    }

    public int moveGoblinWest(Goblin goblin) {
        goblin.setPosition(goblin.getPosition() - 1);
        return goblin.getPosition();
    }

    public void combat(Human human, Goblin goblin) {
        if (human.getPosition() == goblin.getPosition() + 1 ||
                human.getPosition() == goblin.getPosition() - 1 ||
                human.getPosition() == goblin.getPosition() + 5 ||
                human.getPosition() == goblin.getPosition() - 5)
        {
            human.attackGoblin(goblin);
            System.out.println(human.getHealth());
            System.out.println(goblin.getHealth());
        }
    }

    public boolean didGoblinsWin(ArrayList<Object> a, Human human, Goblin goblin) {
        if (!a.contains(goblin)) {
            System.out.println("Humans win!");
            return false;
        } else if (!a.contains(human)) {
            System.out.println("Goblins win!");
            return true;
        }
        System.out.println("still fighting");
            return false;

    }


    public String toString() {
        return "War between Humans and Goblins";
    }


}