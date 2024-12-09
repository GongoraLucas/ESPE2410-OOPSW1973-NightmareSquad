package ec.edu.espe.accountingsystem.model;

import utils.JsonFileManager;
import java.util.Scanner;

public class MainMenu {

    private Scanner scanner;
    private int option;
    private boolean executionMenu;
    private Inventory inventory;
    private InventoryMenu inventoryMenu;
    private VouchersRecord vouchersRecord;
    private TransactionsRecord transactionsRecord;
    private VoucherMenu voucherMenu;
    private TransactionRecordsMenu transactionsMenu;
   private ConverterUnitsMenu converterUnitsMenu;
    
    
     // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow


    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.option = 0;
        this.executionMenu = true;
        this.inventory = new Inventory("Products.json");
        this.inventoryMenu = new InventoryMenu(this.inventory);
        this.vouchersRecord = new VouchersRecord("Vouchers.json");
        this.transactionsRecord = new TransactionsRecord("Transactions.json");
        this.transactionsMenu = new TransactionRecordsMenu(this.transactionsRecord);
        this.converterUnitsMenu = new ConverterUnitsMenu();
    }

    public void runMenu() {
        do {
            try {
                displayMainMenu();
                option = getUserInput();

                switch (option) {
                    case 1:
                        this.inventoryMenu.runMenu();
                        break;
                    case 2:
                        this.voucherMenu = new VoucherMenu(inventory, vouchersRecord, transactionsRecord);
                        this.voucherMenu.runMenu();
                        break;
                    case 3:
                        this.transactionsMenu.runMenu();
                        break;
                    case 4:
                        this.converterUnitsMenu.runMenu();
                        break;
                    case 5:
                        executionMenu = false;
                        System.out.println(SUCCESS_COLOR + "Exiting the system..." + RESET);
                        break;
                    default:
                        System.out.println(ERROR_COLOR + "Invalid option. Please enter a number between 1 and 4." + RESET);
                }
            } catch (Exception e) {
                System.out.print(ERROR_COLOR + "An error occurred: " + e.getMessage() + RESET);
                this.scanner.nextLine(); 
            }
        } while (this.executionMenu);
        this.scanner.close();
    }

    private void displayMainMenu() {
        System.out.println(HEADER_COLOR + "\n\tAccounting System\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Menu" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Manage Inventory" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Billing" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Manage transaction records" + RESET);
        System.out.println(MENU_OPTION_COLOR+ "4. Converter of units" + RESET);
        System.out.println(MENU_OPTION_COLOR + "5. Exit" + RESET);
        System.out.print("Enter the option number: ");
    }

    private int getUserInput() {
        int input = -1;
        while (input == -1) {
            try {
                input = this.scanner.nextInt();
                this.scanner.nextLine();
                if (input < 1 || input > 5) {
                    System.out.println(ERROR_COLOR + "Please enter a number between 1 and 4." + RESET);
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
