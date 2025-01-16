package ec.edu.espe.accountingsystem.model;

import java.io.*;
import java.util.Scanner;
import utils.JsonFileManager;

/**
 *
 * @author David Cuichan
 */
public class User {

    private String type;
    private String userName;
    private String password;

    @Override
    public String toString() {
        return "User{" + "type=" + type + ", userName=" + userName + ", password=" + password + '}';
    }
    
    

    public User(String type,String userName, String password) {
        this.type = type;
        this.userName = userName;
        this.password = this.encryptPassword(password);

    }

    public boolean verifyCredential(String loginUser, String loginPassword) {
        return this.userName.equals(loginUser) && this.password.equals(this.encryptPassword(loginPassword));
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    private String encryptPassword(String password) {

        String encryptedPassword;
        encryptedPassword = "";
        for (char character : password.toCharArray()) {
            int ascii = (int) character;

            int encryptedAscii = ascii + 1;

            encryptedPassword += (char) encryptedAscii;
        }
        return encryptedPassword;

    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}


