package com.cisco.beans;

import com.cisco.enums.TripStatus;

public class Trip {
    private static int tripCounter = 0; // Static counter for unique trip IDs
    private final String tripId;
    private final User rider;
    private final Driver driver;
    private final Location startLocation;
    private final Location endLocation;
    private double fare;
    private final TripStatus status;

    public Trip(TripBuilder builder) {
        this.tripId = "TRIP_" + (++tripCounter); // Generate a unique trip ID
        this.rider = builder.rider;
        this.driver = builder.driver;
        this.startLocation = builder.startLocation;
        this.endLocation = builder.endLocation;
        this.fare = builder.fare;
        this.status = builder.status;
    }

    public String getTripId() {
        return tripId;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId='" + tripId + '\'' +
                ", rider=" + rider +
                ", driver=" + driver +
                ", startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                ", fare=" + fare +
                ", status=" + status +
                '}';
    }

    public static class TripBuilder {
        private User rider;
        private Driver driver;
        private Location startLocation;
        private Location endLocation;
        private double fare;
        private TripStatus status = TripStatus.REQUESTED; // Default status

        public TripBuilder setRider(User rider) {
            this.rider = rider;
            return this;
        }

        public TripBuilder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public TripBuilder setStartLocation(Location startLocation) {
            this.startLocation = startLocation;
            return this;
        }

        public TripBuilder setEndLocation(Location endLocation) {
            this.endLocation = endLocation;
            return this;
        }

        public TripBuilder setFare(double fare) {
            this.fare = fare;
            return this;
        }

        public TripBuilder setStatus(TripStatus status) {
            this.status = status;
            return this;
        }

        public Trip build() {
            return new Trip(this);
        }
    }
    
}
