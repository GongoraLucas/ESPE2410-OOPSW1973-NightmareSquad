
package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lucas Gongora
 */
public class PurchaseMenu extends Menu {

    private SuppliersRecord suppliersRecord;
    private CustomersRecord customersRecord;
    private Inventory inventory;
    private ArrayList<Product> shoppingCart;
    private VouchersRecord vouchersRecord;
    private Voucher voucher;
    private TransactionsRecord transactionsRecord;

    public PurchaseMenu(SuppliersRecord suppliersRecord, CustomersRecord customersRecord, Inventory inventory, ArrayList<Product> shoppingCart, VouchersRecord vouchersRecord, Voucher voucher, TransactionsRecord transactionsRecord) {
        this.suppliersRecord = suppliersRecord;
        this.customersRecord = customersRecord;
        this.inventory = inventory;
        this.shoppingCart = shoppingCart;
        this.vouchersRecord = vouchersRecord;
        this.voucher = voucher;
        this.transactionsRecord = transactionsRecord;
    }

    @Override
    public String toString() {
        return "PurchaseMenu{" + "suppliersRecord=" + suppliersRecord + ", customersRecord=" + customersRecord + ", inventory=" + inventory + ", shoppingCart=" + shoppingCart + ", vouchersRecord=" + vouchersRecord + ", voucher=" + voucher + ", transactionsRecord=" + transactionsRecord + '}';
    }
    
    

    public SuppliersRecord getSuppliersRecord() {
        return suppliersRecord;
    }

    public void setSuppliersRecord(SuppliersRecord suppliersRecord) {
        this.suppliersRecord = suppliersRecord;
    }

    public CustomersRecord getCustomersRecord() {
        return customersRecord;
    }

    public void setCustomersRecord(CustomersRecord customersRecord) {
        this.customersRecord = customersRecord;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public VouchersRecord getVouchersRecord() {
        return vouchersRecord;
    }

    public void setVouchersRecord(VouchersRecord vouchersRecord) {
        this.vouchersRecord = vouchersRecord;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public TransactionsRecord getTransactionsRecord() {
        return transactionsRecord;
    }

    public void setTransactionsRecord(TransactionsRecord transactionsRecord) {
        this.transactionsRecord = transactionsRecord;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    
    

    // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow

    public PurchaseMenu() {
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
        System.out.println(SUBHEADER_COLOR + "Purchase" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Add new  product to Inventory " + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Add an existing product to Inventory" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Remove product to shopping cart" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Modify product in shopping cart" + RESET);
        System.out.println(MENU_OPTION_COLOR + "5. Generate Voucher" + RESET);
        System.out.println(MENU_OPTION_COLOR + "6. Save Voucher" + RESET);
        System.out.println(MENU_OPTION_COLOR + "7. Send Voucher to Transactions Record" + RESET);
        System.out.println(MENU_OPTION_COLOR + "8. Back to the main menu" + RESET);

        System.out.print("Enter the number option: ");
    }

    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                this.addNewProductToInventary();
                break;
            case 2:
                this.addAnExistingProductToInventary();
                break;
            case 3:
                this.removeProductToShoppingCart();
                break;
            case 4:
                this.modifyProductInShoppingCart();
                break;
            case 5:
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

    private void addAnExistingProductToInventary() {
        String id;
        int amount;
        Product product;
        Product productToVoucher;

        System.out.print("Enter the id of the product: ");
        id = super.getScanner().nextLine();

        try {
            System.out.print("Enter the quantity you want to buy of the product: ");
            amount = super.getScanner().nextInt();
            super.getScanner().nextLine();
            product = this.inventory.findProductById(id);
            if (product != null) {
                this.inventory.addProductQuantity(id, amount);
                productToVoucher = new Product(product.getId(), product.getReference(), product.getDescription(), product.getPrice(), amount, product.getMeasuredItem());
                this.shoppingCart.add(productToVoucher);
            }
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Invalid input. Please enter a valid quantity." + RESET);
            super.getScanner().nextLine();
        }
    }

    private void addNewProductToInventary() {
        String id;
        String reference;
        String description;
        int amount;
        Price price = null;
        MeasuredItem measuredItem = null;
        Product product = null;

        try {
            System.out.print("Enter the id: ");
            id = super.getScanner().nextLine();

            if (this.inventory.findProductById(id) != null) {
                System.out.println(ERROR_COLOR + "Error: A product with the same id already exists." + RESET);
                return;
            }

            System.out.print("Enter the reference: ");
            reference = super.getScanner().nextLine();

            System.out.print("Enter the description: ");
            description = super.getScanner().nextLine();

            System.out.print("Enter the amount: ");
            amount = super.getScanner().nextInt();
            super.getScanner().nextLine();

            price = addPrice();
            measuredItem = addMeasuredItem();

            product = new Product(id, reference, description, price, amount, measuredItem);
            this.inventory.add(product);
            this.shoppingCart.add(product);
            this.inventory.updateJsonFile();
            System.out.println(SUCCESS_COLOR + "Product added successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error occurred while adding product: " + e.getMessage() + RESET);
        }
    }

    private Price addPrice() {
        float retail;
        float wholesale;
        float distributor;

        try {
            System.out.println("Enter the data for the price");
            System.out.print("Enter the retail price: ");
            retail = super.getScanner().nextFloat();
            super.getScanner().nextLine();

            System.out.print("Enter the wholesale price: ");
            wholesale = super.getScanner().nextFloat();
            super.getScanner().nextLine();

            System.out.print("Enter the distributor price: ");
            distributor = super.getScanner().nextFloat();
            super.getScanner().nextLine();

            return new Price(retail, wholesale, distributor);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error adding price: " + e.getMessage() + RESET);
            return null;
        }
    }

    private MeasuredItem addMeasuredItem() {
        String description;
        float quantity;
        String unit;

        try {
            System.out.println("Enter the data for the measured item");
            System.out.print("Enter the description of the measured item: ");
            description = super.getScanner().nextLine();
            System.out.print("Enter the quantity of the measured item:");
            quantity = super.getScanner().nextFloat();
            super.getScanner().nextLine();
            System.out.print("Enter the unit of the measured item:");
            unit = super.getScanner().nextLine();

            return new MeasuredItem(description, quantity, unit);

        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error adding measured item: " + e.getMessage() + RESET);

            return null;
        }
    }

    private void removeProductToShoppingCart() {
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
            this.inventory.removeProductQuantity(productDeleted.getId(), productDeleted.getAmount());
            this.shoppingCart.remove(productDeleted);
        }

    }

    private void modifyProductInShoppingCart() {
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

    private void generateVoucher() {
        String type;
        String id;
        String paymentMethod;
        String supplierId;
        Supplier supplier;
        Customer customer;

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
        supplierId = super.getScanner().nextLine();
        supplier = suppliersRecord.findSupplierById(supplierId);

        if (supplier == null) {
            System.out.println("The supplier was not found");
            return;
        }
        customer = customersRecord.findCustomerById("0");
        if (customer == null) {
            System.out.println("enter business data into customers");
            return;
        }

        this.voucher = new Voucher(type, id, customer, supplier, paymentMethod, this.shoppingCart,0.15f);
        System.out.printf(this.voucher.toString());
    }

    private void saveVoucher() {
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

        type = "purchase";

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
