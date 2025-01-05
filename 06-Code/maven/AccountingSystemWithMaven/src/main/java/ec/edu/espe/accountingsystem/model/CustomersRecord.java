package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;
import utils.JsonFileManager;

/**
 *
 * @author Lucas Gongora
 */
public class CustomersRecord {

    JsonFileManager customers;

    @Override
    public String toString() {
       String horizontalLine;
        StringBuilder content;

        horizontalLine = "-------------------------------------------------------";
        content = new StringBuilder();

        content.append(horizontalLine);
        content.append(horizontalLine);
        content.append(String.format("\n| %12s | %12s | %30s | %12s | %12s | %12s | %12s | %12s\n",
                "ID", "Type", "Name", "Identity Card Type", "Identity Card number","Adress","Phone number","Email"));

        for (Customer customer : customers.read(Customer.class)) {
            content.append(customer.toString());
        }

        content.append(horizontalLine);
        content.append("\n");

        return content.toString();
    }
    
    

    public CustomersRecord(String customersFile) {
        this.customers = new JsonFileManager(customersFile);
    }

    public void add(Customer customer) {
        this.customers.add(customer, Customer.class);
    }

    public void delete(String customerId) {
        this.customers.delete(customerId, Customer.class);
    }

    public void update(String customerId, Customer customer) {
        this.customers.update(customerId, customer, Customer.class);
    }
    
    public Customer findCustomerById(String customerId) {
        for (Customer customer : this.customers.read(Customer.class)) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
        

    public ArrayList<Customer> getCustomers() {
        return this.customers.read(Customer.class);
    }
}
