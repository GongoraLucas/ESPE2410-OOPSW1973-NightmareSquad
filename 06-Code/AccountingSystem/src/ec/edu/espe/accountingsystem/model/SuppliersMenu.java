package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.exception.InvalidIdentityCardException;
import ec.edu.espe.accountingsystem.exception.InvalidTypeCustomer;

/**
 *
 * @author Lucas Gongora
 */
public class SuppliersMenu extends Menu {

    SuppliersRecord suppliersRecord;

    // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow

    public SuppliersMenu() {
        suppliersRecord = new SuppliersRecord("suppliers.json");
    }

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\n\tAccounting System\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Customers" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Add supplier" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Show suppliers" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Update supplier" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Delete supplier" + RESET);
        System.out.println(MENU_OPTION_COLOR + "5. Exit" + RESET);
        System.out.print("Enter the option number: ");
    }

    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                this.addSupplier();
                break;
            case 2:
                this.showSuppliers();
                break;
            case 3:
                this.updateSupplier();
                break;
            case 4:
                this.deleteCustomer();

                break;
            case 5:
                super.setExecutionMenu(false);
                break;
            default:
                throw new IllegalArgumentException("Option must be between 1 and 5.");
        }
    }

    public void addSupplier() {
        String id;
        String name;
        IdentityCard identityCard;
        String address;
        int phoneNumber;
        String email;
        Supplier supplier;

        System.out.println("Enter the customer data");
        System.out.print("Enter the id of the customer: ");
        id = super.getScanner().nextLine();

        supplier = this.suppliersRecord.findSupplierById(id);

        if (supplier != null) {
            System.out.println("the customer already exist");
            return;
        }

        System.out.print("Enter the name: ");
        name = super.getScanner().nextLine();

        identityCard = this.addIdentityCard();

        System.out.print("Enter the address: ");
        address = super.getScanner().nextLine();

        System.out.print("Enter the phone number: ");
        phoneNumber = super.getScanner().nextInt();
        super.getScanner().nextLine();

        System.out.print("Enter the email: ");
        email = super.getScanner().nextLine();

        supplier = new Supplier(id, name, identityCard, address, phoneNumber, email);

        suppliersRecord.add(supplier);
    }

    public IdentityCard addIdentityCard() {
        String type;
        String id;
        IdentityCard identityCard;
        Boolean isValid;

        while (true) {
            try {
                System.out.println("Enter the identity card data");
                System.out.print("Enter the type of identity document: ");
                type = super.getScanner().nextLine();
                System.out.print("Enter the number of identity document: ");
                id = super.getScanner().nextLine();
                isValid = id != null & id.matches("^\\d{10}(\\d{3})?$");
                if (!isValid) {
                    throw new InvalidIdentityCardException("Invalid identity card");
                }
                identityCard = new IdentityCard(type, id);
                break;
            } catch (InvalidIdentityCardException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return identityCard;

    }

    private void showSuppliers() {
        System.out.println(this.suppliersRecord.toString());
    }

    private void updateSupplier() {
        String id;
        String name;
        IdentityCard identityCard;
        String address;
        int phoneNumber;
        String email;
        Supplier supplier;

        System.out.println("Enter the customer data");
        System.out.print("Enter the id of the customer: ");
        id = super.getScanner().nextLine();
        supplier = this.suppliersRecord.findSupplierById(id);
        if (supplier == null) {
            System.out.println("the supplier does not exist");
            return;
        }

        System.out.print("Enter the name: ");
        name = super.getScanner().nextLine();

        identityCard = this.addIdentityCard();

        System.out.print("Enter the address: ");
        address = super.getScanner().nextLine();

        System.out.print("Enter the phone number: ");
        phoneNumber = super.getScanner().nextInt();
        super.getScanner().nextLine();

        System.out.print("Enter the email: ");
        email = super.getScanner().nextLine();

        supplier = new Supplier(id, name, identityCard, address, phoneNumber, email);

        suppliersRecord.update(id, supplier);

    }

    private void deleteCustomer() {
        String id;
        Supplier supplier;
        System.out.print("Enter the id: ");
        id = super.getScanner().nextLine();
        supplier = this.suppliersRecord.findSupplierById(id);
        if (supplier == null) {
            System.out.println("the supplier does not exist");
            return;
        }
        this.suppliersRecord.delete(id);

    }

}
