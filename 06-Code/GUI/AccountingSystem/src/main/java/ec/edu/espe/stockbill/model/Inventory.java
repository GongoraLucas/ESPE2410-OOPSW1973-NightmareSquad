package ec.edu.espe.stockbill.model;

import java.util.ArrayList;


/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 * @author David Cuichan
 */
public class Inventory extends Record {

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

    public boolean add(Product product) {
       return super.getDatabase().insertData(collection, product);
    }

    public boolean delete(String productId) {
       return super.getDatabase().deleteData(collection, productId);
    }

    public boolean update(String productId, Product product) {
        return super.getDatabase().updateData(collection, productId, product);

    }


    public ArrayList<Product> updateInventoryByTypeCustomer(String typeCustomer) {
        ArrayList<Product> inventoryByTypeCustomer;
        inventoryByTypeCustomer = new ArrayList<>();
        for (int i = 0; i < this.getProducts().size(); i++) {
            Product product = this.getProducts().get(i);
            try {
                product.getPrice().adjustCurrentPrice(typeCustomer);
                inventoryByTypeCustomer.add(product);
            
               
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Valid price types: retail, wholesale and distributor");
            }
      
        }
        return inventoryByTypeCustomer;
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
