package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */

public class Sale extends Transaction{
    
    private Client client;

    public Sale(String id, Voucher voucher,Client client) {
        super(id, voucher);
        this.client=client;
    }

    
    

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
    
    
    
}
