package model;

import java.util.*;

public class user {
    public String name, dob, location, occupation;
    public int age;

    public List<user> friends = new ArrayList<>();
    public List<user> requests = new ArrayList<>();
    public List<post> posts = new ArrayList<>();
    public List<String> notifications = new ArrayList<>();

    public user(String name, int age, String dob, String location, String occupation) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.location = location;
        this.occupation = occupation;
    }
}