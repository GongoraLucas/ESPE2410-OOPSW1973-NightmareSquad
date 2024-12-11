package ec.edu.espe.accountingsystem.model;


import java.util.Scanner;

public class Access {

    private Scanner scanner;
    private int option;
    private boolean executionMenu;
    private UsersRecord usersRecord;
    private AdministratorMenu administratorMenu;
    private SellerMenu sellerMenu;

    public Access() {
        this.usersRecord = new UsersRecord();
        this.scanner = new Scanner(System.in);
        this.option = 0;
        this.executionMenu = true;
        this.administratorMenu = new AdministratorMenu();
        this.sellerMenu = new SellerMenu();
    }

    public void runMenu() {
        do {
            this.showMenu();
            try {
                this.option = this.scanner.nextInt();
                this.scanner.nextLine();  // Consume the newline character
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
                this.scanner.nextLine(); // Clear the buffer
                continue;
            }
            switch (this.option) {
                case 1:
                    if (this.logInAsAdministrator()) {
                        this.administratorMenu.runMenu();
                    }
                    break;
                case 2:
                    if (this.logInAsSeller()) {
                        this.sellerMenu.runMenu();
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    this.executionMenu = false;
                    break;
                default:
                    System.out.println("Enter the correct number option");
            }
        } while (executionMenu);
        this.scanner.close();
    }

    public void showMenu() {
        System.out.println("Accounting system");
        System.out.println("Login");
        System.out.println("1. Administrator");
        System.out.println("2. Seller");
        System.out.println("3. Exit");
        System.out.print("Enter the number option: ");
    }

    public boolean logInAsAdministrator() {
        String[] credentials;
        User user;
        int attempt = 0;

        user = this.usersRecord.findAdministrator();

        if (user != null) {
            while (attempt < 3) {
                credentials = this.enterCredentials();

                if (user.verifyCredential(credentials[0], credentials[1])) {
                    System.out.println("Successful login!");
                    return true;
                }
                System.out.println("Invalid credentials");
                attempt++;
            }
            return false;
        } else {
            System.out.println("Enter credentials to create an administrator");
            credentials = this.enterCredentials();
            user = new User("administrator", credentials[0], credentials[1]);
            this.usersRecord.saveUser(user);
            return true;
        }
    }

    public boolean logInAsSeller() {
        String[] credentials;
        User user;
        int attempt = 0;

        user = this.usersRecord.findSeller();

        if (user != null) {
            while (attempt < 3) {
                credentials = this.enterCredentials();

                if (user.verifyCredential(credentials[0], credentials[1])) {
                    System.out.println("Successful login!");
                    return true;
                }
                System.out.println("Invalid credentials");
                attempt++;
            }
            return false;
        } else {
            System.out.println("Enter credentials to create a seller");
            credentials = this.enterCredentials();
            user = new User("seller", credentials[0], credentials[1]);
            this.usersRecord.saveUser(user);
            return true;
        }
    }

    public String[] enterCredentials() {
        String username;
        String password;
        boolean isValidPassword = false;

        password = "";
        System.out.print("Username: ");
        username = this.scanner.nextLine();

        while (!isValidPassword) {
            
            System.out.print("Password: ");
            password = this.scanner.nextLine();

            if (password.matches("[a-zA-Z0-9]+")) {
                isValidPassword = true;
            } else {
                System.out.println("Password must contain only letters and numbers.");
            }
        }

        return new String[]{username, password};
    }

   

}
