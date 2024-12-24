package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.exception.InvalidIdentityCardException;
import utils.JsonFileManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Lucas Gongora
 */
public class VoucherMenu {

    private Scanner scanner;
    private int option;
    private boolean executionMenu;
    private Customer customer;
    private Supplier supplier;
    private Inventory inventory;
    private ArrayList<Product> shoppingCart;
    private VouchersRecord vouchersRecord;
    private Voucher voucher;
    private TransactionsRecord transactionsRecord;

    // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow

    public VoucherMenu(Inventory inventory, VouchersRecord vouchersRecord, TransactionsRecord transactionRecord) throws InvalidIdentityCardException {
        this.scanner = new Scanner(System.in);
        this.option = 0;
        this.executionMenu = true;
        this.customer = this.addCustomer();
        this.supplier = this.addSuplier();
        this.inventory = inventory;
        this.shoppingCart = new ArrayList<>();
        this.vouchersRecord = vouchersRecord;
        this.transactionsRecord = transactionRecord;
    }

    public void runMenu() {
        do {
            System.out.println(HEADER_COLOR + "\n\t Accounting system \t" + RESET);
            System.out.println(SUBHEADER_COLOR + "Voucher" + RESET);
            System.out.println(MENU_OPTION_COLOR + "1. Add product to shopping cart" + RESET);
            System.out.println(MENU_OPTION_COLOR + "2. Remove product to shopping cart" + RESET);
            System.out.println(MENU_OPTION_COLOR + "3. Modify product in shopping cart" + RESET);
            System.out.println(MENU_OPTION_COLOR + "4. Generate Voucher" + RESET);
            System.out.println(MENU_OPTION_COLOR + "5. Modify Voucher" + RESET);
            System.out.println(MENU_OPTION_COLOR + "6. Save Voucher" + RESET);
            System.out.println(MENU_OPTION_COLOR + "7. Send Voucher to Transactions Record" + RESET);
            System.out.println(MENU_OPTION_COLOR + "8. Back to the main menu" + RESET);

            System.out.print("Enter the number option: ");
            try {
                this.option = this.scanner.nextInt();
                this.scanner.nextLine();

                switch (this.option) {
                    case 1:
                        this.addProductToShoppingCart();
                        break;
                    case 2:
                        this.removeProductToShoppingCart();
                        break;
                    case 3:
                        this.modifyProductInShoppingCart();
                        break;
                    case 4:
                        this.generateVoucher();
                        break;
                    case 5:
                        this.modifyVoucher();
                        break;
                    case 6:
                        this.saveVoucher();
                        break;
                    case 7:
                        this.sendVoucherToTransaction();
                        break;
                    case 8:
                        this.executionMenu = false;
                        break;
                    default:
                        System.out.println(ERROR_COLOR + "Enter a valid option between 1 and 8." + RESET);
                }

            } catch (Exception e) {
                System.out.print(ERROR_COLOR + "Invalid input. Please enter a number between 1 and 8: " + RESET);
                this.scanner.nextLine();
            }
        } while (this.executionMenu);
    }

    public Customer addCustomer() throws InvalidIdentityCardException {
        String type;
        String name;
        IdentityCard identityCard;
        String address;
        String phoneNumber;
        String email;

        System.out.println("Enter the customer data");

        while (true) {
            System.out.print("Enter the type of customer (retail, wholesale, distributor): ");
            type = this.scanner.nextLine();

            try {
                validateCustomerType(type);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_COLOR + e.getMessage() + RESET);
                System.out.println("Please try again with a valid customer type.");
            } catch (Exception e) {
                System.out.println(ERROR_COLOR + "Unexpected error: " + e.getMessage() + RESET);
            }
        }

        System.out.print("Enter the name: ");
        name = this.scanner.nextLine();

        identityCard = this.addIdentityCard();

        System.out.print("Enter the address: ");
        address = this.scanner.nextLine();

        System.out.print("Enter the phone number: ");
        phoneNumber = this.scanner.nextLine();

        System.out.print("Enter the email: ");
        email = this.scanner.nextLine();

