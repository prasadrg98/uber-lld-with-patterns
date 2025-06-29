package com.cisco.beans;

import com.cisco.enums.Rating;

public class Rider extends User {
    private Location location;
    private Rating rating;

    public Rider(String name, String email) {
        super(name, email);
    }

    public Rider(String name, String email, Location location, Rating rating) {
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
    
}
