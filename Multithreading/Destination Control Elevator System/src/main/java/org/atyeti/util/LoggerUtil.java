package org.atyeti.util;

import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {
    private static final Logger LOGGER = Logger.getLogger("ElevatorSystemLogger");

    static {
        try {
            FileHandler fh = new FileHandler("elevator_system.log", true);
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
            LOGGER.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}