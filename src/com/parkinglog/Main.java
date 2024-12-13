package com.parkinglog;

import com.parkinglog.service.ParkingLog;
import com.parkinglog.service.Utils;
import com.parkinglog.ui.Menu;

public class Main {
    public static void main(String[] args) {

        Utils utils = new Utils("parking_log.txt");
        ParkingLog parkingLog = utils.loadFromFile();

        Menu menu = new Menu(parkingLog, utils);
        menu.startProgram();
    }
}