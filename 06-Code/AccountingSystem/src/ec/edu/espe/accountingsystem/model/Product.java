package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 */

public class Product {
    
    private int id;
    private String reference;
    private String description; 
    private Price price;
    private int amount;
    private String unit;

    @Override
    public String toString() {
        return "Inventory{" + "id=" + id + ", reference=" + reference + 
               ", description=" + description + ", price=" + price +
               ", amount=" + amount + ", unit=" + unit + '}';
    }

    public Product(int id, String reference, String description, Price price, int amount, String unit) {
        this.id = id;
        this.reference = reference;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.unit = unit;
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
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Price price) {
        this.price = price;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    
    
}
