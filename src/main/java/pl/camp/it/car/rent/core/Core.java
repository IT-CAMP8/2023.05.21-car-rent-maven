package pl.camp.it.car.rent.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.car.rent.db.FileLoader;
import pl.camp.it.car.rent.db.IFileLoader;
import pl.camp.it.car.rent.db.IVehicleRepository;
import pl.camp.it.car.rent.db.VehicleRepository;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.gui.IGUI;

import java.io.IOException;

@Component
public class Core implements ICore {
    @Autowired
    private IVehicleRepository database;
    @Autowired
    private IFileLoader fileLoader;
    @Autowired
    private IAuthenticator authenticator;
    @Autowired
    private IGUI gui;

    @Override
    public void start() {
        try {
            fileLoader.readDataFromFile();
        } catch (IOException e) {
            System.out.println("Database is malformed !!");
            return;
        }
        if(!authenticator.authenticate()) {
            return;
        }
        mainloop:
        while(true) {
            switch(gui.showMenu()) {
                case "1":
                    gui.listVehicles();
                    break;
                case "2":
                    gui.showRentReturnResult(database.rentVehicle(gui.readPlate()));
                    break;
                case "3":
                    gui.showRentReturnResult(database.returnVehicle(gui.readPlate()));
                    break;
                case "4":
                    try {
                        fileLoader.saveDataToFile();
                        break mainloop;
                    } catch (IOException e) {
                        System.out.println("Database Error !!");
                    }
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
}
