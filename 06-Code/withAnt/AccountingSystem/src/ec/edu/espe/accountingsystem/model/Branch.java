package ec.edu.espe.accountingsystem.model;
import ec.edu.espe.accountingsystem.exception.InvalidBranchException;

import utils.Identifiable;

/**
 *
 * @author Lucas Gongora
 */
public class Branch implements Identifiable {

    private String id;
    private String name;
    private String address;
    private int phoneNumber;
    private String manager;

    @Override
    public String toString() {
         String horizontalLine ="------------------------------------------------------";
         return String.format("%s%s\n| %12s | %12s | %30s | %12s | %12s |\n%s",
                horizontalLine,
                horizontalLine,
                id,              
                name,       
                address,     
                phoneNumber,         
                manager, 
                horizontalLine); 

    }

    public Branch(String id, String name, String address, int phoneNumber, String manager) throws InvalidBranchException {
        if (id == null || id.isEmpty() || name == null || name.isEmpty() || address == null || address.isEmpty()) {
            throw new InvalidBranchException("Branch fields cannot be null or empty.");
        }
        
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.manager = manager;
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
     * @return the manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

}
