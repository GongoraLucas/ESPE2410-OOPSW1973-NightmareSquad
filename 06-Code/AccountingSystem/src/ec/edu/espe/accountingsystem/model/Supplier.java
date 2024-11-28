package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 */
public class Supplier extends Entity{
    
    private String type;

    @Override
    public String toString() {
        return "Supplier{" + "type=" + type + '}';
    }

    public Supplier(String type, String id, String name, IdentityCard identityCard, String address, String phoneNumber, String email) {
        super(id, name, identityCard, address, phoneNumber, email);
        this.type = type;
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
