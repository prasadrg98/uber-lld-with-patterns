package com.cisco.services;

import java.util.concurrent.ConcurrentHashMap;

import com.cisco.beans.Rider;

public class RiderMgr {
    private static final RiderMgr instance = new RiderMgr();
    private ConcurrentHashMap<String, Rider> riders = new ConcurrentHashMap<>();
    private RiderMgr() {}

    public static RiderMgr getInstance() {
        return instance;
    }

    public void addRider(Rider rider) {
        if (rider != null && rider.getEmail() != null) {
            riders.put(rider.getEmail(), rider);
        }
    }

    public Rider getRider(String email) {
        return riders.get(email);
    }
    
}
