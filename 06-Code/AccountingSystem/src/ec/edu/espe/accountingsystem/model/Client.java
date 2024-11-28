/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Sebastian Charij
 */
public class Client extends Entity{
         
    private String type;

    @Override
    public String toString() {
        return "Client{" + "type=" + type + '}';
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
