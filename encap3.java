
import java.util.*;

public class encap3 {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR123", 50, "POL123456"));
        vehicles.add(new Bike("BIKE456", 20, "POL654321"));
        vehicles.add(new Truck("TRUCK789", 100, "POL987654"));

        int rentalDays = 5;
        
        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle Type: " + vehicle.getType());
            System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
            System.out.println("Rental Cost for " + rentalDays + " days: $" + vehicle.calculateRentalCost(rentalDays));
            
            if (vehicle instanceof Insurable) {
                Insurable insurable = (Insurable) vehicle;
                System.out.println("Insurance Cost: $" + insurable.calculateInsurance());
                System.out.println(insurable.getInsuranceDetails());
            }
            
            System.out.println("------------------------------");
        }
    }
}


// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Subclass Car
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.05;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance policy (confidential): " + insurancePolicyNumber.substring(0, 3) + "****";
    }
}

// Subclass Bike
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.02;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance policy (confidential): " + insurancePolicyNumber.substring(0, 3) + "****";
    }
}

// Subclass Truck
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate * 1.2; 
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.1;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance policy (confidential): " + insurancePolicyNumber.substring(0, 3) + "****";
    }
}