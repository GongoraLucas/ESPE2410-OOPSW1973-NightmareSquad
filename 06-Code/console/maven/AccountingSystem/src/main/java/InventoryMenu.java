
package ec.edu.espe.accountingsystem.<deafultpackage>;

import ec.edu.espe.accountingsystem.model.Inventory;
import ec.edu.espe.accountingsystem.model.MeasuredItem;
import ec.edu.espe.accountingsystem.model.Menu;
import static javax.swing.text.html.FormView.RESET;
import java.util.Scanner;


public class InventoryMenu extends Menu {

    private Inventory inventory;

    // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow

    Scanner sc = new Scanner (System.in);


    public InventoryMenu() {
        super();
        this.inventory = new Inventory();
    }

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\n\tAccounting System\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Inventory Menu" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Add product" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. View products" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Update product" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Delete product" + RESET);
        System.out.println(MENU_OPTION_COLOR + "5. Back to the main menu" + RESET);
    

        System.out.println("Enter de amount to buy:  ");
        int amount = scanner.nextInt();
        
        this.inventory.addProductQuantity();
}    
        
    }
    public void sellProduct(){
        System.out.println("Enter de ID of product to buy: ");
        String id = scanner.nextLine();
   
        
        System.out.println("Enter de amount to buy:  ");
        int amount = scanner.nextInt();
        amount*=-1;
        
        this.inventory.addProductQuantity(id,amount);

    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                addProduct();
                break;
            case 2:
                viewProducts();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                super.setExecutionMenu(false);
                break;
            default:
                throw new IllegalArgumentException("Option must be between 1 and 7.");
        }

}

    public void addProduct() {
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
            this.inventory.updateJsonFile();
            System.out.println(SUCCESS_COLOR + "Product added successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error occurred while adding product: " + e.getMessage() + RESET);
        }
    }

    public void viewProducts() {
        try {
            System.out.printf(this.inventory.toString());
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error viewing products: " + e.getMessage() + RESET);
        }
    }

    public void updateProduct() {
        String productId;
        Product product;
        boolean modification = true;

        try {
            System.out.print("Enter the id of the product: ");
            productId = super.getScanner().nextLine();

            product = inventory.findProductById(productId);
            if (product == null) {
                System.out.println(ERROR_COLOR + "Product not found." + RESET);
                return;
            }

            String reference = product.getReference();
            String description = product.getDescription();
            Price price = product.getPrice();
            int amount = product.getAmount();
            MeasuredItem measuredItem = product.getMeasuredItem();

            while (modification) {
                displayModificationOptions();

                int option = super.getUserInput();

                switch (option) {
                    case 1:
                        reference = getUpdatedReference();
                        break;
                    case 2:
                        description = getUpdatedDescription();
                        break;
                    case 3:
                        price = getUpdatedPrice();
                        break;
                    case 4:
                        amount = getUpdatedAmount();
                        break;
                    case 5:
                        measuredItem = getUpdatedMeasuredItem();
                        break;
                    case 6:
                        modification = false;
                        break;
                    default:
                        System.out.println(ERROR_COLOR + "Please enter a valid option." + RESET);
                        break;
                }
            }

            product = new Product(productId, reference, description, price, amount, measuredItem);
            inventory.update(productId, product);
            inventory.updateJsonFile();
            System.out.println(SUCCESS_COLOR + "Product updated successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error updating product: " + e.getMessage() + RESET);
        }
    }

    public void deleteProduct() {
        String id;

        try {
            System.out.print("Enter the id of the product: ");
            id = super.getScanner().nextLine();

            this.inventory.delete(id);
            this.inventory.updateJsonFile();
            System.out.println(SUCCESS_COLOR + "Product deleted successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error deleting product: " + e.getMessage() + RESET);
        }
    }

    private void displayModificationOptions() {
        System.out.println("What information do you want to modify about the product?");
        System.out.println("1. Reference");
        System.out.println("2. Description");
        System.out.println("3. Price");
        System.out.println("4. Amount");
        System.out.println("5. Measured item");
        System.out.println("6. Do not modify more");
    }

    private String getUpdatedReference() {
        System.out.print("Enter the new reference (or press Enter to keep current): ");
        String reference = super.getScanner().nextLine();
        return reference.isEmpty() ? null : reference;
    }

    private String getUpdatedDescription() {
        System.out.print("Enter the new description (or press Enter to keep current): ");
        String description = super.getScanner().nextLine();
        return description.isEmpty() ? null : description;
    }

    private Price getUpdatedPrice() {
        Price price = null;
        try {
            System.out.println("Enter the new price (or press Enter to keep current): ");
            price = this.addPrice();
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error updating price: " + e.getMessage() + RESET);
        }
        return price;
    }

    private int getUpdatedAmount() {
        System.out.print("Enter the new amount (or press Enter to keep current): ");
        int amount = -1;
        try {
            String input = super.getScanner().nextLine();
            amount = input.isEmpty() ? -1 : Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_COLOR + "Invalid amount input. Please enter a valid number." + RESET);
        }
        return amount;
    }

    private MeasuredItem getUpdatedMeasuredItem() {
        MeasuredItem measuredItem = null;
        try {
            System.out.println("Enter the new measured item (or press Enter to keep current): ");
            measuredItem = this.addMeasuredItem();
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error updating measured item: " + e.getMessage() + RESET);
        }
        return measuredItem;
    }

    public Price addPrice() {
        float retail;
        float wholesale;
        float distributor;
        while (true) {
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
            }

        }

    }

    public MeasuredItem addMeasuredItem() {
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
            String ERROR_COLOR;
            int ERROR_COLOR;
            System.out.println(ERROR_COLOR + "Error adding measured item: " + e.getMessage() + RESET);

            return null;
        }
    }
