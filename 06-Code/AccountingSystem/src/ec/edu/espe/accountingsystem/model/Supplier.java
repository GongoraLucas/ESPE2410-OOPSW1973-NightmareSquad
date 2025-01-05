package ec.edu.espe.accountingsystem.model;

import utils.Identifiable;

/**
 *
 * @author Sebastian Charij
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class Supplier implements Identifiable{

    private String id;
    private String name;
    private IdentityCard identityCard;
    private String address;
    private int phoneNumber;
    private String email;

    @Override
    public String toString() {
         String horizontalLine ="------------------------------------------------------";
         return String.format("%s%s\n| %12s | %30s | %12s | %12s | %12s | %12s | %12s |\n%s",
                horizontalLine,
                horizontalLine,
                id,              
                name,
                identityCard.getType(),
                identityCard.getId(),
                address,
                phoneNumber,
                email,
                horizontalLine); 

    }

    public Supplier(String id, String name, IdentityCard identityCard, String address, int phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.identityCard = identityCard;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the identityCard
     */
    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    /**
     * @param identityCard the identityCard to set
     */
    public void setIdentityCard(IdentityCard identityCard) {
        this.identityCard = identityCard;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
