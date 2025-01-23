package ec.edu.espe.accountingsystem.controller;

import ec.edu.espe.accountingsystem.model.UsersRecord;
import ec.edu.espe.accountingsystem.model.User;

public class UserController {

    private UsersRecord usersRecord;
    private boolean isAdministrator;

    public UserController() {
        usersRecord = new UsersRecord();
        isAdministrator = false;
    }

    public boolean checkUserExists(String type) {
        switch (type) {
            case "administrator":
                return usersRecord.findAdministrator() != null;
            case "seller":
                return usersRecord.findSeller() != null;
            default:
                return false;
        }
    }

    public boolean createUser(String username, String password, String type) {
        
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Nombre de usuario o contraseña no pueden estar vacíos.");
            return false;
        }
        if (username.length() < 3 || password.length() < 6) {
            System.out.println("El nombre de usuario debe tener al menos 3 caracteres y la contraseña al menos 6.");
            return false;
        }

        User user = new User(type, username, password);
        if (!usersRecord.getUsers().contains(user)) {
            usersRecord.addUser(user);
            System.out.println("Usuario creado con éxito.");
            return true;
        } else {
            System.out.println("El usuario ya existe.");
            return false;
        }
    }

    public boolean validateUserCredentials(String type, String username, String password) {
        User user = null;
        switch (type) {
            case "administrator":
                user = usersRecord.findAdministrator();
                System.out.println(user);
                break;
            case "seller":
                user = usersRecord.findSeller();
                break;
        }

        if (user != null) {
            return user.verifyCredential(username, password);
        }

        return false;
    }

    /**
     * @return the isAdministrator
     */
    public boolean isAdministrator() {
        return isAdministrator;
    }

    /**
     * @param isAdministrator the isAdministrator to set
     */
    public void setIsAdministrator(boolean isAdministrator) {
        this.isAdministrator = isAdministrator;
    }
}
