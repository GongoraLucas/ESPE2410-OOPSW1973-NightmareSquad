package ec.edu.espe.accountingsystem.model;

import java.util.List;

/**
 *
 * @author Sebastian Charij
 */
public class Inventory {

    private List<Product> products;

    @Override
    public String toString() {
        return "Inventory{" + "products=" + products + '}';
    }

    public Inventory(List<Product> products) {
        this.products = products;
    }
    
    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
}