        return new Customer(type, name, identityCard, address, phoneNumber, email);
    }

    public Supplier addSuplier() throws InvalidIdentityCardException {
        String type;
        String name;
        IdentityCard identityCard;
        String address;
        String phoneNumber;
        String email;

        System.out.println("Enter the supplier data");
        System.out.print("Enter the type of supplier: ");
        type = this.scanner.nextLine();
        System.out.print("Enter the name: ");
        name = this.scanner.nextLine();
        identityCard = this.addIdentityCard();
        System.out.print("Enter the address: ");
        address = this.scanner.nextLine();
        System.out.print("Enter the phone number: ");
        phoneNumber = this.scanner.nextLine();
        System.out.print("Enter the email: ");
        email = this.scanner.nextLine();

        return new Supplier(type, name, identityCard, address, phoneNumber, email);
    }

    public IdentityCard addIdentityCard() throws InvalidIdentityCardException {
        String type;
        String id;
        System.out.println("Enter the identity card data");
        System.out.print("Enter the type of identity document: ");
        type = this.scanner.nextLine();
        System.out.print("Enter the number of identity document: ");
        id = this.scanner.nextLine();
        return new IdentityCard(type, id);
    }

    public void addProductToShoppingCart() {
        String id;
        int amount;
        Product product;

        System.out.print("Enter the id of the product: ");
        id = this.scanner.nextLine();

        try {
            System.out.print("Enter the quantity you want to buy of the product: ");
            amount = this.scanner.nextInt();
            this.scanner.nextLine();
            product = this.inventory.getProductQuantity(id, amount);
            if (product != null) {
                this.shoppingCart.add(product);
            }
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Invalid input. Please enter a valid quantity." + RESET);
            this.scanner.nextLine();  // Clear the invalid input
        }
    }

    public void removeProductToShoppingCart() {
        String id;
        Product productDeleted;
        System.out.println("Enter the id of the product: ");
        id = this.scanner.nextLine();

        productDeleted = null;

        for (Product product : this.shoppingCart) {
            if (product.getId().equals(id)) {
                productDeleted = product;
            }
        }
        if (productDeleted != null) {
            this.shoppingCart.remove(productDeleted);
        }

    }

    public void modifyProductInShoppingCart() {
    String id;
    int newAmount;
    float newPriceCurrent;
    String priceInput;

    try {
        System.out.print("Enter the product ID to modify the quantity or price: ");
        id = this.scanner.nextLine();

        Product productToModify = null;
        for (Product product : shoppingCart) {
            if (product.getId().equals(id)) {
                productToModify = product;
                break;
            }
        }

        if (productToModify == null) {
            System.out.println(ERROR_COLOR + "Product not found in the shopping cart." + RESET);
            return;
        }

        System.out.print("Do you want to modify the quantity? (yes/no): ");
        String modifyQuantity = this.scanner.nextLine().trim().toLowerCase();

        if (modifyQuantity.equals("yes")) {
            System.out.print("Enter the new quantity: ");
            newAmount = this.scanner.nextInt();
            this.scanner.nextLine();

            productToModify.setAmount(newAmount);
        }

        System.out.print("Do you want to modify the price? (yes/no): ");
        String modifyPrice = this.scanner.nextLine().trim().toLowerCase();

        if (modifyPrice.equals("yes")) {
            System.out.print("Enter the new current price (Press enter if you don't want to change the price): ");
            priceInput = this.scanner.nextLine().trim();

            if (!priceInput.isEmpty()) {
                newPriceCurrent = Float.parseFloat(priceInput);
                productToModify.getPrice().setCurrent(newPriceCurrent);
            }
        }

        System.out.println(SUCCESS_COLOR + "Product updated successfully." + RESET);

    } catch (NumberFormatException e) {
        System.out.println(ERROR_COLOR + "Invalid price format." + RESET);
    } catch (Exception e) {
        System.out.println(ERROR_COLOR + "An unexpected error occurred: " + e.getMessage() + RESET);
    }
}


    public void generateVoucher() {
        String type;
        String id;
        String paymentMethod;

        System.out.println("Enter the id of the voucher: ");
        id = this.scanner.nextLine();

        if (this.vouchersRecord.findVoucherById(id) != null) {
            System.out.println(ERROR_COLOR + "Error: A voucher with this ID already exists." + RESET);
            return;
        }

        System.out.print("Enter the type of the voucher: ");
        type = this.scanner.nextLine();
        System.out.println("Enter the payment method: ");
        paymentMethod = this.scanner.nextLine();

        this.voucher = new Voucher(type, id, this.customer, this.supplier, paymentMethod, this.shoppingCart);
        System.out.printf(this.voucher.toString());
    }

    public void saveVoucher() {
        try {
            this.vouchersRecord.add(this.voucher);
            this.vouchersRecord.updateJsonFile();
            System.out.println(SUCCESS_COLOR + "Voucher saved successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "An error occurred while saving the voucher: " + e.getMessage() + RESET);
        }
    }

    public void modifyVoucher() {
        Voucher voucherModified = this.vouchersRecord.findVoucherById(this.voucher.getId());
        if (voucherModified == null) {
            System.out.println(ERROR_COLOR + "Voucher not found." + RESET);
            return;
        }

        boolean modification = true;
        String id;
        String type;
        Customer customer;
        Supplier supplier;
        String paymentMethod;
        ArrayList<Product> shoppingCart;

        id = voucherModified.getId();
        type = voucherModified.getType();
        customer = voucherModified.getCustomer();
        supplier = voucherModified.getSupplier();
        paymentMethod = voucherModified.getPaymentMethod();
        shoppingCart = voucherModified.getShoppingCart();

        while (modification) {
            this.displayModificationOptions();

            try {
                int option = this.getUserOption();

                switch (option) {
                    case 1:
                        type = getUpdatedType();
                        break;
                    case 2:
                        customer = this.addCustomer();
                        break;
                    case 3:
                        supplier = this.addSuplier();
                        break;
                    case 4:
                        paymentMethod = this.getUpdatedPaymentMethod();
                        break;
                    case 5:
                        modification = false;
                        break;
                    default:
                        System.out.println(ERROR_COLOR + "Please enter a valid option." + RESET);
                        break;
                }
            } catch (Exception e) {
                System.out.println(ERROR_COLOR + "Invalid input. Please enter a valid option." + RESET);
                this.scanner.nextLine();  // Clear invalid input
            }
        }

        voucherModified = new Voucher(id, type, customer, supplier, paymentMethod, shoppingCart);
        try {
            this.vouchersRecord.update(id, voucherModified);
            System.out.println(SUCCESS_COLOR + "Voucher updated successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "An error occurred while updating the voucher: " + e.getMessage() + RESET);
        }
    }

    public void displayModificationOptions() {
        System.out.println("What information do you want to modify about the voucher?");
        System.out.println("1. Type");
        System.out.println("2. Customer");
        System.out.println("3. Supplier");
        System.out.println("4. Payment Method");
        System.out.println("5. Do not modify more");
    }

    public int getUserOption() {
        System.out.print("Enter the number option: ");
        return this.scanner.nextInt();
    }

    private String getUpdatedType() {
        System.out.print("Enter the new type (or press Enter to keep current): ");
        return this.scanner.nextLine();
    }

    private String getUpdatedPaymentMethod() {
        System.out.print("Enter the new payment method (or press Enter to keep current): ");
        return this.scanner.nextLine();
    }

    private void sendVoucherToTransaction() {
        String id;
        String type;
        String paymentStatus;
        Transaction transaction;

        System.out.print("Enter the id of the transaction: ");
        id = this.scanner.nextLine();

        if (this.transactionsRecord.findTransactionById(id) != null) {
            System.out.println(ERROR_COLOR + "Error: A transaction with this ID already exists." + RESET);
            return;
        }

        type = this.supplier.getName().equals("Dulces Travesuras") ? "sale" : "purchase";

        System.out.print("Enter the payment status: ");
        paymentStatus = this.scanner.nextLine();

        transaction = new Transaction(id, type, this.voucher, paymentStatus);
        try {
            this.transactionsRecord.add(transaction);
            this.transactionsRecord.updateJsonFile();
            System.out.println(SUCCESS_COLOR + "Transaction processed successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "An error occurred while processing the transaction: " + e.getMessage() + RESET);
        }
    }

    private void validateCustomerType(String type) {
        switch (type.toLowerCase()) {
            case "retail":
            case "wholesale":
            case "distributor":
                break;
            default:
                throw new IllegalArgumentException("Valid customer types: retail, wholesale, and distributor.");
        }
    }
}
