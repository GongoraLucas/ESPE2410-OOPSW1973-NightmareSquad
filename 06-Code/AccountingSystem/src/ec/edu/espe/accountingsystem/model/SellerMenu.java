package ec.edu.espe.accountingsystem.model;

import utils.JsonFileManager;
import java.util.Scanner;

public class SellerMenu {

    private Scanner scanner;
    private int option;
    private boolean executionMenu;
    private Inventory inventory;
    private VouchersRecord vouchersRecord;
    private TransactionsRecord transactionsRecord;
    private VoucherMenu voucherMenu;
    
    
     // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow


    public SellerMenu() {
        this.scanner = new Scanner(System.in);
        this.option = 0;
        this.executionMenu = true;
        this.inventory = new Inventory();
        this.vouchersRecord = new VouchersRecord();
        this.transactionsRecord = new TransactionsRecord();
    }

    public void runMenu() {
        do {
            try {
                displayMainMenu();
                option = getUserInput();

                switch (option) {
                    case 1:
                        this.voucherMenu = new VoucherMenu(inventory, vouchersRecord, transactionsRecord);
                        this.voucherMenu.runMenu();
                        break;
                    case 2:
                        executionMenu = false;
                   
                        break;
                    default:
                        System.out.println(ERROR_COLOR + "Invalid option. Please enter a number between 1 and 4." + RESET);
                }
            } catch (Exception e) {
                System.out.print(ERROR_COLOR + "An error occurred: " + e.getMessage() + RESET);
                this.scanner.nextLine(); 
            }
        } while (this.executionMenu);
       
    }

    private void displayMainMenu() {
        System.out.println(HEADER_COLOR + "\n\tAccounting System\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Menu" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Billing" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Exit" + RESET);
        System.out.print("Enter the option number: ");
    }

    private int getUserInput() {
        int input = -1;
        while (input == -1) {
            try {
                input = this.scanner.nextInt();
                this.scanner.nextLine();
                if (input < 1 || input > 2) {
                    System.out.println(ERROR_COLOR + "Please enter a number between 1 and 2." + RESET);
                    input = -1;
                }
            } catch (Exception e) {
                System.out.println(ERROR_COLOR + "Invalid input. Please enter a valid number." + RESET);
                this.scanner.nextLine();
            }
        }
        return input;
    }

}
