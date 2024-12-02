package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class Transaction {
    
    private String id;
    private Voucher voucher;

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", voucher=" + voucher + '}';
    }

    public Transaction(String id, Voucher voucher) {
        this.id = id;
        this.voucher = voucher;
    }
    
    public Transaction(){
        
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
    
    
}
