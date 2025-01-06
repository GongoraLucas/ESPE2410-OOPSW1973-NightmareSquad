package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;

public class SaleMenu extends Menu {

    private SuppliersRecord suppliersRecord;
    private CustomersRecord customersRecord;
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

    public SaleMenu() {
        super();
        this.inventory = new Inventory();
        this.shoppingCart = new ArrayList<>();
        this.vouchersRecord = vouchersRecord;
        this.transactionsRecord = new TransactionsRecord();
        this.suppliersRecord = new SuppliersRecord("suppliers.json");
        this.customersRecord = new CustomersRecord("customers.json");
    }

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\n\t Accounting system \t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Voucher" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Add product to shopping cart" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Remove product to shopping cart" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Modify product in shopping cart" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Generate Voucher" + RESET);
        System.out.println(MENU_OPTION_COLOR + "5. Save Voucher" + RESET);
        System.out.println(MENU_OPTION_COLOR + "6. Send Voucher to Transactions Record" + RESET);
        System.out.println(MENU_OPTION_COLOR + "7. Back to the main menu" + RESET);
    }

    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
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
            case 6:
                this.saveVoucher();
                break;
            case 7:
                this.sendVoucherToTransaction();
                break;
            case 8:
                super.setExecutionMenu(false);
                break;
            default:
                throw new IllegalArgumentException("Option must be between 1 and 8.");
        }
    }

    public void addProductToShoppingCart() {
        String id;
        int amount;
        Product product;

        System.out.print("Enter the id of the product: ");
        id = super.getScanner().nextLine();

        try {
            System.out.print("Enter the quantity you want to buy of the product: ");
            amount = super.getScanner().nextInt();
            super.getScanner().nextLine();
            
            product = this.inventory.removeProductQuantity(id, amount);
            if (product != null) {
                this.shoppingCart.add(product);
            }
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Invalid input. Please enter a valid quantity." + RESET);
            super.getScanner().nextLine();
        }
    }

    public void removeProductToShoppingCart() {
        String id;
        Product productDeleted;
        System.out.println("Enter the id of the product: ");
        id = super.getScanner().nextLine();

        productDeleted = null;

        for (Product product : this.shoppingCart) {
            if (product.getId().equals(id)) {
                productDeleted = product;

            }
        }
        if (productDeleted != null) {
            this.inventory.addProductQuantity(productDeleted.getId(), productDeleted.getAmount());
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
            id = super.getScanner().nextLine();

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
            String modifyQuantity = super.getScanner().nextLine().trim().toLowerCase();

            if (modifyQuantity.equals("yes")) {
                System.out.print("Enter the new quantity: ");
                newAmount = super.getScanner().nextInt();
                super.getScanner().nextLine();

                productToModify.setAmount(newAmount);
            }

            System.out.print("Do you want to modify the price? (yes/no): ");
            String modifyPrice = super.getScanner().nextLine().trim().toLowerCase();

            if (modifyPrice.equals("yes")) {
                System.out.print("Enter the new current price (Press enter if you don't want to change the price): ");
                priceInput = super.getScanner().nextLine().trim();

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
        String customerId;
        Customer customer;
        Supplier supplier;

        System.out.println("Enter the id of the voucher: ");
        id = super.getScanner().nextLine();

        if (this.vouchersRecord.findVoucherById(id) != null) {
            System.out.println(ERROR_COLOR + "Error: A voucher with this ID already exists." + RESET);
            return;
        }

        System.out.print("Enter the type of the voucher: ");
        type = super.getScanner().nextLine();
        System.out.println("Enter the payment method: ");
        paymentMethod = super.getScanner().nextLine();
        System.out.println("Enter the id of the customer: ");
        customerId = super.getScanner().nextLine();
        customer = customersRecord.findCustomerById(customerId);

        if (customer == null) {
            System.out.println("The customer was not found");
            return;
        }
        supplier = suppliersRecord.findSupplierById("0");
        if (supplier == null){
            System.out.println("enter business data into suppliers");
            return;
        }
  
        this.voucher = new Voucher(type, id, customer, supplier, paymentMethod, this.shoppingCart);
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

    private void sendVoucherToTransaction() {
        String id;
        String type;
        String paymentStatus;
        Transaction transaction;

        System.out.print("Enter the id of the transaction: ");
        id = super.getScanner().nextLine();

        if (this.transactionsRecord.findTransactionById(id) != null) {
            System.out.println(ERROR_COLOR + "Error: A transaction with this ID already exists." + RESET);
            return;
        }

        type = "sale";

        System.out.print("Enter the payment status: ");
        paymentStatus = super.getScanner().nextLine();

        transaction = new Transaction(id, type, this.voucher, paymentStatus);
        try {
            this.transactionsRecord.add(transaction);
            System.out.println(SUCCESS_COLOR + "Transaction processed successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "An error occurred while processing the transaction: " + e.getMessage() + RESET);
        }
    }

}
