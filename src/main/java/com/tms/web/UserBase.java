package com.tms.web;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;

public class UserBase implements UserService{

    private static Map<String, User> users = new HashMap<>();

    @Override
    public void saveUser(String name, String pass, String male, String description, String administrator) {

        User registeredUser = users.get(name);
        if (registeredUser != null){
            throw new ErrorAddingUserException("A user with the given name exists");
        }else {
           User newUser = new User(name, pass, male.equals("true"),  description, administrator.equals("true"));
           users.put(name, newUser);
           System.out.println("User registered");
        }
    }

    @Override
    public String userAuthorization(String name, String pass) {

        User userAuthorization = users.get(name);

        if (userAuthorization == null){
            throw new ErrorAddingUserException("User not registered");
        }else {
            if (pass.equals(userAuthorization.getPassword())){
                if (userAuthorization.getAdministrator()){
                    return "Administrator";
                }else {
                    return "User";
                }
            }else {
                return "InvalidPassword";
            }
        }
    }
}
