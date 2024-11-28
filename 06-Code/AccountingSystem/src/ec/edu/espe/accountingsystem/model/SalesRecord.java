package ec.edu.espe.accountingsystem.model;

import java.util.List;

/**
 *
 * @author Sebastian Charij
 */

public class SalesRecord {
    
    private List<Sale> sales;

    @Override
    public String toString() {
        return "SalesRecord{" + "sales=" + sales + '}';
    }

    public SalesRecord(List<Sale> sales) {
        this.sales = sales;
    }
    
    
    /**
     * @return the sales
     */
    public List<Sale> getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
    
    
}
