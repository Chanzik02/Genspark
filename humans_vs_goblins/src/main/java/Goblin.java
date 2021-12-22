public class Goblin {
    private int position;
    private int attackPower;
    private int health;
    private int move;
    private boolean isAlive;

    public Goblin() {

    }

    public Goblin(int position, int attackPower, int health) {
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

    public void attackHuman(Human human) {
        if (this.attackPower >= human.getHealth()) {
            human.setHealth(0);
        }
        else {
            human.setHealth(human.getHealth() - this.attackPower);
        }

    }

    public String toString(){
        return "GOBLIN ";
    }
}
