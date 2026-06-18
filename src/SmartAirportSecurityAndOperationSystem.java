import java.util.*;

// ==========================
// TRAY CLASS (STACK MODULE)
// ==========================
class Tray {
    int trayID;
    String passengerName;

    Tray(int trayID, String passengerName) {
        this.trayID = trayID;
        this.passengerName = passengerName;
    }

    public String toString() {
        return "Tray ID: " + trayID + ", Passenger Name: " + passengerName;
    }
}

// ==============================
// PASSENGER CLASS (QUEUE MODULE)
// ==============================
class Passenger {
    int id;
    String name;
    String flightNo;

    Passenger(int id, String name, String flightNo) {
        this.id = id;
        this.name = name;
        this.flightNo = flightNo;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Flight: " + flightNo;
    }
}

// ==========================
// FLIGHT CLASS (BST MODULE)
// ==========================
class Flight {
    String flightNo;
    String destination;
    int seats;

    Flight(String flightNo, String destination, int seats) {
        this.flightNo = flightNo;
        this.destination = destination;
        this.seats = seats;
    }

    public String toString() {
        return "Flight No: " + flightNo +
                ", Destination: " + destination +
                ", Seats: " + seats;
    }
}

// ==============
// BST NODE CLASS
// ==============
class Node {
    Flight data;
    Node left;
    Node right;

