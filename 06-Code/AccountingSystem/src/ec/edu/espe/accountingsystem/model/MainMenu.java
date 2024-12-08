package ec.edu.espe.accountingsystem.model;


import java.util.Scanner;

/**
 *
 * @author Lucas Gongora
 */
public class MainMenu {

    private Scanner scanner;
    private int option;
    private boolean executionMenu;
    private InventoryMenu inventoryMenu;
    private TransactionRecordsMenu transactionsMenu;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.option = 0;
        this.executionMenu = true;
        this.inventoryMenu = new InventoryMenu();
        this.transactionsMenu = new TransactionRecordsMenu();
    }

    public void runMenu() {
        do {
            System.out.println("\tAccounting System\t");
            System.out.println("Menu");
            System.out.println("1. Manage Inventory");
            System.out.println("2. Generate voucher");
            System.out.println("3. Manage transaction records");
            System.out.println("4. Exit");

            System.out.print("Enter the option number: ");

            option = this.scanner.nextInt();
            this.scanner.nextLine();
           

            switch (this.option) {
                case 1:
                    this.inventoryMenu.runMenu();
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    this.transactionsMenu.runMenu();
                    break;
                case 4:
                    executionMenu = false;
                    break;
                default:
                    System.out.println("Enter the correct option ");
            }
        } while (this.executionMenu);
        this.scanner.close();
    }

}
