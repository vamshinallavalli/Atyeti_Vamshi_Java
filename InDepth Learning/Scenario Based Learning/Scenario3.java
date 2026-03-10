import java.util.Scanner;

/*
 Java Scenario 3: Traffic Light Action - Switch.
Given the current lightColor (RED, YELLOW, GREEN), determine the action:
 RED > “Stop”
 YELLOW > if pedestrianWaiting == true, print “Stop, pedestrian crossing”; else “Slow down”.
 GREEN > if emergencyVehicle == true, print “Give way to emergency vehicle”; else “Go”.
Hint: Use switch for light color, if-else inside each case for conditions.
 */

public class Scenario3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nChoose light color:");
            System.out.println("1. RED");
            System.out.println("2. YELLOW");
            System.out.println("3. GREEN");
            System.out.println("4. EXIT");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Stop");
                    break;

                case 2:
                    System.out.println("Is Pedestrian Waiting? (yes/no)");
                    String cross1 = sc.next();

                    boolean pedestrianWaiting = cross1.equalsIgnoreCase("yes");

                    if (pedestrianWaiting) {
                        System.out.println("Stop, pedestrian crossing");
                    } else {
                        System.out.println("Slow down");
                    }
                    break;

                case 3:
                    System.out.println("Is any ambulance or emergency vehicle there? (yes/no)");
                    String cross2 = sc.next();

                    boolean emergencyVehicle = cross2.equalsIgnoreCase("yes");

                    if (emergencyVehicle) {
                        System.out.println("Give way to emergency vehicle");
                    } else {
                        System.out.println("Go");
                    }
                    break;

                case 4:
                    System.out.println("Program exited.");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}