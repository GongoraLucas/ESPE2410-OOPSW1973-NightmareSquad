package ec.edu.espe.accountingsystem.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import utils.Identifiable;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class Voucher implements Identifiable {

    private String type;
    private String id;
    private Date issueDate;
    private ArrayList<Product> shoppingCart;
    private Customer client;
    private Supplier supplier;
    private float  VAT;
    private float subtotal;
    private float valueWithVAT;
    private float total;
    private String paymentMethod;

    
    
    @Override
    public String toString() {
        
        StringBuilder content;
        
        content = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");

        content.append("===========================================\n");
        content.append("               VOUCHER\n");
        content.append("===========================================\n");
        content.append(String.format("%-20s: %s%n", "Supplier", this.supplier.getName()));
        content.append(String.format("%-20s: %s%n", "Client", this.client.getName()));
        content.append(String.format("%-20s: %s%n", "Issue Date", this.issueDate));
        content.append(String.format("%-20s: %s%n", "Id", id));
        content.append(String.format("%-20s: %s%n", "Type", this.type));
        content.append(String.format("%-20s: %s%n", "Payment method", this.paymentMethod));
        content.append("-------------------------------------------\n");


        content.append(String.format("%n%-30s %-10s %-10s %-10s%n", "Producto", "Cantidad", "Precio", "Total"));
        content.append("-------------------------------------------\n");
        for (Product product : this.shoppingCart) {
            content.append(String.format("%-30s %-10d %-10s %-10s%n", product.getDescription(), product.getAmount(),
                    "$" + df.format(product.getPrice().getCurrent()), "$" + df.format(product.calculateTotalPrice())));
        }


        content.append("-------------------------------------------\n");
        content.append(String.format("%-40s: $%s%n", "Subtotal", df.format(this.getSubtotal())));
        content.append(String.format("%-40s: $%s%n", "Total", df.format(this.getTotal())));
        content.append("===========================================");
        
        return content.toString();
    }
    

    

    public Voucher(String type, String id, Customer client, Supplier supplier,String paymentMethod, ArrayList<Product> shoppingCart,float vat) {
        this.type = type;
        this.id = id;
        this.shoppingCart = shoppingCart;
        this.client = client;
        this.supplier = supplier;
        this.paymentMethod=paymentMethod;
        this.VAT = vat;
        this.issueDate = new Date();
        this.subtotal = this.calculateSubtotal();
        this.valueWithVAT = this.calculateVAT();
        this.total = this.calculateTotal();
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the issueDate
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate the issueDate to set
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the products
     */
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * @param shoppingCart the products to set
     */
    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * @return the client
     */
    public Customer getCustomer() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Customer client) {
        this.client = client;
    }

    /**
     * @return the VAT
     */
    public float getVAT() {
        return VAT;
    }

    /**
     * @param VAT the VAT to set
     */
    public void setVAT(float VAT) {
        this.VAT = VAT;
    }

    /**
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

        /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }
    
        /**
     * @return the subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * @return the valueWithVAT
     */
    public float getValueWithVAT() {
        return valueWithVAT;
    }
    
    
    public float calculateSubtotal() {
        float subTotal;

        subTotal = 0.0f;

        for (Product product : this.shoppingCart) {
            subTotal += product.calculateTotalPrice();
        }
        return subTotal;
    }

    public float calculateVAT() {
        float valueWithVAT;

        valueWithVAT = getSubtotal() * VAT;

        return valueWithVAT;
    }

    public float calculateTotal() {

        return this.getSubtotal() + this.getValueWithVAT();
    }


    public void addToShoppingCart(Inventory inventory, String productId, int amount) {

        this.shoppingCart.add(inventory.removeProductQuantity(productId, amount));
    }

    public void deleteToShoppingCart(Inventory inventory, String productId) {

        for (Product product : this.shoppingCart) {

            if (product.getId().equals(productId)) {

                this.shoppingCart.remove(product);

                inventory.addProductQuantity(productId, product.getAmount());
                return;

            }
        }
        throw new Error("the product was not found");

    }


    
    

    



    

}
