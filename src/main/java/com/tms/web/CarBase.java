package com.tms.web;

import java.util.HashMap;
import java.util.Map;

public class CarBase implements CarService{

    private static Map<String, Car> cars = new HashMap<>();

    @Override
    public void addCar(String id, String name) {

        Car car = new Car(name);
        cars.put(id, car);

    }

    @Override
    public void editСar(String id, String name) {

        cars.get(id).setName(name);

    }

    @Override
    public void delСar(String id) {

        cars.remove(id);

    }

    @Override
    public String getCar(String id) {

        if (id.isBlank()){
            return cars.toString();
        }else{
            return cars.get(id).toString();
        }

    }
}
