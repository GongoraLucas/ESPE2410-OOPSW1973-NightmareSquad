package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */

public class Purchase extends Transaction{
    
    private Supplier supplier;

    @Override
    public String toString() {
        return "Purchase{" + "supplier=" + supplier + '}';
    }
    

    /**
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    
}
