package ec.edu.espe.accountingsystem.model;

import utils.Identifiable;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class Transaction implements Identifiable {
    
    private String id;
    private String type;
    private Voucher voucher;
    private String paymentStatus;

    @Override
    public String toString() {
        return String.format("%20s %20s %20s %40s %20s %20s\n",
                    this.id, this.type,
                    this.voucher.getId(), this.voucher.getIssueDate(),
                    this.voucher.getPaymentMethod(), this.voucher.getTotal());
    }

    public Transaction(String id, String type, Voucher voucher, String paymentStatus) {
        this.id = id;
        this.type = type;
        this.voucher = voucher;
        this.paymentStatus = paymentStatus;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the voucher
     */
    public Voucher getVoucher() {
        return voucher;
    }

    /**
     * @param voucher the voucher to set
     */
    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    /**
     * @return the paymentStatus
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * @param paymentStatus the paymentStatus to set
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    
    
    
}
