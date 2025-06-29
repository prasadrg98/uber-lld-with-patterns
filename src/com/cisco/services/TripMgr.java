package com.cisco.services;

import java.util.concurrent.ConcurrentHashMap;

import com.cisco.beans.Trip;

public class TripMgr {
    private static final TripMgr instance = new TripMgr();
    private ConcurrentHashMap<String, Trip> trips = new ConcurrentHashMap<>();

    private TripMgr() {}
    public static TripMgr getInstance() {
        return instance;
    }

    public void addTrip(Trip trip) {
        if (trip != null && trip.getTripId() != null) {
            trips.put(trip.getTripId(), trip);
        }
    }

    public Trip getTrip(String id) {
        return trips.get(id);
    }

    
}
