package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 */
public class SalesRecord {

    private ArrayList<Sale> sales;

    @Override
    public String toString() {
        return "SalesRecord{" + "sales=" + sales + '}';
    }

    public SalesRecord(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    /**
     * @return the sales
     */
    public ArrayList<Sale> getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    public void add(Supplier supplier) {
        //TODO algorithm
    }

    public void delete(String supplierId) {
        //TODO algorithm
    }

    public void update(String supplierId) {
        //TODO algorithm
    }

}
