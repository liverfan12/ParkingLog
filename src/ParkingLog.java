import java.io.*;
import java.util.ArrayList;


public class ParkingLog implements Serializable {

    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
    private ArrayList<CarModel> parking;
    private static ParkingLog instance;
    private static final String FILE_NAME = "parking_log.txt";

    public ParkingLog() {
        this.parking = new ArrayList<>();
    }
    public static ParkingLog getInstance(){
        instance = loadFromFile();
        if(instance==null){
            instance = new ParkingLog();
        }
        return instance;
    }
    public void park(CarModel car) {
        parking.add(car);

    }
    public boolean unpark(String numberPlate){
        for (CarModel c : parking){
            if(c.getNumberPlate().equalsIgnoreCase(numberPlate)){
                parking.remove(c);
                return true;
            }
        }
        return false;
    }

    public ArrayList<CarModel> getList() {
        return parking;
    }
    // Save the ParkingLog to a file
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Error saving ParkingLog: " + e.getMessage());
        }
    }

    // Load the ParkingLog from a file
    private static ParkingLog loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ParkingLog) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading ParkingLog: " + e.getMessage());
            return null;
        }
    }
}
