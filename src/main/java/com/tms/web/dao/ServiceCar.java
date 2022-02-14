package com.tms.web.dao;

import com.tms.web.entity.Car2;
import java.util.List;

public interface ServiceCar {
    void addCar(String nom, String model);
    void editСar(String id);
    void delСar(String id);
    List<Car2> getCar(String nom);
}
