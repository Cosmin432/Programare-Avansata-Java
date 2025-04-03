package org.example;

public class Location {

    private String name;
    private LocationType type;
    public Location(LocationType type, String name) {
        this.type = type;
        this.name = name;
    }
    public boolean isFriendly() {
        return this.type == LocationType.Friendly;
    }
    public String getName() {
        return this.name;
    }

    public LocationType getType() {
        return this.type;
    }
    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}