package ec.edu.espe.accountingsystem.model;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author David Cuichan
 */
public class User {

    private String userName;
    private String password;
    

    public User(String userName, String password) {
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

    public void saveUser() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Credentials.txt"))) {
            writer.write(userName);
            writer.newLine();
            writer.write(password);
            System.out.println("User Registered");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public static User loadUser() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Credentials.txt"))) {
            String userName = reader.readLine();
            String password = reader.readLine();
            return new User(userName, password);
        } catch (IOException e) {
            System.out.println("user not found.");
            return null;
        }
    }

    private String encryptPassword(String password) {
        File file = new File("Credentials.txt");
        if (!file.exists()) {
            String encryptedPassword;
            encryptedPassword = "";
            for (char character : password.toCharArray()) {
                int ascii = (int) character;

                int encryptedAscii = ascii + 1;

                encryptedPassword += (char) encryptedAscii;
            }
            return encryptedPassword;

        }
        return this.savePasswordTxt();

    }
    
    private String savePasswordTxt(){
        String endLine;
        String line;
        line="";
        endLine="";
        try (BufferedReader br = new BufferedReader(new FileReader("Credentials.txt"))) {
            
            while ((line = br.readLine()) != null) {
                endLine = line; 
            }
           
        } catch (IOException e) {
            return endLine;
        }
        
        return endLine;
    }
}
