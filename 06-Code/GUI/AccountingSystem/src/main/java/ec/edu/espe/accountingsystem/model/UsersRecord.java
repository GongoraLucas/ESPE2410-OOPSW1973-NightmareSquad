package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;

public class UsersRecord extends Record {
   private static String collection = "users";
   private boolean areTwoUsers;

    public UsersRecord() {
       super();
       this.areTwoUsers=false;
    }
    public ArrayList<User> getUsers(){
            return  super.getDatabase().readAllData(collection, User.class);
    }
    public void addUser(User user) {
        areTwoUsers = this.getUsers().size() == 2;
        if (areTwoUsers) return;
        super.getDatabase().insertData(collection, user);
    }



    public User findAdministrator() {
        for (User user : this.getUsers()) {
            if (user != null && user.getType().equals("administrator")) {
                return user;
            }
        }
        return null;
    }

    public User findSeller() {
        for (User user : this.getUsers()) {
            if (user != null && user.getType().equals("seller")) {
                return user;
            }
        }
        return null;
    }
}
