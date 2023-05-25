package pl.camp.it.car.rent.db;

import org.springframework.stereotype.Component;
import pl.camp.it.car.rent.model.Vehicle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class VehicleRepository implements IVehicleRepository {
    private final Map<String, Vehicle> vehicles = new HashMap<>();

    @Override
    public boolean rentVehicle(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);
        if(vehicle != null && !vehicle.isRent()) {
            vehicle.setRent(true);
            return true;
        }
        return false;
        /*for(Vehicle vehicle : this.vehicles) {
            if(!vehicle.isRent() && vehicle.getPlate().equals(plate)) {
                vehicle.setRent(true);
                return true;
            }
        }
        return false;*/
    }

    @Override
    public boolean returnVehicle(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);
        if(vehicle != null && vehicle.isRent()) {
            vehicle.setRent(false);
            return true;
        }
        return false;
        /*for(Vehicle vehicle : this.vehicles) {
            if(vehicle.isRent() && vehicle.getPlate().equals(plate)) {
                vehicle.setRent(false);
                return true;
            }
        }
        return false;*/
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.put(vehicle.getPlate(), vehicle);
    }

    @Override
    public Collection<Vehicle> getVehicles() {
        return vehicles.values();
    }
}
