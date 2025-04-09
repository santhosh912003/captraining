public class inheri11 {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 200);
        PetrolVehicle bmw = new PetrolVehicle("BMW M3", 250);

        tesla.displayInfo();
        tesla.charge();

        bmw.displayInfo();
        bmw.refuel();
    }
}

class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;yy
    }
    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println(model + " is charging.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling.");
    }
}