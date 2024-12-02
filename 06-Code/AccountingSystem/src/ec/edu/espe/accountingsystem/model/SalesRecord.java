package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
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

    public void add(Sale sale) {
        boolean add = this.sales.add(sale);
        if (add) {
            System.out.println("The sale has been added successfully");
        }
    }

    public Sale searchById(String saleId) {

        for (Sale sale : sales) {
            if (sale.getId().equals(saleId)) {
                return sale;
            }
        }
        throw new Error("The sale was not found");
    }

    public void delete(String saleId) {
        this.sales.remove(searchById(saleId));
    }

    public void update(String supplierId) {
        //TODO algorithm
    }

    public void viewSalesForConsole() {
        System.out.printf("%-10s %-20s %-15s %-10s %-30s %-30s %-20s %-15s\n",
                "ID", "Issue Date", "Voucher Type", "Voucher ID",
                "Client Name", "Client Type", "Payment Method", "TOTAL");
        System.out.println("-----------------------------------------------------------------------------------------------------");


        for (Sale sale : this.sales) {
           
            System.out.printf("%-10s %-20s %-15s %-10s %-30s %-30s %-20s %-15.2f\n",
                    sale.getId(),
                    sale.getVoucher().getIssueDate(),
                    sale.getVoucher().getType(),
                    sale.getVoucher().getId(),
                    sale.getVoucher().getClient().getName(),
                    sale.getVoucher().getClient().getType(),
                    sale.getVoucher().getPaymentMethod(),
                    sale.getVoucher().getTotal()); 
        }

    }

}
