package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.model.Record;
import ec.edu.espe.accountingsystem.model.Customer;
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

    public void add(Customer customer) {
        super.getDatabase().connectDB();
        super.getDatabase().insertData(collection, customer);
        super.getDatabase().closeConnection();
    }

    public void delete(String customerId) {
        super.getDatabase().connectDB();
        super.getDatabase().deleteData(collection, customerId);
        super.getDatabase().closeConnection();
    }

    public void update(String customerId, Customer customer) {
        super.getDatabase().connectDB();
        super.getDatabase().updateData(collection, customerId, customer);
        super.getDatabase().closeConnection();
    }
    
    public Customer findCustomerById(String customerId) {
        super.getDatabase().connectDB();
        for (Customer customer : super.getDatabase().readAllData(collection, Customer.class)) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        super.getDatabase().closeConnection();
        return null;
    }
        

    public ArrayList<Customer> getCustomers() {
        super.getDatabase().connectDB();
        return super.getDatabase().readAllData(collection, Customer.class);
    }
}
