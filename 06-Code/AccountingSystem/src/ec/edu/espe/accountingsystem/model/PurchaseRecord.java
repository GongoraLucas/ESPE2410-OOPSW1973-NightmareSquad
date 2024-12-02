package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class PurchaseRecord {

    private ArrayList<Purchase> purchases;

    @Override
    public String toString() {
        return "PurchaseRecord{" + "purchases=" + purchases + '}';
    }

    public PurchaseRecord(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    /**
     * @return the purchases
     */
    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    /**
     * @param purchases the purchases to set
     */
    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void add(Purchase purchase) {
        //TODO algorithm
    }

    public void delete(String purchaseId) {
        //TODO algorithm
    }

    public void update(String purchaseId) {
        //TODO algorithm
    }

}
