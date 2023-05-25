package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.User;

import java.util.Collection;

public interface IUserRepository {
    User findUserByLogin(String login);
    void addUser(User user);
    Collection<User> getUsers();
}
