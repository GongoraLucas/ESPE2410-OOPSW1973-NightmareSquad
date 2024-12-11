package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;
import utils.JsonFileManager;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 * @author David Cuichan
 */
public class Inventory {

    private JsonFileManager productsJson;
    private ArrayList<Product> products;

    @Override
    public String toString() {
        String horizontalLine;
        StringBuilder content;

        horizontalLine = "-------------------------------------------------------";
        content = new StringBuilder();

        content.append(horizontalLine);
        content.append(horizontalLine);
        content.append(String.format("\n| %12s | %12s | %30s | %12s | %12s | %12s |\n",
                "ID", "Reference", "Description", "Price", "Amount", "Measured Item"));

        for (Product product : getProducts()) {
            content.append(product.toString());
        }

        content.append(horizontalLine);
        content.append("\n");

        return content.toString();
    }

    public Inventory() {
        this.productsJson = new JsonFileManager("Products.json");
        this.products = this.productsJson.read(Product.class);
    }

    public void add(Product product) {
        this.productsJson.create(product, Product.class);
    }

    public void delete(String productId) {
        this.productsJson.delete(productId, Product.class);
    }

    public void update(String productId, Product product) {
        this.productsJson.update(productId, product, Product.class);

    }

    public void updateJsonFile() {
        this.products = this.productsJson.read(Product.class);
    }

    public void updateInventoryByTypeCustomer(String typeCustomer) {
    for (int i = 0; i < this.products.size(); i++) {
        Product product = this.products.get(i);
        try {
            product.getPrice().adjustCurrentPrice(typeCustomer);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valid price types: retail, wholesale and distributor");
        }
        this.products.set(i, product);
    }
}

    public Product findProductById(String productId) {
        for (Product product : this.products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public Product getProductQuantity(String productId, int amount) {

        Product selectedProduct;
        try {
            for (Product product : this.getProducts()) {
                if (product.getId().equals(productId)) {
                    if (amount > product.getAmount()) {
                        throw new Error("Exceeds the amount of the product");
                    }

                    product.setAmount(product.getAmount() - amount);
                    this.productsJson.update(productId, product, Product.class);
                    selectedProduct = product;
                    selectedProduct.setAmount(amount);
                    return selectedProduct;
                }
            }
            throw new Error("the product was not found");
        } catch (Error er) {
            System.out.println(er.getMessage());
            return null;
        }

    }

    public void addProductQuantity(String productId, int amount) {
        for (Product product : this.getProducts()) {
            if (product.getId().equals(productId)) {
                product.setAmount(product.getAmount() + amount);
                this.productsJson.update(productId, product, Product.class);
            }
        }

    }
    

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

}
