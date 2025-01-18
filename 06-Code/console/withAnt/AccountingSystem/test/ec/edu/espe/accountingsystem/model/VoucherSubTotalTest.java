package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.exception.InvalidIdentityCardException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VoucherSubTotalTest {

    @Test
    public void testCalculateSubtotal() throws InvalidIdentityCardException {
     
        Product product = new Product(
            "1", 
            "chocolate", 
            "Manicho", 
            new Price(2.50f, 2.25f, 2.00f), 
            54, 
            new MeasuredItem("bag", 1.59f, "kg")
        );
        
        ArrayList<Product> shoppingCart = new ArrayList<>() {{
            add(product);
            add(product);
        }};
        
        Customer customer = new Customer(
            "C001", 
            "Regular", 
            "Lucas Gongora", 
            new IdentityCard("ID001", "1234567890"), 
            "123 Street, City", 
            "123-456-7890", 
            "lucas@example.com"
        );

        Supplier supplier = new Supplier(
            "S001", 
            "Supplier A", 
            new IdentityCard("ID_S001", "9876543210"), 
            "456 Supplier St.", 
            "098-765-4321", 
            "supplierA@example.com"
        );

        Voucher voucher = new Voucher(
            "sale", 
            "1", 
            customer, 
            supplier, 
            "Credit Card", 
            shoppingCart, 
            0.15f
        );


        assertEquals(270, voucher.calculateSubtotal(), "The subtotal must be the sum of the retail prices of the products.");
    }
}
