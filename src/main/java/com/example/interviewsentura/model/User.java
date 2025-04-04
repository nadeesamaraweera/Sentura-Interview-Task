package com.weavy.model;

public class User {
    private String id;
    private String uid;
    private String name;

    // Constructors
    public User() {}

    public User(String id, String uid, String name) {
        this.id = id;
        this.uid = uid;
        this.name = name;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
