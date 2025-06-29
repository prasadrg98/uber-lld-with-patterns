package com.cisco.beans;

import com.cisco.enums.Rating;

public class Driver extends User {
    private Location location;
    private Rating rating;
    private boolean isAvailable = true;

    public Driver(String name, String email) {
        super(name, email);
    }

    public Driver(String name, String email, Location location, Rating rating) {
        super(name, email);
        this.location = location;
        this.rating = rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +
                ", location=" + location +
                ", rating=" + rating +
                ", isAvailable=" + isAvailable +
                "}";
    }
}
