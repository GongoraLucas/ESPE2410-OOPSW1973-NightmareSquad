package ec.edu.espe.accountingsystem.model;

public class SellerMenu extends Menu {

    private final BillingMenu billingMenu;
    private final CustomersMenu customersMenu;
    private final SuppliersMenu suppliersMenu;

    // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow

    public SellerMenu() {
        super();
        this.billingMenu = new BillingMenu();
        this.customersMenu = new CustomersMenu();
        this.suppliersMenu = new SuppliersMenu();

    }

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\n\tAccounting System\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Menu" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Customers" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Suppliers" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Billing" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Exit" + RESET);
        System.out.print("Enter the option number: ");
    }

    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                this.customersMenu.run();
                break;
            case 2:
                this.suppliersMenu.run();
                break;
            case 3:
                this.billingMenu.run();
                break;
            case 4:
                super.setExecutionMenu(false);
                break;
            default:
                throw new IllegalArgumentException("Option must be between 1 and 4.");
        }
    }

}
