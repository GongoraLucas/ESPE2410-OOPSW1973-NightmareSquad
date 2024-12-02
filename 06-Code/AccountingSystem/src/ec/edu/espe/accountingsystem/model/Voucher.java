package ec.edu.espe.accountingsystem.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class Voucher {

    private String type;
    private int id;
    private Date issueDate;
    private ArrayList<Product> shoppingCart;
    private Client client;
    private Supplier supplier;
    private float VAT;
    private float subtotal;
    private float valueWithVAT;
    private float total;
    private String paymentMethod;

    @Override
    public String toString() {
        return "Voucher{" + "type=" + type + ", id=" + id + ", issueDate=" + issueDate + ", shoppingCart=" + shoppingCart + ", client=" + client + ", supplier=" + supplier + ", VAT=" + VAT + ", subtotal=" + subtotal + ", valueWithVAT=" + valueWithVAT + ", total=" + getTotal() + ", paymentMethod=" + getPaymentMethod() + '}';
    }
    

    

    public Voucher(String type, int id, Date issueDate, ArrayList<Product> products, Client client, Supplier supplier, float VAT,String paymentMethod) {
        this.type = type;
        this.id = id;
        this.issueDate = issueDate;
        this.shoppingCart = products;
        this.client = client;
        this.supplier = supplier;
        this.VAT = VAT;
        this.subtotal = this.calculateSubtotal();
        this.valueWithVAT = this.calculateVAT();
        this.total = this.calculateTotal();
        this.paymentMethod=paymentMethod;
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
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
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

        valueWithVAT = subtotal * VAT;

        return valueWithVAT;
    }

    public float calculateTotal() {

        return this.subtotal + this.valueWithVAT;
    }

    public void generateVoucher() {
        //TODO algorithm
    }

    public void sendVoucher() {
        //TODO algorithm
    }

    public void addToShoppingCart(Inventory inventory, String productId, int amount) {

        this.shoppingCart.add(inventory.getProductQuantity(productId, amount));
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

    public void generateVoucherForConsole() {
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("===========================================");
        System.out.println("               VOUCHER");
        System.out.println("===========================================");
        System.out.printf("%-20s: %s%n", "Supplier", this.supplier.getName());
        System.out.printf("%-20s: %s%n", "Client", this.client.getName());
        System.out.printf("%-20s: %s%n", "Issue Date", this.issueDate);
        System.out.printf("%-20s: %s%n", "Id", id);
        System.out.printf("%-20s: %s%n", "Type", this.type);
        System.out.printf("%-20s: %s%n", "Payment method", this.paymentMethod);
        System.out.println("-------------------------------------------");


        System.out.printf("%-30s %-10s %-10s %-10s%n", "Producto", "Cantidad", "Precio", "Total");
        System.out.println("-------------------------------------------");
        for (Product product : this.shoppingCart) {
            System.out.printf("%-30s %-10d %-10s %-10s%n", product.getDescription(), product.getAmount(),
                    "$" + df.format(product.getPrice().getCurrent()), "$" + df.format(product.calculateTotalPrice()));
        }


        System.out.println("-------------------------------------------");
        System.out.printf("%-40s: $%s%n", "Subtotal", df.format(this.subtotal));
        System.out.printf("%-40s: $%s%n", "Total", df.format(this.total));
        System.out.println("===========================================");

    }



    

}
