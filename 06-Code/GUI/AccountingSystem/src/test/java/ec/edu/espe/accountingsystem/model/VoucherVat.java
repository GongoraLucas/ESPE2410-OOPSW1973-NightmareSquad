

package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.stockbill.model.Customer;
import ec.edu.espe.stockbill.model.Price;
import ec.edu.espe.stockbill.model.Product;
import ec.edu.espe.stockbill.model.Voucher;
import ec.edu.espe.stockbill.model.IdentityCard;
import ec.edu.espe.stockbill.model.Supplier;
import ec.edu.espe.stockbill.model.MeasuredItem;
import ec.edu.espe.stockbill.exception.InvalidIdentityCardException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lucas Gongora
 */
public class VoucherVat {
    @Test
    public void testCalculateVAT() throws InvalidIdentityCardException {
     
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

       
        assertEquals(40.5f, voucher.calculateVAT(), "The subtotal with vat must be the multiplication of the subtotal with VAT.");
    }
}
