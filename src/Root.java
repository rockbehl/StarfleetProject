import java.util.Scanner;

public class Root {

    static Starfleet starfleet = new Starfleet();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //active combat
        int plutonium = 1000;
        int choice = 0;

        while (choice != 5) {

            System.out.println("Welcome to STARFLEET COMMANDER   ||  Plutonium: " + plutonium);
            System.out.println("1. List Ships");
            System.out.println("2. Buy/Sell Ships");
            System.out.println("3. Upgrade Ships");
            System.out.println("4. Send Ships on Missions");
            System.out.println("5. Exit");

                switch (userInput()) {
                    case 1 -> plutonium = shipInterface(plutonium);
                    case 2 -> plutonium = BSShips(plutonium);
                    case 3 -> plutonium = upgradeShips(plutonium);
                    case 4 -> plutonium = sendOnMission(plutonium);
                    case 5 -> choice = 5;
                }

            if (plutonium <= 0){
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                break;
            }
        }

        if (plutonium <= 0){
            System.out.println("You went Broke!");
        } else {
            System.out.println("Thanks for Playing!");
        }

    }

    private static int sendOnMission(int plutonium) {
        System.out.println("================================");
        listShips();
        System.out.print("Choose a ship to send on mission: ");

        plutonium += starfleet.getFleet().get(userInput()-1).sendOnMission();

        starfleet.checkFleet();

        return plutonium;
    }

    private static int upgradeShips(int plutonium) {

        System.out.println("================================");
        listShips();
        System.out.print("Choose a ship to upgrade: ");

        return plutonium + starfleet.getFleet().get(userInput()-1).upgradeShip();

    }

    private static int BSShips(int plutonium) {
        System.out.println("================================");
        System.out.println("1. Buy a ship");
        System.out.println("2. Sell a ship");
        System.out.println("3. Go Back");

        switch (userInput()){
            case 1 -> plutonium -= starfleet.buyShips();
            case 2 -> plutonium += starfleet.sellShips();
        }

        System.out.println();

        return plutonium;

    }

    private static void listShips() {
        System.out.println("================================");
        for (int i = 0; i < starfleet.getFleet().size(); i++) {
            System.out.print((i+1) + "/ " + starfleet.getFleet().get(i).getName());
            System.out.println(" || Health: "+ starfleet.getFleet().get(i).getHealth()+" || Level: "+starfleet.getFleet().get(i).getLevel());
        }
    }

    private static int shipInterface(int plutonium){
        listShips();
        System.out.println("Repair (1) || More Info (2) || Rename (3) || Exit (4)");
        int choice = userInput();
        if (choice == 3){
            choice = 0;
            listShips();
            System.out.println("Choose a Ship to Rename ");
            while (choice < 1 || choice > starfleet.getFleet().size()) {
                System.out.print("{} Enter Selection: ");
                choice = sc.nextInt();
            }
            sc.nextLine();
            System.out.println("Enter New name: ");
            String newName = sc.nextLine();
            starfleet.getFleet().get(choice-1).setName(newName);
            System.out.println();
            return plutonium;
        } else if (choice == 1){
            choice = -1;
            System.out.println("0. Repair All: $"+starfleet.getFleet().size()*175);
            listShips();
            System.out.println("Choose Ship to Repair ");
            while (choice < 0 || choice > starfleet.getFleet().size()) {
                System.out.print("{} Enter Selection: ");
                choice = sc.nextInt();
            }
            if (choice == 0){
                for (int i = 0; i < starfleet.getFleet().size(); i++) {
                    starfleet.getFleet().get(i).repair();
                }
                System.out.println("All "+ (starfleet.getFleet().size()+1) +" done!");
                return plutonium - starfleet.getFleet().size()*175;
            } else {

                starfleet.getFleet().get(choice-1).repair();
                System.out.println(starfleet.getFleet().get(choice-1).getName()+" is ready to go!");

                return plutonium-175;
            }

        } else if (choice == 2){

            System.out.println("================================");
            for (int i = 0; i < starfleet.getFleet().size(); i++) {
                System.out.print((i+1) + "/ " + starfleet.getFleet().get(i).getName());
                System.out.println(" || Mission Wins: "+starfleet.getFleet().get(i).getWins()+" || Shield: "+starfleet.getFleet().get(i).getShield()+" || Speed: "+starfleet.getFleet().get(i).getSpeed());
            }
            return plutonium;
        } else {
            return plutonium;
        }
    }

    private static int userInput(){
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

}
