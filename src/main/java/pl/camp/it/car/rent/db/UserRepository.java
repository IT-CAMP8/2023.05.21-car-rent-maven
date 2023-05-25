package pl.camp.it.car.rent.db;

import org.springframework.stereotype.Component;
import pl.camp.it.car.rent.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository implements IUserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public User findUserByLogin(String login) {
        /*for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;*/

        return this.users.get(login);
    }

    @Override
    public void addUser(User user) {
        this.users.put(user.getLogin(), user);
    }

    @Override
    public Collection<User> getUsers() {
        return this.users.values();
    }
}
