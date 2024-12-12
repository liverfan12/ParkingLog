import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParkingLog parking = ParkingLog.getInstance();

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
                    System.out.println("Enter the car number plate: ");
                    String numberPlate = sc.nextLine();
                    CarModel car = new CarModel(make, numberPlate);
                    parking.park(car);
                    System.out.println("You have parked successfully!");
                    break;
                case "2":
                    System.out.println("Enter the number plate of the car you want to unpark: ");
                    String numberPlateToRemove = sc.nextLine();
                    if(parking.unpark(numberPlateToRemove)){
                        System.out.println("Bye, see you again next time!");
                    }else{
                        System.out.println("There is no car with this numberplate.");
                    }
                    break;
                case "3":
                    for (CarModel c : parking.getList()) {
                        System.out.println(c);
                    }
                    break;
                case "4":
                    System.out.println("Saving and exiting...");
                    parking.saveToFile();
                    exit = true;
                    break;
                default:
                    System.out.println("This is not a valid option!");
            }
            if(!exit){
                System.out.println("---------------------------------------------------");
                System.out.println("1. Park the car");
                System.out.println("2. Leave the parking log");
                System.out.println("3. Observe parked cars");
                System.out.println("4. Exit");
            }

        }
    }
}
