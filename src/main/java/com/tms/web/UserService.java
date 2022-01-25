package com.tms.web;

import  java.lang.String;

public interface UserService {

    void saveUser(String name, String pass, String male, String description, String administrator);
    String userAuthorization(String name, String pass);
}
