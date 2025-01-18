package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;


/**
 *
 * @author Lucas Gongora
 */
public class CustomersRecord extends Record {

    private static String collection = "customers";

    
    public CustomersRecord(String customersFile) {
        super();
    }

    public void add(Customer customer) {
        super.getDatabase().insertData(collection, customer);
    }

    public void delete(String customerId) {
        super.getDatabase().deleteData(collection, customerId);
    }

    public void update(String customerId, Customer customer) {
        super.getDatabase().updateData(collection, customerId, customer);
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
