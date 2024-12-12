import java.io.Serializable;

public class CarModel implements Serializable {
    private String make;
    private String numberPlate;

    public CarModel(String make, String numberPlate) {
        this.make = make;
        this.numberPlate = numberPlate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getMake() {
        return make;
    }

    @Override
    public String toString() {
        return "Car Make: " + make + ", Number Plate: " + numberPlate;
    }

}
