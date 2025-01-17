package ec.espe.edu.accountingsystemmavem.model;

import ec.espe.edu.accountingsystemmavem.exception.InvalidIdentityCardException;

/**
 *
 * @author Andrés Espinosa
 */
public class IdentityCard {
    private String type;
    private String id;

    @Override
    public String toString() {
        return "IdentityCard{" + "type=" + type + ", id=" + id + '}';
    }

    public IdentityCard() {
    }

    public IdentityCard(String type, String id) throws InvalidIdentityCardException {
        this.type = type;
        try {
            setId(id);
        } catch (InvalidIdentityCardException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setId(String id) throws InvalidIdentityCardException {
        if (!isValidId(id)) {
            throw new InvalidIdentityCardException("The number card entered is not valid.");
        }
        this.id = id;
    }

    private boolean isValidId(String id) {
      
        return id != null && id.matches("^\\d{10}(\\d{3})?$"); 
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
}
