package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class Product {

    private String id;
    private String reference;
    private String description;
    private Price price;
    private int amount;
    private MeasuredItem measuredItem;

    @Override
    public String toString() {
         String horizontalLine ="------------------------------------------------------";
         return String.format("%s%s\n| %12s | %12s | %30s | %12s | %12s | %12s |\n%s",
                horizontalLine,
                horizontalLine,
                id,              
                reference,       
                description,     
                price.getCurrent(),
                amount,          
                measuredItem.getDescription(), 
                horizontalLine); 

    }

    public Product(String id, String reference, String description, Price price, int amount, MeasuredItem measuredItem) {
        this.id = id;
        this.reference = reference;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.measuredItem = measuredItem;
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
     * @return the measuredItem
     */
    public MeasuredItem getMeasuredItem() {
        return measuredItem;
    }

    /**
     * @param measuredItem the measuredItem to set
     */
    public void setMeasuredItem(MeasuredItem measuredItem) {
        this.measuredItem = measuredItem;
    }

    public float calculateTotalPrice() {
        return this.getAmount() * this.getPrice().getCurrent();
    }
    

}
