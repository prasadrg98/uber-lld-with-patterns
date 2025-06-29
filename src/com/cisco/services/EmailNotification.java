package com.cisco.services;

public class EmailNotification implements NotificationObserver {

    @Override
    public void notify(String message) {
        System.out.println("Sending email notification: " + message);
    }
    
}
