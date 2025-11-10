package org.atyeti.controller;

import org.atyeti.model.Elevator;
import org.atyeti.model.Request;

import java.util.Comparator;
import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;
    private static final char[] NAMES = {'A','B','C','D','E','F','G','H'};

    public ElevatorController(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public synchronized void handleUserRequest(int src, int dest) {

        Request req = new Request(src, dest);

        Elevator best = elevators.stream()
                .min(Comparator.comparingInt(e ->
                        Math.abs(e.getCurrentFloor() - src) + e.getQueueSize()))
                .orElse(elevators.get(0));

        int distance = Math.abs(best.getCurrentFloor() - src);
        long waitMs  = distance * 400L;
        char name    = NAMES[best.getId() - 1];

        if (distance > 14) {
            System.out.println("⚠️  All nearby elevators are too far (>14 floors).");
        } else {
            System.out.printf("✅ Please wait for Elevator %c | current floor %d | distance %d floors | est %.2f sec%n",
                    name, best.getCurrentFloor(), distance, waitMs / 1000.0);
        }

        best.addRequest(req);
    }

    // for RequestDispatcher
    public void assignRequest(Request req) {
        handleUserRequest(req.getSourceFloor(), req.getDestinationFloor());
    }
}