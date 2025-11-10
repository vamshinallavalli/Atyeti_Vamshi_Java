package org.atyeti.model;

import java.util.concurrent.PriorityBlockingQueue;

public class Elevator implements Runnable {
    private final int id;
    private int currentFloor = 0;
    private ElevatorState state = ElevatorState.IDLE;
    private final PriorityBlockingQueue<Request> requests = new PriorityBlockingQueue<>();

    public Elevator(int id) {
        this.id = id;
    }

    public void addRequest(Request request) {
        requests.offer(request);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Request req = requests.take();
                moveTo(req.getSourceFloor());
                moveTo(req.getDestinationFloor());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void moveTo(int floor) throws InterruptedException {
        if (floor > currentFloor) state = ElevatorState.MOVING_UP;
        else if (floor < currentFloor) state = ElevatorState.MOVING_DOWN;
        else state = ElevatorState.IDLE;

        System.out.println(" Elevator " + getLiftLetter() +
                " moving from " + currentFloor + " to " + floor);

        Thread.sleep(Math.abs(floor - currentFloor) * 400L);
        currentFloor = floor;

        System.out.println("🏁 Elevator " + getLiftLetter() + " reached floor " + floor);
        state = ElevatorState.IDLE;
    }

    private char getLiftLetter() {
        return (char) ('A' + id - 1);
    }

    public int getCurrentFloor() { return currentFloor; }
    public ElevatorState getState() { return state; }
    public int getId() { return id; }
    public int getQueueSize() { return requests.size(); }
    public PriorityBlockingQueue<Request> getRequests() { return requests; }

    public void setCurrentFloor(int floor) { this.currentFloor = floor; }
    public void setState(ElevatorState s) { this.state = s; }
}