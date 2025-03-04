package ec.edu.espe.accountingsystem.model;

import java.util.Scanner;

/**
 *
 * @author Lucas Gongora
 */
public class BillingMenu extends Menu {

    private SaleMenu saleMenu;
    private PurchaseMenu purchaseMenu;

    // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow

    public BillingMenu() {
        super();
        saleMenu = new SaleMenu();
    }

    public BillingMenu(SaleMenu saleMenu, PurchaseMenu purchaseMenu) {
        this.saleMenu = saleMenu;
        this.purchaseMenu = purchaseMenu;
    }
    
    public BillingMenu() {
        this.saleMenu = saleMenu;
        this.purchaseMenu = purchaseMenu;
    }

    public SaleMenu getSaleMenu() {
        return saleMenu;
    }

    public void setSaleMenu(SaleMenu saleMenu) {
        this.saleMenu = saleMenu;
    }

    public PurchaseMenu getPurchaseMenu() {
        return purchaseMenu;
    }

    public void setPurchaseMenu(PurchaseMenu purchaseMenu) {
        this.purchaseMenu = purchaseMenu;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    
    
    
    

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\n\t Accounting system \t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Billing" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Sale" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Purchase" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Back to the main menu" + RESET);

    }

    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                saleMenu.run();
                break;
            case 2:
                purchaseMenu.run();
                break;
            case 3:
                super.setExecutionMenu(false);
                break;

            default:
                throw new IllegalArgumentException("Option must be between 1 and 8.");
        }
    }

  
}


