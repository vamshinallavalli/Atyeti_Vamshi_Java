package Scenario_3;

import java.util.Scanner;

/*
 Traffic Light Action - Switch.
 Given the current lightColor (RED, YELLOW, GREEN), determine the action:
 RED    -> "Stop"
 YELLOW -> if pedestrianWaiting == true, print "Stop, pedestrian crossing"
           else "Slow down"
 GREEN  -> if emergencyVehicle == true, print "Give way to emergency vehicle"
           else "Go"
 Hint: Use switch for light color and if-else inside each case.
*/

public class TrafficLightOption {

    public static void main(String[] args) {
        boolean pedestrianWaiting = true;
        boolean emergencyVehicle = false;

        Scanner sc = new Scanner(System.in);

            System.out.println("\nEnter Traffic Light Color (RED / YELLOW / GREEN): ");
            String color = sc.next().toUpperCase();   // handles red, Red, RED

            switch (color) {

                case "RED":
                    System.out.println("Stop");
                    break;

                case "YELLOW":
                    if (pedestrianWaiting) {
                        System.out.println("Stop, pedestrian crossing");
                    } else {
                        System.out.println("Slow down");
                    }
                    break;

                case "GREEN":
                    if (emergencyVehicle) {
                        System.out.println("Give way to emergency vehicle");
                    } else {
                        System.out.println("Go");
                    }
                    break;

                default:
                    System.out.println("Invalid traffic light color!");

        }

        sc.close();
    }
}
