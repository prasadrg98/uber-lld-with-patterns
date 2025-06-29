package com.cisco.services;

public class Logger {
    private static final Logger instance = new Logger();

    private Logger() {
        // Private constructor to prevent instantiation
    }

    public static Logger getInstance() {
        return instance;
    }

    public static synchronized void log(String message) {
        // In a real application, this would write to a file or logging system
        System.out.println("LOG: " + message);
    }

    public static synchronized void logError(String errorMessage) {
        // In a real application, this would write to an error log
        System.err.println("ERROR: " + errorMessage);
    }

}
