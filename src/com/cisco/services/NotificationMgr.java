package com.cisco.services;

import java.util.ArrayList;
import java.util.List;

public class NotificationMgr {
    private static final NotificationMgr instance = new NotificationMgr();
    private final List<NotificationObserver> observers = new ArrayList<>();

    private NotificationMgr() {}
    public static NotificationMgr getInstance() {
        return instance;
    }

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (NotificationObserver observer : observers) {
            observer.notify(message);
        }
    }
}
