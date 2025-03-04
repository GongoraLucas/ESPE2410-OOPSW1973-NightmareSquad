package ec.edu.espe.accountingsystem.model;


import java.util.Scanner;

public class Login extends Menu{

    private UsersRecord usersRecord;
    private AdministratorMenu administratorMenu;
    private SellerMenu sellerMenu;

    public Login() {
        super();
        this.usersRecord = new UsersRecord();
        this.administratorMenu = new AdministratorMenu();
        this.sellerMenu = new SellerMenu();
    }

    public Login(UsersRecord usersRecord, AdministratorMenu administratorMenu, SellerMenu sellerMenu) {
        this.usersRecord = usersRecord;
        this.administratorMenu = administratorMenu;
        this.sellerMenu = sellerMenu;
    }

    @Override
    public String toString() {
        return "Login{" + "usersRecord=" + usersRecord + ", administratorMenu=" + administratorMenu + ", sellerMenu=" + sellerMenu + '}';
    }
    
    

    public UsersRecord getUsersRecord() {
        return usersRecord;
    }

    public void setUsersRecord(UsersRecord usersRecord) {
        this.usersRecord = usersRecord;
    }

    public AdministratorMenu getAdministratorMenu() {
        return administratorMenu;
    }

    public void setAdministratorMenu(AdministratorMenu administratorMenu) {
        this.administratorMenu = administratorMenu;
    }

    public SellerMenu getSellerMenu() {
        return sellerMenu;
    }

    public void setSellerMenu(SellerMenu sellerMenu) {
        this.sellerMenu = sellerMenu;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    
    
    
    @Override
    public void showOptions() {
        System.out.println("Accounting system");
        System.out.println("Login");
        System.out.println("1. Administrator");
        System.out.println("2. Seller");
        System.out.println("3. Exit");
    }
    
    @Override
    public void processOption(int option){
         switch (option) {
                case 1:
                    if (this.logInAsAdministrator()) {
                        this.administratorMenu.run();
                    }
                    break;
                case 2:
                    if (this.logInAsSeller()) {
                        this.sellerMenu.run();
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    super.setExecutionMenu(false);
                    break;
                default:
                    System.out.println("Enter the correct number option");
            }
    }

    private boolean logInAsAdministrator() {
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

    private boolean logInAsSeller() {
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

    private String[] enterCredentials() {
        String username;
        String password;
        boolean isValidPassword = false;

        password = "";
        System.out.print("Username: ");
        username = super.getScanner().nextLine();

        while (!isValidPassword) {
            
            System.out.print("Password: ");
            password = super.getScanner().nextLine();

            if (password.matches("[a-zA-Z0-9]+")) {
                isValidPassword = true;
            } else {
                System.out.println("Password must contain only letters and numbers.");
            }
        }

        return new String[]{username, password};
    }

   

}
