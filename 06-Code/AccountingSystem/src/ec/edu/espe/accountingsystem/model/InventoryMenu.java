package ec.edu.espe.accountingsystem.model;


import Utils.JsonFileManager;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Lucas Gongora
 */
public class InventoryMenu {

    private Scanner scanner;
    private int option;
    private boolean executionMenu;
    private String fileName;
    private JsonFileManager jsonFile;

    public InventoryMenu() {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
        this.option = 0;
        this.executionMenu = true;
        this.fileName = "Products.json";
        this.jsonFile = new JsonFileManager(this.fileName);
    }

    public void runMenu() {
        do {
            System.out.println("\tAccounting System\t");
            System.out.println("Inventory Menu");
            System.out.println("1. Add product");
            System.out.println("2. View products");
            System.out.println("3. Update product");
            System.out.println("4. Delete product");
            System.out.println("5. Back to the main menu");

            System.out.print("Enter the number option: ");
            this.option = this.scanner.nextInt();
            this.scanner.nextLine();
           


            switch (this.option) {

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
                    this.executionMenu = false;
                 
                    break;
                default:
                    System.out.println("Enter the correct option");

            }
        } while (this.executionMenu);
    }

    public void addProduct() {
        String id;
        String reference;
        String description;
        int amount;
        Price price;
        MeasuredItem measuredItem;
        Product product;

        System.out.print("Enter the id: ");
        id = this.scanner.nextLine();
        System.out.print("Enter the reference: ");
        reference = this.scanner.nextLine();
        System.out.print("Enter the description: ");
        description = this.scanner.nextLine();
        System.out.print("Enter the amount: ");
        amount = this.scanner.nextInt();
        price = this.addPrice();
        measuredItem = this.addMeasuredItem();

        product = new Product(id, reference, description, price, amount, measuredItem);

        this.jsonFile.create(product, Product.class);
        
        

    }

    public void viewProducts() {
        Inventory inventory;
        inventory = new Inventory(this.jsonFile.read(Product.class));
        System.out.printf(inventory.toString());

    }

    public void updateProduct() {

        String id;
        String reference;
        String description;
        int amount;
        Price price;
        MeasuredItem measuredItem;
        Product product;

        System.out.print("Enter the id of the product: ");
        id = this.scanner.nextLine();
        System.out.print("Enter the reference: ");
        reference = this.scanner.nextLine();
        System.out.print("Enter the description: ");
        description = this.scanner.nextLine();
        System.out.print("Enter the amount: ");
        amount = this.scanner.nextInt();
        this.scanner.nextLine();
        price = this.addPrice();
        measuredItem = this.addMeasuredItem();

        product = new Product(id, reference, description, price, amount, measuredItem);

        this.jsonFile.update(id, product, Product.class);

    }

    public void deleteProduct() {
        String id;

        System.out.print("Enter the id of the product: ");
        id = this.scanner.nextLine();

        this.jsonFile.delete(id, Product.class);
    }

    public Price addPrice() {
        float retail;
        float wholesale;
        float distributor;

        System.out.println("Enter the data for the price");
        System.out.print("Enter the retail price: ");
        retail = this.scanner.nextFloat();
        this.scanner.nextLine();
        System.out.print("Enter the wholesale price: ");
        wholesale = this.scanner.nextFloat();
        this.scanner.nextLine();
        System.out.print("Enter the distributor price: ");
        distributor = this.scanner.nextFloat();
        this.scanner.nextLine();

        return new Price(retail, wholesale, distributor);
    }

    public MeasuredItem addMeasuredItem() {
        String description;
        float quantity;
        String unit;

        System.out.println("Enter the data for the measured item");
        System.out.print("Enter the description of the measured item: ");
        description = this.scanner.nextLine();
        System.out.print("Enter the quantity of the measured item:");
        quantity = this.scanner.nextFloat();
        this.scanner.nextLine();
        System.out.print("Enter the unit of the measured item:");
        unit = this.scanner.nextLine();

        return new MeasuredItem(description, quantity, unit);

    }

}
