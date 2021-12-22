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

    public void humanCombat(Human human, Goblin goblin) {
        if (human.getPosition() == goblin.getPosition() + 1 ||
                human.getPosition() == goblin.getPosition() - 1 ||
                human.getPosition() == goblin.getPosition() + 5 ||
                human.getPosition() == goblin.getPosition() - 5)
        {
            System.out.println("Human power: " + human.getAttackPower());
            System.out.println("Goblin health: " + goblin.getHealth());
            human.attackGoblin(goblin);
            System.out.println("Human health: " + human.getHealth());
            System.out.println("Goblin health: " + goblin.getHealth());
        }
    }

    public void goblinCombat(Goblin goblin, Human human) {
        if (goblin.getPosition() == human.getPosition() + 1 ||
                goblin.getPosition() == human.getPosition() - 1 ||
                goblin.getPosition() == human.getPosition() + 5 ||
                goblin.getPosition() == human.getPosition() - 5)
        {
            System.out.println("Goblin power: " + goblin.getAttackPower());
            System.out.println("Human health: " + human.getHealth());
            goblin.attackHuman(human);
            System.out.println("Goblin health: " + goblin.getHealth());
            System.out.println("Human health: " + human.getHealth());
        }
    }

    public void removeFromGame(ArrayList<Object> gridArrayList, Human human, Goblin goblin) {
        if (human.getHealth() == 0) {
            gridArrayList.set(human.getPosition(), "Safe ");

        }
        else if (human.getHealth() > 0) {
            //System.out.println(human.getHealth() + "test");
        }
        else if (goblin.getHealth() == 0) {
            gridArrayList.set(goblin.getPosition(), "Safe ");
        }
    }


    public String toString() {
        return "War between Humans and Goblins";
    }


}