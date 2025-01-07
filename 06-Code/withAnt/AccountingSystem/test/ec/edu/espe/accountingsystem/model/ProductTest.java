package ec.edu.espe.accountingsystem.model;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    public void testCalculateTotalPriceWithDifferentQuantity() {
        Product product = new Product(
            "2", 
            "cookie", 
            "Oreo", 
            new Price(1.50f, 1.25f, 1.00f), 
            100, 
            new MeasuredItem("box", 0.5f, "kg")
        );
        assertEquals(150f, product.calculateTotalPrice(), "Total price must be amount 100 times retail price 1.50");
    }

    @Test
    public void testCalculateTotalPriceWithZeroQuantity() {
        Product product = new Product(
            "3", 
            "soda", 
            "Pepsi", 
            new Price(1.75f, 1.50f, 1.25f), 
            0, 
            new MeasuredItem("bottle", 0.75f, "liter")
        );
        assertEquals(0f, product.calculateTotalPrice(), "Total price must be 0 when quantity is 0");
    }



    @Test
    public void testCalculateTotalPriceWithHighQuantity() {
        Product product = new Product(
            "5", 
            "apple", 
            "Golden", 
            new Price(3.00f, 2.75f, 2.50f), 
            1000, 
            new MeasuredItem("bag", 1.59f, "kg")
        );
        assertEquals(3000f, product.calculateTotalPrice(), "Total price must be amount 1000 times retail price 3.00");
    }

    @Test
    public void testCalculateTotalPriceWithMinimumPrice() {
        Product product = new Product(
            "6", 
            "water", 
            "San Pellegrino", 
            new Price(0.50f, 0.40f, 0.30f), 
            200, 
            new MeasuredItem("bottle", 0.5f, "liter")
        );
        assertEquals(100f, product.calculateTotalPrice(), "Total price must be amount 200 times retail price 0.50");
    }


    @Test
    public void testCalculateTotalPriceWithZeroPrice() {
        Product product = new Product(
            "9", 
            "bread", 
            "Wonder", 
            new Price(0.0f, 0.0f, 0.0f), 
            300, 
            new MeasuredItem("loaf", 1.0f, "kg")
        );
        assertEquals(0f, product.calculateTotalPrice(), "Total price must be 0 when price is 0");
    }

    @Test
    public void testCalculateTotalPriceWithRetailPrice() {
        Product product = new Product(
            "10", 
            "cereal", 
            "Kellogg's", 
            new Price(3.00f, 2.80f, 2.50f), 
            50, 
            new MeasuredItem("box", 0.75f, "kg")
        );
        assertEquals(150f, product.calculateTotalPrice(), "Total price must be amount 50 times retail price 3.00");
    }
}
