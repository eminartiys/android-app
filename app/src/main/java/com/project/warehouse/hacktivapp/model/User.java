package com.project.warehouse.hacktivapp.model;

/**
 * Created by eminartiys on 22/02/22.
 */

public class User {

    private int id;
    private String username;
    private String name;
    private String phoneNumber;
    private String password;
    private String role;

    public User() {
    }

    public User(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public User(int id, String username, String name, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public User(String username, String name, String phoneNumber, String password) {
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User(String username, String name, String phoneNumber, String password, String role) {
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
