package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.model.Record;
import ec.edu.espe.accountingsystem.model.User;
import java.util.ArrayList;

public class UsersRecord extends Record {
    private static String collection = "users";
    private boolean areTwoUsers;

    public UsersRecord() {
        super();
        this.areTwoUsers = false;
    }

    public ArrayList<User> getUsers() {
        return super.getDatabase().readAllData(collection, User.class);
    }

    public void addUser(User user) {

        if (this.areTwoUsers) {
            System.out.println("Ya hay dos usuarios registrados.");
            return;
        }


        if (getUsers().stream().anyMatch(existingUser -> existingUser.getUsername().equals(user.getUsername()))) {
            System.out.println("El nombre de usuario ya está en uso.");
            return;
        }

        super.getDatabase().insertData(collection, user);
    }

    public User findAdministrator() {
        return this.getUsers().stream()
                .filter(user -> "administrator".equals(user.getType()))
                .findFirst()
                .orElse(null);
    }

    public User findSeller() {
        return this.getUsers().stream()
                .filter(user -> "seller".equals(user.getType()))
                .findFirst()
                .orElse(null);
    }
}
