import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Starship {

    protected String name;
    protected boolean state;
    protected String type;
    protected int level;
    protected int PWR;
    protected int cost;
    protected int shield;
    protected int health;
    protected int maxHealth;
    protected int wins;
    protected int speed;
    protected String[] numbersAsStrings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    protected Random rand = new Random();
    protected HashMap<Integer,Integer> HlevelTable = new HashMap<>();
    protected HashMap<Integer,Integer> SlevelTable = new HashMap<>();
    protected HashMap<Integer,Integer> SplevelTable = new HashMap<>();

    Starship(){

    }

    public static int userInput(){
        Scanner sc = new Scanner(System.in);
        int _choice = 0;
        boolean valid = false;
        while (!valid) {
            //sc.nextLine();
            _choice = 0;
            //System.out.print("|| Enter Selection: ");
            try {
                System.out.print("|| Enter Selection: ");
                _choice = sc.nextInt();
                valid = true;
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                sc.nextLine();
            }
        }
        return _choice;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isState() {
        return state;
    }

    public int sendOnMission() {
        return 0;
    }

    public int upgradeShip() {
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void repair(){
        health = maxHealth;
    }

    public int getWins() {
        return wins;
    }

    public int getShield() {
        return shield;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHLevelTable(int x, int y){ // (InitVal, "r"Val))
        HlevelTable.put(0,x);
        for (int i = 0; i < 10; i++) {
            HlevelTable.put(i+1, HlevelTable.get(i)+y);
        }
    }

    public void setSLevelTable(int x, int y){ // (InitVal, "r"Val))
        SlevelTable.put(0,x);
        for (int i = 0; i < 10; i++) {
            SlevelTable.put(i+1, SlevelTable.get(i)+y);
        }
    }

    public void setSpLevelTable(int x, int y){ // (InitVal, "r"Val))
        SplevelTable.put(0,x);
        for (int i = 0; i < 10; i++) {
            HlevelTable.put(i+1, HlevelTable.get(i)+y);
        }
    }
}
