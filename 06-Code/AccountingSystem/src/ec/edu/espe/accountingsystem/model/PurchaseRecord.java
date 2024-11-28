package ec.edu.espe.accountingsystem.model;

import java.util.List;

/**
 *
 * @author Sebastian Charij
 */

public class PurchaseRecord {

    private List<Purchase> purchases;

    @Override
    public String toString() {
        return "PurchaseRecord{" + "purchases=" + purchases + '}';
    }

    public PurchaseRecord(List<Purchase> purchases) {
        this.purchases = purchases;
    }
    
    
    /**
     * @return the purchases
     */
    public List<Purchase> getPurchases() {
        return purchases;
    }

    /**
     * @param purchases the purchases to set
     */
    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
    
    
}
