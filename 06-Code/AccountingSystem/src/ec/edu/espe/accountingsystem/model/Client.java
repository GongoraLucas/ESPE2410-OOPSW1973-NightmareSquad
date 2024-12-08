package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class Client extends Entity{
         
    private String type;

    @Override
    public String toString() {
        return "Client{" + "type=" + getType() + '}';
    }
    
    public Client(String type, String name, IdentityCard identityCard, String address, String phoneNumber, String email) {
        super(name, identityCard, address, phoneNumber, email);
        this.type=type;
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
