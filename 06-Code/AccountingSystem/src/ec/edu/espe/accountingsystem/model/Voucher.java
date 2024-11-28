package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 */
public class Voucher {

    private String type;
    private int id;
    private Date issueDate;
    private ArrayList<Product> products;
    private Client client;
    private Supplier supplier;
    private float VAT;

    @Override
    public String toString() {
        return "Voucher{" + "type=" + type + ", id=" + id + ", issueDate=" + issueDate + ", products=" + products + ", client=" + client + ", supplier=" + supplier + ", VAT=" + VAT + '}';
    }



    public Voucher(String type, int id, Date issueDate, ArrayList<Product> products, Client client, Supplier supplier, float VAT) {
        this.type = type;
        this.id = id;
        this.issueDate = issueDate;
        this.products = products;
        this.client = client;
        this.supplier = supplier;
        this.VAT = VAT;
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
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
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

    public float calculateVAT(){
        //TODO algorithm
        return 0.0f;
    }
    
    public float calculateSubtotal(){
        //TODO algorithm
        return 0.0f;
    }
    
    public float calculateTotal(){
        //TODO algortithm
        return 0.0f;
    }
    
    public void generateVoucher(){
        //TODO algorithm
    }
    
    public void sendVoucher(){
        //TODO algorithm
    }
    
    public void addProduct(Product product){
        //TODO algorithm
    }
    
    public void deleteProduct(String productId){
        //TODO algorithm
    }
    
    
        
    }
