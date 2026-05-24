// SASOS Module 1
// Security Tray & Emergency Alert Management

import java.util.Scanner;
import java.util.Stack;

class Tray{
    int trayID;
    String pName;
    Tray(int trayID,String pName){
        this.trayID = trayID;
        this.pName = pName;
    }
    public String toString(){
        return "Tray ID = " + trayID + " Passenger Name = " + pName;
    }
}
public class SASOS{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Tray> trayStack = new Stack<>();
        Stack<String> alertStack = new Stack<>();
        int choice;
        do{
            System.out.println("=====================================================");
            System.out.println("===== Smart Airport Security & Operating System =====");
            System.out.println("1- Add Tray");
            System.out.println("2- Remove Latest Tray");
            System.out.println("3- View Latest Tray");
            System.out.println("4- Add Security Alert");
            System.out.println("5- Remove Latest Security Alert");
            System.out.println("6- View Latest Security Alert");
            System.out.println("7- Display all Trays & Alerts");
            System.out.println("8- Exit the System");
            System.out.println("=====================================================");
            System.out.println("Enter your choice from 1-8");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("=== Add Tray ===");
                    System.out.println("Enter Tray ID:");
                    int ID = sc.nextInt();
                    System.out.println("Enter Passenger Name");
                    String name = sc.nextLine();
                    Tray t = new Tray(ID,name);
                    trayStack.push(t);
                    System.out.println("Tray Added Successfully!");
                    break;
                case 2:
                    System.out.println("=== Remove Latest Tray ===");

            }
        }


    }

}