package pl.camp.it.car.rent.model;

public class Motorcycle extends Vehicle {
    public Motorcycle(String brand, String model, int year, double price, String plate) {
        super(brand, model, year, price, plate);
    }

    public Motorcycle(String[] vars) {
        super(vars);
    }

    public Motorcycle() {
    }
}
