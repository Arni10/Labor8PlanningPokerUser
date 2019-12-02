package com.example.labor8planningpokeruser;

public class Questions {
    private String name;
    private String groupKey;
    private boolean available;

    public Questions() {

    }

    public Questions(String name, String groupKey, boolean available) {
        this.name = name;
        this.groupKey = groupKey;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
