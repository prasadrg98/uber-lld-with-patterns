package com.cisco;

import com.cisco.beans.Driver;
import com.cisco.beans.Location;
import com.cisco.beans.Rider;
import com.cisco.beans.Trip;
import com.cisco.enums.Rating;
import com.cisco.services.DriverMgr;
import com.cisco.services.EmailNotification;
import com.cisco.services.NotificationMgr;
import com.cisco.services.RiderMgr;
import com.cisco.services.TripFactory;
import com.cisco.services.TripMgr;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Rider rider = new Rider("RG", "rgrg@cisco.com", new Location(10, 20), Rating.FOUR_STAR);
        Driver driver1 = new Driver("RG_driver", "rgrg_driver@cisco.com", new Location(10, 20), Rating.FOUR_STAR);
        Driver driver2 = new Driver("RG_driver2", "rgrg_driver2@cisco.com", new Location(10, 20), Rating.FOUR_STAR);

        RiderMgr.getInstance().addRider(rider);
        DriverMgr.getInstance().addDriver(driver1);
        DriverMgr.getInstance().addDriver(driver2);

        NotificationMgr.getInstance().addObserver(new EmailNotification());
        Trip trip = new TripFactory().createTrip(rider, rider.getLocation(), new Location(11, 12));
        if (trip != null) {
            TripMgr.getInstance().addTrip(trip);
            System.out.println("Trip created successfully: " + trip.getTripId());
        } else {
            System.out.println("Failed to create trip.");
        }

    }
}
