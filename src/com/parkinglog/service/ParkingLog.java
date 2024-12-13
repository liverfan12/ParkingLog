package com.parkinglog.service;
import com.parkinglog.model.CarModel;

import java.io.*;
import java.util.ArrayList;


public class ParkingLog  implements Serializable {

    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
    private ArrayList<CarModel> parking = new ArrayList<>();
    private ParkingLog instance;

    public ParkingLog() {

        this.parking = new ArrayList<>();
    }


    public void park(String make, String numberPlate) {
        CarModel car = new CarModel(make, numberPlate);
        parking.add(car);
    }

    public boolean unpark(String numberPlate) {
        for (CarModel c : parking) {
            if (c.getNumberPlate().equalsIgnoreCase(numberPlate)) {
                parking.remove(c);
                return true;
            }
        }
        return false;
    }

    public ArrayList<CarModel> getList() {
        return parking;
    }
}
