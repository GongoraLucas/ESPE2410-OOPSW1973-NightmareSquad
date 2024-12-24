package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.exception.InvalidIdentityCardException;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 * @author David Cuichan
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
            setId(id); // Usar el método setId para validar
        } catch (InvalidIdentityCardException e) {
            System.out.println("Error: " + e.getMessage());
            throw e; // Re-lanzar la excepción si es necesario
        }
    }

    public void setId(String id) throws InvalidIdentityCardException {
        if (!isValidId(id)) {
            throw new InvalidIdentityCardException("La cédula ingresada no es válida.");
        }
        this.id = id;
    }

    private boolean isValidId(String id) {
        // Lógica de validación de cédula (ejemplo simple)
        return id != null && id.matches("\\d{10}"); // Debe ser un número de 10 dígitos
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
