package pl.camp.it.car.rent.core;

import org.springframework.stereotype.Component;

@Component
public class AutenticatorSzyfrowanie implements IAuthenticator {
    @Override
    public boolean authenticate() {
        return false;
    }
}
