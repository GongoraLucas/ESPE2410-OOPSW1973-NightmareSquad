package ec.edu.espe.accountingsystem.controller;

import ec.edu.espe.accountingsystem.exception.InvalidIdentityCardException;
import ec.edu.espe.accountingsystem.model.Customer;
import ec.edu.espe.accountingsystem.model.CustomersRecord;
import ec.edu.espe.accountingsystem.model.IdentityCard;

/**
 *
 * @author Lucas Gongora
 */
public class CustomerController {
    CustomersRecord customersRecord;
    
    public CustomerController(){
        customersRecord = new CustomersRecord();
    }
    
    public boolean addCustomer(String id, String type, String name, String identityCardType, String identityCardNumber, String address, String phoneNumber, String email) throws InvalidIdentityCardException{
        IdentityCard identityCard = new IdentityCard(identityCardType,identityCardNumber);
        Customer customer= new Customer(id, type, name, identityCard, address, phoneNumber, email);
        return customersRecord.add(customer);
        
    }
    
    public boolean delete(String id){
        return customersRecord.delete(id);
    }
    
    public Customer getCustomer(String id){
        return customersRecord.findCustomerById(id);
    }
    
     public boolean update(String id, String type, String name, String identityCardType, String identityCardNumber, String address, String phoneNumber, String email) throws InvalidIdentityCardException{
        IdentityCard identityCard = new IdentityCard(identityCardType,identityCardNumber);
        Customer customer= new Customer(id, type, name, identityCard, address, phoneNumber, email);
        return customersRecord.update(id, customer);
        
    }

}
