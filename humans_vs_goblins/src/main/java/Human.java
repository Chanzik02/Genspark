import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;

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


    public void attackGoblin(Goblin goblin) {
        try {
            if (this.attackPower >= goblin.getHealth()) {
                goblin.setHealth(0);
            }
            else {
                int afterMathDamage = (int)(Math.random() * 15);
                goblin.setHealth(goblin.getHealth() - this.attackPower);
                this.setHealth(this.getHealth() - afterMathDamage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String toString(){
        String humanString = "HUMAN";
        byte[] bytes = humanString.getBytes(StandardCharsets.UTF_8);

        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        return utf8EncodedString + " ";
//        return "HUMAN";
    }
}
