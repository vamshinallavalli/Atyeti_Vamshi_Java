package org.atyeti;

import org.atyeti.controller.ElevatorController;
import org.atyeti.model.Elevator;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        int numElevators = 6;   // Elevators A B C D E F
        int maxFloors    = 20;

        List<Elevator> elevators = new ArrayList<>();
        ExecutorService executor  = Executors.newFixedThreadPool(numElevators);

        for (int i = 1; i <= numElevators; i++) {
            Elevator e = new Elevator(i);
            elevators.add(e);
            executor.submit(e);
        }

        ElevatorController controller = new ElevatorController(elevators);
        Scanner sc = new Scanner(System.in);

        System.out.println(" Destination-Control Elevator System\n");

        while (true) {
            System.out.print("Enter your floor (-1 = exit): ");
            int src = sc.nextInt();
            if (src == -1) break;

            System.out.print("Enter destination floor: ");
            int dest = sc.nextInt();

            if (src == dest || src < 0 || dest < 0 || src > maxFloors || dest > maxFloors) {
                System.out.println(" Invalid floors, try again.");
                continue;
            }

            controller.handleUserRequest(src, dest);
        }

        executor.shutdownNow();
        System.out.println("System shutting down…");
    }
}