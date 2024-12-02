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
        boolean add = this.purchases.add(purchase);
        if (add) {
            System.out.println("The sale has been added successfully");
        }
    }
    
    public Purchase searchById(String purchaseId) {

        for (Purchase purchase : purchases) {
            if (purchase.getId().equals(purchaseId)) {
                return purchase;
            }
        }
        throw new Error("The sale was not found");
    }

    public void delete(String purchaseId) {
        this.purchases.add(this.searchById(purchaseId));
    }

    public void update(String purchaseId) {
        //TODO algorithm
    }
    
    public void viewPurchasesForConsole() {
        System.out.printf("%-10s %-20s %-15s %-10s %-30s %-30s %-20s %-15s\n",
                "ID", "Issue Date", "Voucher Type", "Voucher ID",
                "Supplier Name", "Client Supplier", "Payment Method", "TOTAL");
        System.out.println("-----------------------------------------------------------------------------------------------------");


        for (Purchase purchase : this.purchases) {
           
            System.out.printf("%-10s %-20s %-15s %-10s %-30s %-30s %-20s %-15.2f\n",
                    purchase.getId(),
                    purchase.getVoucher().getIssueDate(),
                    purchase.getVoucher().getType(),
                    purchase.getVoucher().getId(),
                    purchase.getVoucher().getClient().getName(),
                    purchase.getVoucher().getClient().getType(),
                    purchase.getVoucher().getPaymentMethod(),
                    purchase.getVoucher().getTotal()); 
        }

    }

}