    Node(Flight data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// ================
// FLIGHT BST CLASS
// ================
class FlightBST {
    Node root;
    boolean insert(Flight f) {

        if (search(f.flightNo) != null) {
            return false;
        }

        root = insertRec(root, f);
        return true;
    }
    Node insertRec(Node root, Flight f) {
        if (root == null) {
            return new Node(f);
        }

        if (f.flightNo.compareToIgnoreCase(root.data.flightNo) < 0) {
            root.left = insertRec(root.left, f);
        } else if (f.flightNo.compareToIgnoreCase(root.data.flightNo) > 0) {
            root.right = insertRec(root.right, f);
        } else {
            System.out.println("Flight Number Already Exists");
        }

        return root;
    }

    Flight search(String flightNo) {
        Node temp = root;

        while (temp != null) {
            if (temp.data.flightNo.equalsIgnoreCase(flightNo)) {
                return temp.data;
            }

            if (flightNo.compareToIgnoreCase(temp.data.flightNo) < 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        return null;
    }


    boolean deleteFlight(String flightNo) {
        Flight found = search(flightNo);

        if (found == null) {
            return false;
        }

        root = deleteRec(root, flightNo);
        return true;
    }


    void delete(String flightNo) {
        root = deleteRec(root, flightNo);
    }

    Node deleteRec(Node root, String key) {
        if (root == null) {
            return null;
        }

        if (key.compareToIgnoreCase(root.data.flightNo) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareToIgnoreCase(root.data.flightNo) > 0) {
            root.right = deleteRec(root.right, key);
        } else {

            // CASE 1: No left child
            if (root.left == null) {
                return root.right;
            }
            // CASE 2: No right child
            if (root.right == null) {
                return root.left;
            }
            // CASE 3: Two children
            Node minNode = findMinNode(root.right);
            root.data = minNode.data;
            root.right = deleteRec(root.right, minNode.data.flightNo);
        }

        return root;
    }

    Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    Flight findMin() {
        if (root == null) return null;
        return findMinNode(root).data;
    }


    Flight findMax() {
        if (root == null) return null;

        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }

        return temp.data;
    }

    // INORDER TRAVERSAL
    void inorder() {

        if (root == null) {
            System.out.println("No Flights Available");
            return;
        }

        System.out.println("\nFlights List: (Inorder Traversal):");
        inorderRec(root);
    }

    void inorderRec(Node root) {

        if (root == null) {
            return;
        }

        inorderRec(root.left);
        System.out.println(root.data);
        inorderRec(root.right);
    }
}

// ==========================
// PASSENGER RECORD (HASHMAP)
// ==========================
class PassengerRecord {
    String passportNo;
    String name;
    String nationality;

    PassengerRecord(String passportNo, String name, String nationality) {
        this.passportNo = passportNo;
        this.name = name;
        this.nationality = nationality;
    }

    public String toString() {
        return "Passport: " + passportNo +
                ", Name: " + name +
                ", Nationality: " + nationality;
    }
}

// ==========
// MAIN CLASS
// ==========
public class SmartAirportSecurityAndOperationSystem {

    static Scanner sc = new Scanner(System.in);

    // DATA STRUCTURES USED
    static Stack<Tray> trayStack = new Stack<>();
    static Queue<Passenger> passengerQueue = new LinkedList<>();
    static Queue<Passenger> vipQueue = new LinkedList<>();
    static HashMap<String, PassengerRecord> records = new HashMap<>();
    static FlightBST bst = new FlightBST();

    // ===========
    // MAIN METHOD
    // ===========
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println(" SMART AIRPORT SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Tray Management");
            System.out.println("2. Passenger Management");
            System.out.println("3. Flight Management");
            System.out.println("4. Records Management");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();


            switch (choice) {

                case 1:
                    stackModule();
                    break;

                case 2:
                    queueModule();
                    break;

                case 3:
                    bstModule();
                    break;

                case 4:
                    hashMapModule();
                    break;

                case 5:
                    System.out.println("Program Ended");
                    System.out.println("Thank you for using 'Smart Airport & Security Operation System'!");
                    break;

                default:
                    System.out.println("Invalid Choice! Enter only from (1-5)");
            }

        } while (choice != 5);
    }

    // ============
    // STACK MODULE
    // ============
    static void stackModule() {

        int choice;

        do {
            System.out.println("\n--- STACK MODULE ---");
            System.out.println("1. Add Tray");
            System.out.println("2. Remove Tray");
            System.out.println("3. View Top Tray");
            System.out.println("4. Display Trays ");
            System.out.println("5. Search Tray");
            System.out.println("6. Back to Main Menu");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addTray();
                    break;

                case 2:
                    removeTray();
                    break;

                case 3:
                    viewTop();
                    break;

                case 4:
                    displayTrays(0);
                    break;

                case 5:
                    searchTray();
                    break;
                case 6:
                    System.out.println("Backing to Main Menu!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }

    // ADD TRAY
    static void addTray() {
        System.out.print("Enter Tray ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();

        trayStack.push(new Tray(id, name));

        System.out.println("Tray Added Successfully");
    }

    // REMOVE TRAY
    static void removeTray() {
        if (trayStack.isEmpty()) {
            System.out.println("No Tray can be removed because Stack of Tray is Empty");
            return;
        }

        System.out.println("Removed Tray: " + trayStack.pop());
    }

    // VIEW TOP TRAY
    static void viewTop() {
        if (trayStack.isEmpty()) {
            System.out.println("No Tray is available");
        } else {
            System.out.println(trayStack.peek());
        }
    }

    //  DISPLAY
    static void displayTrays(int index) {

        if (trayStack.isEmpty()) {
            System.out.println("No Tray available to display!");
            return;
        }

        if (index >= trayStack.size()) {
            return;
        }

        System.out.println(trayStack.get(index));
        displayTrays(index + 1);
    }

    // SEARCH TRAY
    static void searchTray() {

        System.out.print("Enter Tray ID: ");
        int id = sc.nextInt();

        for (Tray t : trayStack) {
            if (t.trayID == id) {
                System.out.println(t);
                return;
            }
        }

        System.out.println("Tray Not Found");
    }

    // ============
    // QUEUE MODULE
    // ============
    static void queueModule() {

        int choice;

        do {
            System.out.println("\n--- QUEUE MODULE ---");
            System.out.println("1. Add Normal Passenger");
            System.out.println("2. Add VIP Passenger");
            System.out.println("3. Process Passenger");
            System.out.println("4. Display Passengers");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPassenger(passengerQueue);
                    break;

                case 2:
                    addPassenger(vipQueue);
                    break;

                case 3:
                    processPassenger();
                    break;

                case 4:
                    displayPassengers();
                    break;
                case 5:
                    System.out.println("Backing to Main Menu!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }

    static void addPassenger(Queue<Passenger> q) {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Flight No: ");
        String flight = sc.nextLine();



        Flight flightExists = bst.search(flight);

        if (flightExists == null) {
            System.out.println("Flight does not exist. Passenger cannot be added.");
            return;
        }

        q.offer(new Passenger(id, name, flight));
        System.out.println("Passenger Added Successfully!");
    }

    static void processPassenger() {

        if (!vipQueue.isEmpty()) {
            System.out.println("VIP Processed: " + vipQueue.poll());
        }
        else if (!passengerQueue.isEmpty()) {
            System.out.println("Normal Processed: " + passengerQueue.poll());
        }
        else {
            System.out.println("No Passengers are waiting in the Queue");
        }
    }


    static void displayPassengers() {

        System.out.println("\nVIP Queue:");

        if (vipQueue.isEmpty()) {
            System.out.println("No VIP Passengers");
        } else {
            displayQueue(new ArrayList<>(vipQueue), 0);
        }

        System.out.println("\nNormal Queue:");

        if (passengerQueue.isEmpty()) {
            System.out.println("No Normal Passengers");
        } else {
            displayQueue(new ArrayList<>(passengerQueue), 0);
        }
    }

    // DISPLAY
    static void displayQueue(List<Passenger> list, int i) {

        if (list == null || list.isEmpty()) {
            return;
        }

        if (i >= list.size()) {
            return;
        }

        System.out.println(list.get(i));
        displayQueue(list, i + 1);
    }

    // ==========
    // BST MODULE
    // ==========
    static void bstModule() {

        int choice;

        do {
            System.out.println("\n--- BST MODULE ---");
            System.out.println("1. Insert Flight");
            System.out.println("2. Search Flight");
            System.out.println("3. Delete Flight");
            System.out.println("4. Min Flight");
            System.out.println("5. Max Flight");
            System.out.println("6. Display Flights");
            System.out.println("7. Back to Main Menu");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insertFlight();
                    break;

                case 2:
                    searchFlight();
                    break;

                case 3:
                    deleteFlight();
                    break;

                case 4:

                    Flight minFlight = bst.findMin();

                    if (minFlight != null) {
                        System.out.println(minFlight);
                    } else {
                        System.out.println("No Flights Available");
                    }
                    break;

                case 5:

                    Flight maxFlight = bst.findMax();

                    if (maxFlight != null) {
                        System.out.println(maxFlight);
                    } else {
                        System.out.println("No Flights Available");
                    }
                    break;

                case 6:
                    bst.inorder();
                    break;
                case 7:
                    System.out.println("Backing to Main Menu!");
                    break;
                default:
                    System.out.println("Invalid Choice!");

            }

        } while (choice != 7);
    }

    static void insertFlight() {

        System.out.print("Flight No: ");
        String no = sc.next();

        System.out.print("Destination: ");
        String d = sc.next();

        System.out.print("Seats: ");
        int s = sc.nextInt();

        if (bst.insert(new Flight(no, d, s))) {
            System.out.println("Flight Inserted Successfully");
        } else {
            System.out.println("Flight Number Already Exists");
        }
    }


    static void searchFlight() {
        System.out.print("Enter Flight No: ");
        String flightNo = sc.next();

        Flight found = bst.search(flightNo);

        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Flight Not Found");
        }
    }


    static void deleteFlight() {
        System.out.print("Enter Flight No: ");
        String flightNo = sc.next();

        boolean deleted = bst.deleteFlight(flightNo);

        if (deleted) {
            System.out.println("Flight Deleted Successfully");
        } else {
            System.out.println("Flight Not Found");
        }
    }

    // ==============
    // HASHMAP MODULE
    // ==============
    static void hashMapModule() {

        int choice;

        do {
            System.out.println("\n--- HASHMAP MODULE ---");
            System.out.println("1. Add Record");
            System.out.println("2. Search Record");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Display Records");
            System.out.println("6. Back to Main Menu");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addRecord();
                    break;

                case 2:
                    searchRecord();
                    break;

                case 3:
                    updateRecord();
                    break;

                case 4:
                    deleteRecord();
                    break;

                case 5:
                    displayRecords();
                    break;
                case 6:
                    System.out.println("Backing to Main Menu!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }

    static void addRecord() {

        System.out.print("Enter Passport No: ");
        String p = sc.next();

        if (records.containsKey(p)) {
            System.out.println("Passport Number Already Exists");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Name: ");
        String n = sc.nextLine();

        System.out.print("What is your Nationality: ");
        String nat = sc.nextLine();

        records.put(p, new PassengerRecord(p, n, nat));
        System.out.println("Record Added Successfully");
    }


    static void searchRecord() {

        System.out.print("Enter Passport No: ");

        String passportNo = sc.next();

        PassengerRecord record = records.get(passportNo);

        if (record != null) {
            System.out.println(record);
        } else {
            System.out.println("Record Not Found");
        }
    }

    static void updateRecord() {

        System.out.print("Enter Passport No: ");
        String p = sc.next();

        if (!records.containsKey(p)) {
            System.out.println("Record Not Found");
            return;
        }

        sc.nextLine();

        System.out.print("Enter New Name: ");
        String n = sc.nextLine();

        System.out.print("Enter New Nationality: ");
        String nat = sc.nextLine();

        records.put(p, new PassengerRecord(p, n, nat));
        System.out.println("Record Updated Successfully");
    }

    static void deleteRecord() {

        System.out.print("Enter Passport No: ");

        String p = sc.next();

        if (records.remove(p) != null) {
            System.out.println("Record Deleted Successfully");
        } else {
            System.out.println("Record Not Found");
        }
    }

    static void displayRecords() {

        if (records.isEmpty()) {
            System.out.println("No Records");
            return;
        }

        for (PassengerRecord r : records.values()) {
            System.out.println(r);
        }
    }
}
