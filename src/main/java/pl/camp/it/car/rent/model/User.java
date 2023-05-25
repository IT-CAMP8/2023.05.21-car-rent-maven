package pl.camp.it.car.rent.model;

public class User implements Writable {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String[] vars) {
        this(vars[0], vars[1]);
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toCSV() {
        return new StringBuilder()
                .append(getClass().getSimpleName())
                .append(";")
                .append(this.login)
                .append(";")
                .append(this.password)
                .toString();
    }
}
