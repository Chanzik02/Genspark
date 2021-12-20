import java.util.ArrayList;

public class Land {

    public Land() {

    }

    public String createGrid() {
        ArrayList<Object> grid = new ArrayList<>(25);
        for(int i = 1; i < 26; i++) {
            grid.add(i);
        }
        System.out.println(grid);

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print("|open|");
            }
            System.out.println("|open|");
        }

        return "";
    }

//    public int addHuman(Human human) {
//
//    }

    public String toString(){
        return "";
    }


    public static void main(String[] args) {
        Land land = new Land();
        land.createGrid();
    }
}
