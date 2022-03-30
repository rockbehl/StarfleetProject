import java.util.*;

public class Cargo extends Starship{



    Cargo(){
        setHLevelTable(100,25);
        setSLevelTable(50,15);
        setSpLevelTable(50,5);
        name = "Cargo # " + numbersAsStrings[rand.nextInt(8)]+numbersAsStrings[rand.nextInt(8)]+numbersAsStrings[rand.nextInt(8)];
        level = 1;
        speed = SplevelTable.get(0);
        wins = 0;
        health = HlevelTable.get(0);
        maxHealth = HlevelTable.get(0);
        shield = SlevelTable.get(0);
        cost = 500;
        type = "Cargo";
        state = true;
    }

    public int sendOnMission(){
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("  Welcome to the TRADE MARKET!");
        System.out.println("================================");
        PWR = speed+shield+health;
        //System.out.println(PWR);
        int[] dangerLvls = {25,55,80};
        int choice = 0;
        String[] Locales = {"Calden","Liberto","Erakis","IceCreamLand"};
        System.out.println("1. Scraps Delivery to "+Locales[rand.nextInt(Locales.length-1)]+" || "+(PWR/(dangerLvls[0]))*10+"% chance of MONEY!");
        System.out.println("2. Food Delivery to "+Locales[rand.nextInt(Locales.length-1)]+" || "+(PWR/(dangerLvls[1]))*10+"% chance of MONEY!");
        System.out.println("3. Precious Metals Delivery to "+Locales[rand.nextInt(Locales.length-1)]+" || "+(PWR/(dangerLvls[2]))*10+"% chance of MONEY!");
        System.out.println("4. Go Back");
        while (choice <1 || choice>3) {
            choice = userInput();
        }

        int chance;

        if (choice == 1){

            chance = (PWR/(dangerLvls[0]))*10;
            System.out.println(chance+"% chance of MONEY!");
            if (!(rand.nextInt(100*level) < chance)){
                System.out.println("Ship and Cargo was Destroyed!");
                health = 0;
                state = false;
                return 0;
            } else {
                System.out.println("Delivery Successful!");
                health = rand.nextInt(maxHealth);
                if (health == 0){
                    health+=10;
                }
                wins++;
                return 75;
            }

        } else if (choice == 2){

            chance = (PWR/(dangerLvls[1]))*10;
            System.out.println(chance+"% chance of MONEY!");
            if (!(rand.nextInt(100*level) <chance)){
                System.out.println("Ship and Cargo was Destroyed!");
                return 0;
            } else {
                System.out.println("Delivery Successful!");
                health = rand.nextInt(maxHealth);
                if (health == 0){
                    health+=10;
                }
                wins++;
                return 100;
            }
        } else if (choice == 3){

            chance = (PWR/(dangerLvls[2]))*10;
            System.out.println(chance+"% chance of MONEY!");
            if (!(rand.nextInt(100*level) <chance)){
                System.out.println("Ship and Cargo was Destroyed!");
                return 0;
            } else {
                System.out.println("Delivery Successful!");
                health = rand.nextInt(maxHealth);
                if (health == 0){
                    health+=10;
                }
                wins++;
                return 150+(10*level);
            }
        } else {
            return 0;
        }

    }

    public int upgradeShip(){
        level++;
        if (level == HlevelTable.size()){
            System.out.println("Ship Maxed!");
            return 0;
        } else {
            health = HlevelTable.get(level - 1);
            maxHealth = HlevelTable.get(level - 1);
            speed = HlevelTable.get(level - 1);
            shield = HlevelTable.get(level - 1);
            return -150;
        }
    }

}
