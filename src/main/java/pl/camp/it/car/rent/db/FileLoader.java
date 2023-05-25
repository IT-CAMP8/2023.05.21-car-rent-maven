package pl.camp.it.car.rent.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.car.rent.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Component
public class FileLoader implements IFileLoader {
    @Autowired
    private IVehicleRepository vehicleRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void readDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("db.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] objectData = line.split(";");
            String[] vars = Arrays.copyOfRange(objectData, 1, objectData.length);
            switch (objectData[0]) {
                case "Motorcycle":
                    this.vehicleRepository.addVehicle(new Motorcycle(vars));
                    break;
                case "Bus":
                    this.vehicleRepository.addVehicle(new Bus(vars));
                    break;
                case "Car":
                    this.vehicleRepository.addVehicle(new Car(vars));
                    break;
                case "User":
                    this.userRepository.addUser(new User(vars));
                    break;
                default:
                    System.out.println("Unexpected type during DB loading !!");
                    break;
            }
        }
        reader.close();
    }

    @Override
    public void saveDataToFile() throws IOException {
        Collection<Writable> entries = new ArrayList<>();
        entries.addAll(this.vehicleRepository.getVehicles());
        entries.addAll(this.userRepository.getUsers());
        BufferedWriter writer =
                new BufferedWriter(new FileWriter("db.csv"));
        boolean firstTime = true;
        for (Writable entry : entries) {
            String lineInFile = entry.toCSV();
            if (!firstTime) {
                writer.newLine();
            }
            firstTime = false;
            writer.write(lineInFile);
        }
        writer.close();
    }
}
