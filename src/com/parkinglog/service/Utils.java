package com.parkinglog.service;

import java.io.*;

public class Utils {
    private final String fileName;

    public Utils(String fileName) {
        this.fileName = fileName;
    }

    public ParkingLog loadFromFile() {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ParkingLog();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ParkingLog) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading com.parkinglog.service.ParkingLog: " + e.getMessage());
            return new ParkingLog();
        }
    }

    public void saveToFile(ParkingLog parkingLog) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(parkingLog);
            System.out.println("ParkingLog saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving ParkingLog: " + e.getMessage());
        }
    }
}
