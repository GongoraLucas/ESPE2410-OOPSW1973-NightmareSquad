package ec.edu.espe.accountingsystem.model;

import java.util.Scanner;

/**
 *
 * @author David Cuichan
 */
public class Access {
    private User user;
    public Access() {
        this.user = User.loadUser();
    }
    
    public boolean login(){
        if (user == null) {
            System.out.println("There are no registered users. Please register a user.");
            Scanner scanner = new Scanner(System.in);
            System.out.print("User: ");
            String userName = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            user = new User(userName, password);
            user.saveUser();
            return true;
        }

        Scanner scanner = new Scanner(System.in);
        int attempt = 0;

        while (attempt < 3) {
            System.out.print("User: ");
            String userRegistered = scanner.nextLine();

            System.out.print("Password: ");
            String passwordRegistered = scanner.nextLine();

            if (user.verifyCredential(userRegistered, passwordRegistered)) {
                System.out.println("Successful login!");
                return true;
            }

            attempt++;
            System.out.println("Incorrect credentials. Attempt " + attempt + " to 3");
        }

        System.out.println("Too many attempts. Access denied.");
        return false;
    }
}
