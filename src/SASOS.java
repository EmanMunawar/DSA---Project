// SASOS Module 1 using STACK implementation
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
                    sc.nextLine();
                    System.out.println("Enter Passenger Name");
                    String name = sc.nextLine();

                    Tray t = new Tray(ID,name);
                    trayStack.push(t);
                    System.out.println("Tray Added Successfully!");
                    break;
                case 2:
                    System.out.println("=== Remove Latest Tray ===");
                    if(trayStack.isEmpty()){
                        System.out.println("You cannot Remove Tray from Stack because Stack is Empty!");
                    } else {
                        Tray removedTray = trayStack.pop();
                        System.out.println("Removed Tray:\n " + removedTray);
                    }
                    break;
                case 3:
                    System.out.println("=== View Latest Tray ===");
                    if(trayStack.isEmpty()){
                        System.out.println("You cannot View Tray from Stack because Stack is Empty!");
                    } else {
                        System.out.println("Latest Tray: \n" + trayStack.peek());
                    }
                    break;
                case 4:
                    System.out.println("=== Add Security Alert ===");
                    sc.nextLine();
                    System.out.println("Enter Security Alert:");
                    String alert = sc.nextLine();

                    alertStack.push(alert);
                    System.out.println("Alert Added Successfully!");
                    break;
                case 5:
                    System.out.println("=== Remove Security Alert ===");
                    if(alertStack.isEmpty()){
                        System.out.println("You cannot Remove Alert from Stack because Stack is Empty!");

                    } else {
                        String removedAlert = alertStack.pop();
                        System.out.println("Removed Alert: \n " + removedAlert);
                    }
                    break;
                case 6:
                    System.out.println("=== View Security Alert ===");
                    if(alertStack.isEmpty()) {
                        System.out.println("You cannot View Alert from Stack because Stack is Empty!");
                    } else {
                        System.out.println("Latest Alert = " + alertStack.peek());
                    }
                    break;
                case 7:
                    System.out.println("==============================");
                    System.out.println("=== Display Trays & Alerts ===");
                    System.out.println("==============================");

                    if (trayStack.isEmpty()){
                        System.out.println("No Tray is Available!");
                    } else {
                        System.out.println("All Trays:");
                        for (Tray tray : trayStack){
                            System.out.println(tray);
                        }
                    }
                    if (alertStack.isEmpty()){
                        System.out.println("No Alert is Available!");
                    } else {
                        System.out.println("All Alerts:");
                        for (String al :alertStack){
                            System.out.println(al);

                        }
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    System.out.println("Enter only from 1-8!");

            }
        } while(choice != 8);


    }

}