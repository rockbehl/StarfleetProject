import java.util.ArrayList;
import java.util.Scanner;

public class Starfleet {

   private ArrayList<Starship> fleet = new ArrayList<>();
   Scanner sc = new Scanner(System.in);

    Starfleet(){
        fleet.add(new Cargo());
        fleet.add(new Fighter());
    }

    public ArrayList<Starship> getFleet() {
        return fleet;
    }
    
    public int buyShips(){
        System.out.println();
        System.out.println("Fighter <250> (1) or Cargo <500> (2)");
        int choice = 0;
        while (choice < 1 || choice > 2){
            System.out.print("{} Enter Selection: ");
            choice = sc.nextInt();
        } 
        if (choice == 1){
            fleet.add(new Fighter());
            return 250;
        } else {
            fleet.add(new Cargo());
            return 500;
        }
    }

    public int sellShips() {
        System.out.println();
        for (int i = 0; i < fleet.size(); i++) {
            System.out.println((i+1) + "/ " + fleet.get(i).getName());
        }
        System.out.println();
        int choice = 0;
        while (choice < 1 || choice > fleet.size()+1){
            System.out.print("{} Enter Selection: ");
            choice = sc.nextInt();
        }

        if (fleet.get(choice-1).getType().equals("Fighter")){
            fleet.remove(choice-1);
            return 250;
        } else {
            fleet.remove(choice-1);
            return 500;
        }
    }

    public void checkFleet(){
        for (int i = 0; i < fleet.size(); i++) {
            if (!fleet.get(i).isState()){
                fleet.remove(i);
            }
        }
    }

}
