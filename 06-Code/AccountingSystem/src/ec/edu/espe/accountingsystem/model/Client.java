package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 */
public class Client extends Entity{
         
    private String type;

    @Override
    public String toString() {
        return "Client{" + "type=" + type + '}';
    }
    
    public Client(String id, String name, IdentityCard identityCard, String address, String phoneNumber, String email) {
        super(id, name, identityCard, address, phoneNumber, email);
    }

    public Client() {
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
    
    
}
