import java.lang.reflect.Array;

public class Human {
    private int position;
    private int attackPower;
    private int health;
    private boolean isAlive;


    public Human() {

    }

    public Human(int position, int attackPower, int health) {
        this.position = position;
        this.attackPower = attackPower;
        this.health = health;

    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int moveNorth() {
        if(this.position - 5 <= 0) {
            this.health = 0;
            System.out.println("You have fallen into a trap!");
        }
        return this.position - 5;
    }

    public int moveSouth() {
        if(this.position + 5 >= 26) {
            this.health = 0;
            System.out.println("You have fallen into a lava pool!");
        }
        return this.position + 5;
    }

    public int moveEast() {
        int[] outOfBounds = new int[]{5, 10, 15, 20, 25};
        for(int i = 0; i < outOfBounds.length; i++) {
            if(this.position == outOfBounds[i]) {
                this.health = 0;
                System.out.println("You have been attacked by locals!");
            }
        }
        return this.position - 5;
    }

    public int moveWest() {
        int[] outOfBounds = new int[]{1, 6, 11, 16, 21};
        for(int i = 0; i < outOfBounds.length; i++) {
            if(this.position == outOfBounds[i]) {
                this.health = 0;
                System.out.println("You don't feel like fighting anymore!");
            }
        }
        return this.position - 5;
    }

    public int attackGoblin(Goblin goblin) {
        return this.attackPower - goblin.getHealth();
    }

    public String toString(){
        return "HUMAN ";
    }
}
