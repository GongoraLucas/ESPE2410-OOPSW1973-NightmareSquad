package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.controller.DAO;
import java.util.ArrayList;


/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 * @author David Cuichan
 */
public class Inventory extends DAO {

    private static String collection = "inventory";

    

    public Inventory() {
        super();
    }

    /**
     * @return the products
     */
    public ArrayList<Product> getProducts() {
        return super.getDatabase().readAllData(collection, Product.class);
    }

    public void add(Product product) {
       super.getDatabase().insertData(collection, product);
    }

    public void delete(String productId) {
       super.getDatabase().deleteData(collection, productId);
    }

    public void update(String productId, Product product) {
        super.getDatabase().updateData(collection, productId, product);

    }


    public void updateInventoryByTypeCustomer(String typeCustomer) {
 
        for (int i = 0; i < this.getProducts().size(); i++) {
            Product product = this.getProducts().get(i);
            try {
                product.getPrice().adjustCurrentPrice(typeCustomer);
                super.getDatabase().updateData(collection, product.getId(), product);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Valid price types: retail, wholesale and distributor");
            }
      
        }
    }

    public Product findProductById(String productId) {
        
        for (Product product : this.getProducts()) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public Product removeProductQuantity(String productId, int amount) {

        Product selectedProduct;
        try {
            for (Product product : this.getProducts()) {
                if (product.getId().equals(productId)) {
                    if (amount > product.getAmount()) {
                        throw new Error("Exceeds the amount of the product");
                    }

                    product.setAmount(product.getAmount() - amount);
                    super.getDatabase().updateData(collection, productId, product);
                    selectedProduct = product;
                    selectedProduct.setAmount(amount);
                    return selectedProduct;
                }
            }
            throw new IllegalArgumentException("the product was not found");
        } catch (IllegalArgumentException er) {
            System.out.println(er.getMessage());
            return null;
        }

    }

    public void addProductQuantity(String productId, int amount) {
        for (Product product : this.getProducts()) {
            if (product.getId().equals(productId)) {
                product.setAmount(product.getAmount() + amount);
                super.getDatabase().updateData(collection, productId, product);
            }
        }

    }

}
