package ec.edu.espe.accountingsystem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testCalculateTotalPrice() {
       
        Product product = new Product(
            "1", 
            "chocolate", 
            "Manicho", 
            new Price(2.50f, 2.25f, 2.00f), 
            54, 
            new MeasuredItem("bag", 1.59f, "kg")
        );
        

        assertEquals(135f, product.calculateTotalPrice(), "Total price must be amount 54 times retail price 2.50");
    }
}
