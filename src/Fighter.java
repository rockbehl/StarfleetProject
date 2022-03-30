import java.util.HashMap;
import java.util.Random;

public class Fighter extends Starship{

    Random rand = new Random();
    HashMap<Integer, Integer> lootTable = new HashMap<>();

    Fighter(){
        setHLevelTable(50,10);
        setSLevelTable(100,10);
        setSpLevelTable(100,10);
        name = "Fighter # " + numbersAsStrings[rand.nextInt(8)]+numbersAsStrings[rand.nextInt(8)]+numbersAsStrings[rand.nextInt(8)];
        level = 1;
        speed = SplevelTable.get(0);
        wins = 0;
        health = HlevelTable.get(0);
        maxHealth = HlevelTable.get(0);
        shield = SlevelTable.get(0);
        cost = 250;
        type = "Fighter";
        state = true;

        lootTable.put(1, 66);
        lootTable.put(2, 20);
        lootTable.put(3, 30);
        lootTable.put(4, 90);
        lootTable.put(5, 99);
    }

    public int sendOnMission(){
        int moneyRet;
        String[] rewardNames = {"+1 Health Boost","+300 plutonium","+10 Health Boost","+50 plutonium","Scraps"};
        System.out.println("================================");
        System.out.println("You Encounter an Enemy!");
        System.out.println("Pilot: I got this cap.");
        PWR = speed+shield+health;
       // System.out.println(PWR);
        int chance = (PWR/rand.nextInt(100)*level)*10;
        if ((rand.nextInt(100*level) < chance)){
            moneyRet = 200;
            System.out.println("Pilot: WOOHOOO!");
            System.out.println("The Enemy was Destroyed!");
            health = rand.nextInt(maxHealth);
            if (health == 0){
                health+=10;
            }
            int loot = rand.nextInt(4);
            int lootChance = lootTable.get(loot)+health;
            if (rand.nextInt(100)< lootChance){
                System.out.println("You got: " + rewardNames[loot-1]);
                moneyRet += giveReward(loot-1);
            } else {
                System.out.println("Too much damage to claim reward :(");
                health=health/2;
            }
            wins++;
            return moneyRet;
        } else {
            System.out.println("Pilot: Tell my kids I love them :{");
            System.out.println("The Enemy Destroyed "+ name);
            health=0;
            state=false;
            return 0;
        }
    }

    private int giveReward(int i) {
        if (i==0){
            health++;
            return 0;
        } else if (i==1) {
            return 300;
        } else if (i==2){
            health = health+10;
            return 0;
        } else if (i==3){
            return 50;
        } else if (i==4){
            shield++;
            return 0;
        } else {
            return 0;
        }
    } //MASTER FUNC = sendOnMission()

    public int upgradeShip(){
        level++;
        if (level == HlevelTable.size()){
            System.out.println("Ship Maxed!");
            return 0;
        } else {
            health = HlevelTable.get(level - 1);
            return -150;
        }
    }

}
