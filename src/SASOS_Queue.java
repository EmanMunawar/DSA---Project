import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Passenger{
    int passengerID;
    String passengerName;
    Passenger(int passengerID,String passengerName){
        this.passengerID = passengerID;
        this.passengerName = passengerName;
    }
    public String toString(){
        return "Passenger ID = " + passengerID + " Passenger Name = " + passengerName;
    }


}
public class SASOS_Queue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Passenger> passengerQueue = new LinkedList<>();
        int choice;
        do{
            System.out.println("==========================================");
            System.out.println("===== Passenger Check in & Boarding ======");
            System.out.println("1. Add passenger to Queue");
            System.out.println("2. Serve next passenger");
            System.out.println("3. View next passenger");
            System.out.println("4. Display all passengers");
            System.out.println("5. Display Queue size");
            System.out.println("6. Exit");
            System.out.println("===========================================");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("=== Add Passenger ===");
                    System.out.println("Enter Passenger ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Passenger Name:");
                    String name = sc.nextLine();
                    Passenger p = new Passenger(id,name);
                    passengerQueue.offer(p);
                    System.out.println("Passenger Added Successfully!");
                    break;
                case 2:
                    System.out.println("=== Serve Next Passenger ===");
                    if (passengerQueue.isEmpty()){
                        System.out.println("No passenger available!");
                    } else {
                        Passenger served = passengerQueue.poll();
                        System.out.println("Passenger served:");
                        System.out.println(served);
                    }
                    break;
                case 3:
                    System.out.println("=== View Next Passenger ===");
                    if (passengerQueue.isEmpty()){
                        System.out.println("No next passenger available because Queue is Empty");
                    } else {
                        System.out.println("Next Passenger is:");
                        System.out.println(passengerQueue.peek());
                    }
                    break;
                case 4:
                    System.out.println("=== Display All Passengers ===");
                    if (passengerQueue.isEmpty()){
                        System.out.println("No passenger in the Queue!");
                    } else {
                        for (Passenger pa :passengerQueue ){
                            System.out.println(pa);
                        }
                    }
                    break;
                case 5:
                    System.out.println("=== Queue Size ===");
                    System.out.println("Current Queue Size = " + passengerQueue.size());
                    break;
                case 6:
                    System.out.println("Exiting Passenger Check in & Boarding... ");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    System.out.println("Enter only from 1-6!");
            }
        } while(choice != 6);
    }
}
