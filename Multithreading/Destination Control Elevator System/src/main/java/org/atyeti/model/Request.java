package org.atyeti.model;

public class Request implements Comparable<Request> {
    private final int sourceFloor;
    private final int destinationFloor;
    private final int priority;

    public Request(int sourceFloor, int destinationFloor) {
        this(sourceFloor, destinationFloor, 1);
    }

    public Request(int sourceFloor, int destinationFloor, int priority) {
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
        this.priority = priority;
    }

    public int getSourceFloor() { return sourceFloor; }
    public int getDestinationFloor() { return destinationFloor; }
    public int getPriority() { return priority; }

    @Override
    public int compareTo(Request other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "Request{src=" + sourceFloor +
                ", dest=" + destinationFloor +
                ", priority=" + priority + "}";
    }
}