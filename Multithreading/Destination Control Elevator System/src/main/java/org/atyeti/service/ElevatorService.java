package org.atyeti.service;

import org.atyeti.model.Elevator;
import org.atyeti.model.Request;
import org.atyeti.model.ElevatorState;

public class ElevatorService implements Runnable {
    private final Elevator elevator;

    public ElevatorService(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        System.out.println("Elevator " + elevator.getId() + " started...");

        while (!Thread.currentThread().isInterrupted()) {
            try {
                Request req = elevator.getRequests().take();
                processRequest(req);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Elevator " + elevator.getId() + " shutting down...");
                break;
            }
        }
    }

    public void processRequest(Request req) throws InterruptedException {
        moveTo(req.getSourceFloor());
        moveTo(req.getDestinationFloor());
    }

    private void moveTo(int floor) throws InterruptedException {
        if (floor > elevator.getCurrentFloor())
            elevator.setState(ElevatorState.MOVING_UP);
        else if (floor < elevator.getCurrentFloor())
            elevator.setState(ElevatorState.MOVING_DOWN);
        else
            elevator.setState(ElevatorState.IDLE);

        Thread.sleep(Math.abs(floor - elevator.getCurrentFloor()) * 400L);

        elevator.setCurrentFloor(floor);
        elevator.setState(ElevatorState.IDLE);
    }
}