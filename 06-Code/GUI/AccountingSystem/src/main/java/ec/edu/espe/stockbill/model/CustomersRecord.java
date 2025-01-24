package ec.edu.espe.stockbill.model;

import ec.edu.espe.stockbill.model.Record;
import ec.edu.espe.stockbill.model.Customer;
import java.util.ArrayList;


/**
 *
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class CustomersRecord extends Record {

    private static String collection = "customers";

    
    public CustomersRecord() {
        super();
    }


    public boolean add(Customer customer) {
        return super.getDatabase().insertData(collection, customer);
    }

    public boolean delete(String customerId) {
        return super.getDatabase().deleteData(collection, customerId);
    }

    public boolean update(String customerId, Customer customer) {
        return super.getDatabase().updateData(collection, customerId, customer);

    }
    public Customer findCustomerById(String customerId) {
       
        for (Customer customer : super.getDatabase().readAllData(collection, Customer.class)) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        
        return null;
    }
        

    public ArrayList<Customer> getCustomers() {
      
        return super.getDatabase().readAllData(collection, Customer.class);
    }
}
