package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 */
public class Price {

    private float current;
    private float retail;
    private float wholesale;
    private float distributor;
    private float discount;

    @Override
    public String toString() {
        return "Price{" + "current=" + current + ", retail=" + retail + 
               ", wholesale=" + wholesale + ", distributor=" + distributor + 
               ", discount=" + discount + '}';
    }

    public Price(float current, float retail, float wholesale, float distributor, float discount) {
        this.current = current;
        this.retail = retail;
        this.wholesale = wholesale;
        this.distributor = distributor;
        this.discount = discount;
    }
       
    
    /**
     * @return the current
     */
    public float getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(float current) {
        this.current = current;
    }

    /**
     * @return the retail
     */
    public float getRetail() {
        return retail;
    }

    /**
     * @param retail the retail to set
     */
    public void setRetail(float retail) {
        this.retail = retail;
    }

    /**
     * @return the wholesale
     */
    public float getWholesale() {
        return wholesale;
    }

    /**
     * @param wholesale the wholesale to set
     */
    public void setWholesale(float wholesale) {
        this.wholesale = wholesale;
    }

    /**
     * @return the distributor
     */
    public float getDistributor() {
        return distributor;
    }

    /**
     * @param distributor the distributor to set
     */
    public void setDistributor(float distributor) {
        this.distributor = distributor;
    }

    /**
     * @return the discount
     */
    public float getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    
}
