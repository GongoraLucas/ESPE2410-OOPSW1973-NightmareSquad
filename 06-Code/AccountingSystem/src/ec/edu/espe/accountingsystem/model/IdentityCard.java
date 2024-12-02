package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class IdentityCard {
    private String type;
    private String id;

    @Override
    public String toString() {
        return "IdentityCard{" + "type=" + type + ", id=" + id + '}';
    }

    
    public IdentityCard(String type, String id) {
        this.type = type;
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
    
    
}
