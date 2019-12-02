package com.example.labor8planningpokeruser;

public class Groups {
    private String key ;
    private String admin;

    public Groups() {

    }

    public Groups(String key, String admin) {
        this.key = key;
        this.admin = admin;
    }

    public String getKey() {
        return key;
    }

    public String getAdmin() {
        return admin;
    }
}