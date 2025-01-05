package ec.edu.espe.accountingsystem.model;

import utils.JsonFileManager;

public class UsersRecord {
    private JsonFileManager usersJson;
    private User[] users;

    public UsersRecord() {
        this.usersJson = new JsonFileManager("Credentials.json");
        this.users = usersJson.readUsers();
    }

    public void saveUser(User user) {
        boolean userSaved = false;

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                userSaved = true;
                break;
            }
        }

        if (!userSaved) {
            System.out.println("There are already two users");
        } else {
            this.getUsersJson().saveUsers(users);
        }
    }

    public void updateJson() {
        this.users = this.usersJson.readUsers();
    }

    public JsonFileManager getUsersJson() {
        return usersJson;
    }

    public void setUsersJson(JsonFileManager usersJson) {
        this.usersJson = usersJson;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public User findAdministrator() {
        for (User user : users) {
            if (user != null && user.getType().equals("administrator")) {
                return user;
            }
        }
        return null;
    }

    public User findSeller() {
        for (User user : users) {
            if (user != null && user.getType().equals("seller")) {
                return user;
            }
        }
        return null;
    }
}
