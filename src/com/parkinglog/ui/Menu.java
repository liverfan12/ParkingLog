package com.parkinglog.ui;

import com.parkinglog.model.CarModel;
import com.parkinglog.service.ParkingLog;
import com.parkinglog.service.Utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu  {
    private final ParkingLog parkingLog;
    private final Utils utils;

    public Menu(ParkingLog parkingLog, Utils utils) {
        this.parkingLog = parkingLog;
        this.utils = utils;
    }

    public void startProgram() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the parking log, please choose one of the following options");
        System.out.println("1. Park the car");
        System.out.println("2. Leave the parking log");
        System.out.println("3. Observe parked cars");
        System.out.println("4. Exit");
        boolean exit = false;

        while (!exit) {
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter the car make: ");
                    String make = sc.nextLine();

                    System.out.println("Enter the car number plate /format: AA1111AA/: ");
                    String numberPlate = sc.nextLine();
                    boolean correctNumberPlate = Pattern.compile("^[A-Za-z]{2}\\d{4}[A-Za-z]{2}$").matcher(numberPlate).matches();

                    if(!correctNumberPlate){
                        System.out.println("Invalid number plate. Please try again!");
                    }
                    else if(isParked(numberPlate)){
                        System.out.println("This car is already parked!");
                    } else{
                        parkingLog.park(make, numberPlate);
                        System.out.println("You have parked successfully!");
                    }

                    break;

                case "2":
                    System.out.println("Enter the number plate of the car you want to unpark: ");
                    String numberPlateToRemove = sc.nextLine();

                    if (parkingLog.unpark(numberPlateToRemove)) {
                        System.out.println("Bye, see you again next time!");
                    } else {
                        System.out.println("There is no car with this numberplate.");
                    }
                    break;
                case "3":
                    for (CarModel c : parkingLog.getList()) {
                        System.out.println(c);
                    }
                    break;
                case "4":
                    System.out.println("Saving and exiting...");
                    utils.saveToFile(parkingLog);
                    exit = true;
                    break;
                default:
                    System.out.println("This is not a valid option!");
            }
            if (!exit) {
                System.out.println("---------------------------------------------------");
                System.out.println("1. Park the car");
                System.out.println("2. Leave the parking log");
                System.out.println("3. Observe parked cars");
                System.out.println("4. Exit");
            }

        }
    }

    public boolean isParked(String numberPlate){
        for (CarModel c : parkingLog.getList()) {
            if(c.getNumberPlate().equalsIgnoreCase(numberPlate)){
                return true;
            }
        }
        return false;
    }
}



