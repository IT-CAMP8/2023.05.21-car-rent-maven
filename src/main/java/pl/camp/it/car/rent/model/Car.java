package pl.camp.it.car.rent.model;

public class Car extends Vehicle {

    public Car(String brand, String model, int year,
               double price, String plate) {
        super(brand, model, year, price, plate);
    }

    public Car(String[] vars) {
        super(vars);
    }

    public Car() {
    }
}
