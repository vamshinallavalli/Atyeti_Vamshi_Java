package org.atyeti.service;

import org.atyeti.controller.ElevatorController;
import org.atyeti.model.Request;
import org.atyeti.util.LoggerUtil;

import java.util.logging.Logger;

public class RequestDispatcher {
    private final ElevatorController controller;
    private static final Logger logger = LoggerUtil.getLogger();

    public RequestDispatcher(ElevatorController controller) {
        this.controller = controller;
    }

    public void dispatch(Request req) {
        System.out.println("Dispatcher: New " + req);
        logger.info("Dispatcher: New " + req);

        controller.assignRequest(req);
    }
}