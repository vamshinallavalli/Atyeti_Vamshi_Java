package org.atyeti.service;

import org.atyeti.model.Elevator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorManager {
    private final ExecutorService executor;
    private final List<Elevator> elevators;

    public ElevatorManager(List<Elevator> elevators) {
        this.elevators = elevators;
        this.executor = Executors.newFixedThreadPool(elevators.size());
    }

    public void startAll() {
        elevators.forEach(executor::execute);
        System.out.println("All elevators started...");
    }

    public void shutdown() {
        executor.shutdownNow();
        System.out.println("Elevator system shutting down...");
    }

    public List<Elevator> getElevators() {
        return elevators;
    }
}