
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class encap8{
	 public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C123", "John Doe", 10.0));
        vehicles.add(new Bike("B456", "Jane Smith", 5.0));
        vehicles.add(new Auto("A789", "Mike Johnson", 7.0));

        

        for (Vehicle vehicle : vehicles) {
            Random random = new Random();
            int distance = random.nextInt(100 - 1) + 1;
            System.out.println(vehicle.getVehicleDetails());
            System.out.println("Fare for " + distance + " km: " + vehicle.calculateFare(distance));
        }

        RideHailing rideHailing = new RideHailing();
        System.out.println(rideHailing.getCurrentLocation());
        rideHailing.updateLocation("456 Elm St");
    }
}
abstract class Vehicle{
    private String vehicleId;
    private String driverName;
    private double ratePerKm;


    public Vehicle(String vehicleId,String driverName, double ratePerKm){
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    public abstract double calculateFare(double distance);
    public String getVehicleDetails(){
        return "Vehicle ID: " + vehicleId + ", Driver Name: " + driverName + ", Rate per Km: " + ratePerKm;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public String getDriverName() {
        return driverName;
    }
    public double getRatePerKm() {
        return ratePerKm;
    }
}
class Car extends Vehicle{
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}
class Bike extends Vehicle{
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}
class Auto extends Vehicle{
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}
interface GPS{
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
class RideHailing implements GPS{
    public String getCurrentLocation() {
        return "Current Location: 123 Main St";
    }
    public void updateLocation(String newLocation) {
        System.out.println("Location updated to: " + newLocation);
    }
   
}