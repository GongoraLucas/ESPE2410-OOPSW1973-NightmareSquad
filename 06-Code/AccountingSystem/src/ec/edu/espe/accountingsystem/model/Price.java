package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class Price {

    private float current;
    private float retail;
    private float wholesale;
    private float distributor;

    @Override
    public String toString() {
        return "Price{" + "current=" + current + ", retail=" + retail
                + ", wholesale=" + wholesale + ", distributor=" + distributor
                + ", discount=" + '}';
    }

    public Price(float retail, float wholesale, float distributor) {
        this.current = retail;
        this.retail = retail;
        this.wholesale = wholesale;
        this.distributor = distributor;
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

    public void adjustCurrentPrice(String typePrice) {
        switch (typePrice) {
            case "retail":
                this.current = this.retail;
                break;
            case "wholesale":
                this.current = this.wholesale;
                break;
            case "distributor":
                this.current = this.distributor;
                break;
            default:
                throw new IllegalArgumentException("Valid price types: retail, wholesale and distributor");

        }
    }

    public void applyDiscount(float discount) {
        float discountValue = this.current * discount;
        this.current = this.current - discountValue;
    }

}
