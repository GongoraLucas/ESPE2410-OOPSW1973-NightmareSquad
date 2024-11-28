package ec.edu.espe.accountingsystem.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Sebastian Charij
 */
public class Voucher {

    private String type;
    private int id;
    private Date issueDate;
    private List<Product> products;
    private Client client;
    private float VAT;

    @Override
    public String toString() {
        return "Voucher{" + "type=" + type + ", id=" + id + 
               ", issueDate=" + issueDate + ", products=" + products + 
               ", client=" + client + ", VAT=" + VAT + '}';
    }

    public Voucher(String type, int id, Date issueDate, List<Product> products, Client client, float VAT) {
        this.type = type;
        this.id = id;
        this.issueDate = issueDate;
        this.products = products;
        this.client = client;
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
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
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

    
        
    }
