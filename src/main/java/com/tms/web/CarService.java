package com.tms.web;

public interface CarService {

    void addCar(String id, String name);
    void editСar(String id, String name);
    void delСar(String id);
    String getCar(String id);

}
