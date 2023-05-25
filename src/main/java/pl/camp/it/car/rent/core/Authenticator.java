package pl.camp.it.car.rent.core;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.car.rent.db.IUserRepository;
import pl.camp.it.car.rent.db.UserRepository;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.gui.IGUI;
import pl.camp.it.car.rent.model.User;

//@Component
public class Authenticator implements IAuthenticator {
    @Autowired
    private IGUI gui;
    @Autowired
    private IUserRepository usersDatabase;
    private final String seed = "Ba7gPOCX3l4Kjd6PlgbT8^%XZGRia8LI";

    @Override
    public boolean authenticate() {
        int counter = 0;
        while (counter < 3) {
            User userFromGui = gui.readLoginAndPassword();
            User userFromDb = usersDatabase.findUserByLogin(userFromGui.getLogin());
            if(userFromDb != null &&
                    userFromDb.getPassword().equals(
                            DigestUtils.md5Hex(userFromGui.getPassword() + seed))) {
                return true;
            }

            System.out.println("Incorrect login or password !!");
            counter++;
        }

        return false;
    }
}
