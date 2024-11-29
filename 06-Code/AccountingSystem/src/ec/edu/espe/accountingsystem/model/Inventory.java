package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;

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
    
    public void add(Product product){
        products.add(product);
    }
    
    public void delete(String productId){
        //TODO algorithm
    }
    
    public void update(String productId){
        //TODO algorithm
    }
    public void read (String productID){
        //TODO algorithm
    }

    
    
}
