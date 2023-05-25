package pl.camp.it.car.rent.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.car.rent.db.IVehicleRepository;
import pl.camp.it.car.rent.db.VehicleRepository;
import pl.camp.it.car.rent.model.User;
import pl.camp.it.car.rent.model.Vehicle;

import java.util.Scanner;

@Component
public class GUI implements IGUI {
    @Autowired
    private IVehicleRepository vehicleRepository;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String showMenu() {
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Return car");
        System.out.println("4. Exit");

        return scanner.nextLine();
    }

    @Override
    public void listVehicles() {
        for(Vehicle vehicle : this.vehicleRepository.getVehicles()) {
            System.out.println(vehicle);
        }
    }

    @Override
    public String readPlate() {
        System.out.println("Plate:");
        return scanner.nextLine();
    }

    @Override
    public void showRentReturnResult(boolean result) {
        if(result) {
            System.out.println("Success !!");
        } else {
            System.out.println("Error !!");
        }
    }

    @Override
    public User readLoginAndPassword() {
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Password:");
        return new User(login, scanner.nextLine());
    }
}
