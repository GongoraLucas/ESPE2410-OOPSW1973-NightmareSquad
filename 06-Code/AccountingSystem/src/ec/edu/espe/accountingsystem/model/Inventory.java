package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;
import Utils.FileManagerInventory;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class Inventory {

    private ArrayList<Product> products;

    @Override
    public String toString() {
        return "Inventory{" + "products=" + products + '}';
    }
    
    public Inventory(ArrayList<Product> products) {
        this.products = products;
    }

    public void add(Product product) {
        boolean newProduct = products.add(product);
        if (newProduct) {
            System.out.println("the product has been added successfully");
        }
    }

    public Product searchById(String productId) {

        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        throw new Error("The product was not found");
    }

    public void delete(String productId) {
        this.products.remove(this.searchById(productId));
    }

    public void update(String productId) {
        //TODO algorithm

    }
    
    public Product getProductQuantity(String productId,int amount){
        Product selectedProduct;
        for (Product product : this.products) {
            if (product.getId().equals(productId)) {
                product.setAmount(product.getAmount()-amount);
                selectedProduct=product;
                selectedProduct.setAmount(amount);
                return selectedProduct;
            }
        }
        throw new Error("the product was not found");
        
    }
    public void addProductQuantity(String productId,int amount){
        for (Product product : this.products) {
            if (product.getId().equals(productId)) {
                product.setAmount(product.getAmount()+amount);
            }
        }
        
    }
    

    public void viewProductsForConsole() {
        System.out.printf("%-10s %-20s %-10s %-8s %-30s %-15s\n", "ID", "Reference", "Description", "Price", "Amount", "Measured Item");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Product product : this.products) {
            System.out.printf("%-10s %-20s %-10s %-8.2f %-30d %-15s\n",
                    product.getId(), product.getReference(),
                    product.getDescription(), product.getPrice().getCurrent(),
                    product.getAmount(), product.getMeasuredItem().getDescription());
        }

    }

    public void viewOnlyProductForConsole(String productId) {
        System.out.printf("%-10s %-20s %-10s %-8s %-30s %-15s\n", "ID", "Reference", "Description", "Price", "Amount", "Measured Item");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Product selectedProduct = this.searchById(productId);

        System.out.printf("%-10s %-20s %-10.2f %-8d %-30s %-15s\n",
                selectedProduct.getId(), selectedProduct.getReference(),
                selectedProduct.getDescription(), selectedProduct.getPrice().getCurrent(),
                selectedProduct.getAmount(), selectedProduct.getMeasuredItem().getDescription());

    }

    public String readProductsForCSV() {
        String viewProducts;

        viewProducts = "";

        for (int i = 0; i < this.products.size(); i++) {
            viewProducts += products.get(i).toString() + "\n";
        }
        return viewProducts;
    }
    
    public void saveInventory(Inventory inventory) {
        FileManagerInventory fileManager = new FileManagerInventory();
        fileManager.saveInventory(inventory);
    }

    public static Inventory loadInventory() {
        FileManagerInventory fileManager = new FileManagerInventory();
        return fileManager.loadInventory();
    }
}
