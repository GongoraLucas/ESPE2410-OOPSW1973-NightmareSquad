package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.exception.InvalidIdentityCardException;
import ec.edu.espe.accountingsystem.exception.InvalidTypeCustomer;

/**
 *
 * @author Lucas Gongora
 */
public class CustomersMenu extends Menu {

    CustomersRecord customersRecord;

    public CustomersMenu(CustomersRecord customersRecord) {
        this.customersRecord = customersRecord;
    }
    
    

    // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow

    public CustomersMenu() {
        customersRecord = new CustomersRecord("customers.json");
    }

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\n\tAccounting System\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Customers" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Add customer" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Show customers" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Update customer" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Delete customer" + RESET);
        System.out.println(MENU_OPTION_COLOR + "5. Exit" + RESET);
    }

    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                this.addCustomer();
                break;
            case 2:
                this.showCustomers();
                break;
            case 3:
                this.updateCustomer();
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

    private void addCustomer() {
        String id;
        String type;
        String name;
        IdentityCard identityCard;
        String address;
        String phoneNumber;
        String email;
        Customer customer;

        System.out.println("Enter the customer data");
        System.out.print("Enter the id of the customer: ");
        id = super.getScanner().nextLine();
        customer = this.customersRecord.findCustomerById(id);
        if (customer != null) {
            System.out.println("the customer already exist");
            return;
        }

        while (true) {
            System.out.print("Enter the type of customer (retail, wholesale, distributor): ");
            type = super.getScanner().nextLine();

            try {
                validateCustomerType(type);
                break;
            } catch (InvalidTypeCustomer ex) {
                System.out.println(ex.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_COLOR + e.getMessage() + RESET);
                System.out.println("Please try again with a valid customer type.");
            } catch (Exception e) {
                System.out.println(ERROR_COLOR + "Unexpected error: " + e.getMessage() + RESET);
            }
        }

        System.out.print("Enter the name: ");
        name = super.getScanner().nextLine();

        identityCard = this.addIdentityCard();

        System.out.print("Enter the address: ");
        address = super.getScanner().nextLine();

        System.out.print("Enter the phone number: ");
        phoneNumber = super.getScanner().nextLine();
        super.getScanner().nextLine();

        System.out.print("Enter the email: ");
        email = super.getScanner().nextLine();

        customer = new Customer(id, type, name, identityCard, address, phoneNumber, email);

        customersRecord.add(customer);
    }

    private IdentityCard addIdentityCard() {
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
                identityCard = new IdentityCard(type, id);
                break;
            } catch (InvalidIdentityCardException ex) {
                continue;
            }
        }
        return identityCard;

    }

    private void validateCustomerType(String type) throws InvalidTypeCustomer {
        if (!"retail".equals(type) & !"wholesale".equals(type) & !"distributor".equals(type)) {
            throw new InvalidTypeCustomer();
        }
    }

    private void showCustomers() {
        System.out.println(this.customersRecord.toString());
    }

    private void updateCustomer() {
        String id;
        String type;
        String name;
        IdentityCard identityCard;
        String address;
        String phoneNumber;
        String email;
        Customer customer;

        System.out.println("Enter the customer data");
        System.out.print("Enter the id of the customer: ");
        id = super.getScanner().nextLine();
        customer = this.customersRecord.findCustomerById(id);
        if (customer == null) {
            System.out.println("the customer does not exist");
            return;
        }

        while (true) {
            System.out.print("Enter the type of customer (retail, wholesale, distributor): ");
            type = super.getScanner().nextLine();
            try {
                validateCustomerType(type);

                break;
            } catch (InvalidTypeCustomer ex) {
                System.out.println(ex.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_COLOR + e.getMessage() + RESET);
                System.out.println("Please try again with a valid customer type.");
            } catch (Exception e) {
                System.out.println(ERROR_COLOR + "Unexpected error: " + e.getMessage() + RESET);
            }
        }

        System.out.print("Enter the name: ");
        name = super.getScanner().nextLine();

        identityCard = this.addIdentityCard();

        System.out.print("Enter the address: ");
        address = super.getScanner().nextLine();

        System.out.print("Enter the phone number: ");
        phoneNumber = super.getScanner().nextLine();

        System.out.print("Enter the email: ");
        email = super.getScanner().nextLine();

        customer = new Customer(id, type, name, identityCard, address, phoneNumber, email);

        customersRecord.update(id, customer);

    }

    private void deleteCustomer() {
        String id;
        Customer customer;
        System.out.print("Enter the id: ");
        id = super.getScanner().nextLine();
        customer = this.customersRecord.findCustomerById(id);
        if (customer == null) {
            System.out.println("the customer does not exist");
            return;
        }
        this.customersRecord.delete(id);

    }

}
