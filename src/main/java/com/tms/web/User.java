package com.tms.web;

import java.lang.String;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private String name;
    private String password;
    private boolean male;
    private String description;
    private boolean administrator;

    public User(String name, String password, Boolean male, String description, Boolean administrator) {
        this.name = name;
        this.password = password;
        this.male = male;
        this.description = description;
        this.administrator = administrator;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(male, user.male) && Objects.equals(description, user.description) && Objects.equals(administrator, user.administrator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, male, description, administrator);
    }

    @Override
    public java.lang.String toString() {
        return "User{" +
                "name=" + name +
                ", password=" + password +
                ", male=" + male +
                ", description=" + description +
                ", administrator=" + administrator +
                '}';
    }
}
