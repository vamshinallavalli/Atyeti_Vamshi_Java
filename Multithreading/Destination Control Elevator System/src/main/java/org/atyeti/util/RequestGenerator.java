package org.atyeti.util;

import org.atyeti.model.Request;
import org.atyeti.service.RequestDispatcher;

import java.util.Random;

public class RequestGenerator implements Runnable {
    private final RequestDispatcher dispatcher;
    private final int maxFloors;
    private final Random random = new Random();

    public RequestGenerator(RequestDispatcher dispatcher, int maxFloors) {
        this.dispatcher = dispatcher;
        this.maxFloors = maxFloors;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int src = random.nextInt(maxFloors);
                int dest = random.nextInt(maxFloors);

                while (dest == src)
                    dest = random.nextInt(maxFloors);

                int priority = random.nextInt(3) + 1;

                Request req = new Request(src, dest, priority);
                dispatcher.dispatch(req);

                Thread.sleep(2000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}