package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.Vehicle;

import java.util.Collection;

public interface IVehicleRepository {
    boolean rentVehicle(String plate);
    boolean returnVehicle(String plate);
    void addVehicle(Vehicle vehicle);
    Collection<Vehicle> getVehicles();
}
