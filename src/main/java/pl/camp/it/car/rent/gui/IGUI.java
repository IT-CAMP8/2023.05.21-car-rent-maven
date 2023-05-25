package pl.camp.it.car.rent.gui;

import pl.camp.it.car.rent.model.User;
import pl.camp.it.car.rent.model.Vehicle;

public interface IGUI {
    String showMenu();
    void listVehicles();
    String readPlate();
    void showRentReturnResult(boolean result);
    User readLoginAndPassword();
}
