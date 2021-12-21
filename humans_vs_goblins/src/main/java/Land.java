import java.util.ArrayList;

public class Land {


    public Land() {

    }

//    public String gameBoard() {
//        for(int i = 0; i < 5; i++) {
//            for(int j = 0; j < 4; j++) {
//                System.out.print("|open|");
//            }
//            System.out.println("|open|");
//        }
//        return "";
//    }


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
        for(int i = 20; i < 25; i++) {
            System.out.print(grid.get(i));
        }
    }

    public void moveNorth(int position, Human human, ArrayList<Object> grid) {
        if(position - 5 <= 0) {
            //health = 0;
            System.out.println("You have fallen into a trap!");
        }
        grid.set(position - 5, human);
    }

    public void moveSouth(int position, Human human, ArrayList<Object> grid) {
        if(position + 5 >= 26) {
            //health = 0;
            System.out.println("You have fallen into a trap!");
        }
        grid.set(position + 5, human);
    }

    public void moveEast(int position, Human human, ArrayList<Object> grid) {
        grid.set(position + 1, human);
    }

    public void moveWest(int position, Human human, ArrayList<Object> grid) {

        grid.set(position - 1, human);
    }


    public String toString(){
        return "";
    }


    public static void main(String[] args) {
        Land land = new Land();
        Human human = new Human(7,100,100);
        Goblin goblin = new Goblin(8, 120, 100);
        //System.out.println(land);
        //System.out.println(land.gridArrayList);


//        land.gridArrayList.set(2,human);
//        System.out.println(land.gridArrayList);
//
//        for(int i = 0; i < land.gridArrayList.size(); i++) {
//            land.addHuman(human.getPosition(), human);
//        }
//        System.out.println(land);

    }
}
