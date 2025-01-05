package ec.edu.espe.accountingsystem.model;


public class AdministratorMenu extends Menu {
    private final BillingMenu billingMenu;
    private final InventoryMenu inventoryMenu;
    private final TransactionMenu transactionsMenu;
    private final ConverterUnitsMenu converterUnitsMenu;
    private final BranchesMenu branchesMenu;
    private final CustomersMenu customersMenu;
    private final SuppliersMenu suppliersMenu;
    private final VouchersMenu vouchersMenu;

    // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green

    public AdministratorMenu() {
        super();
        this.inventoryMenu = new InventoryMenu();
        this.billingMenu = new BillingMenu();
        this.transactionsMenu = new TransactionMenu();
        this.converterUnitsMenu = new ConverterUnitsMenu();
        this.branchesMenu = new BranchesMenu();
        this.customersMenu =  new CustomersMenu();
        this.suppliersMenu =  new SuppliersMenu();
        this.vouchersMenu = new VouchersMenu();
    }

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\n\tAccounting System\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Menu" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Branches" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Inventory" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Customers" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Suppliers" + RESET);
        System.out.println(MENU_OPTION_COLOR + "5. Billing" + RESET);
        System.out.println(MENU_OPTION_COLOR + "6. Vouchers" + RESET);
        System.out.println(MENU_OPTION_COLOR + "7. Transactions" + RESET);
        System.out.println(MENU_OPTION_COLOR + "8. Conversions" + RESET);
        System.out.println(MENU_OPTION_COLOR + "9. Exit" + RESET);
        System.out.print("Enter the option number: ");
    }

    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                this.branchesMenu.run();
                break;
            case 2:
                this.inventoryMenu.run();
                break;
            case 3:
                this.customersMenu.run();
                break;
            case 4:
                this.suppliersMenu.run();
                break;
            case 5:
                this.billingMenu.run();
                break;
            case 6:
                this.vouchersMenu.run();
                break;
            case 7:
                this.transactionsMenu.run();
                break;
            case 8:
                this.converterUnitsMenu.run();
                break;
            case 9:
                super.setExecutionMenu(false);
                break;
            default:
                throw new IllegalArgumentException("Option must be between 1 and 9.");
        }
    }

}
