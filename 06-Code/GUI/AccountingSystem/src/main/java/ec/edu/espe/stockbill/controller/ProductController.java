

package ec.edu.espe.stockbill.controller;

import ec.edu.espe.stockbill.model.Inventory;
import ec.edu.espe.stockbill.model.MeasuredItem;
import ec.edu.espe.stockbill.model.Price;
import ec.edu.espe.stockbill.model.Product;

/**
 *
 * @author Lucas Gongora
 */
public class ProductController {
    Inventory inventory;
    
    public ProductController(){
        inventory = new Inventory();
    }
    
    public boolean add(String id, String reference, String description, float retailPrice, float wholesalePrice, float distributorPrice, int amount,String descriptionMeasuredItem, float valueMeasuredItem, String unitMeasuredItem){
        
        Price price = new Price(retailPrice, wholesalePrice, distributorPrice);
        MeasuredItem measuredItem = new MeasuredItem(descriptionMeasuredItem, valueMeasuredItem, unitMeasuredItem);
        Product product = new Product(id, reference, description, price, amount, measuredItem);
        
        return inventory.add(product);
    }
    
    public boolean delete(String id){
        return inventory.delete(id);
    }
    
    public Product getPtroduct(String id){
        return inventory.findProductById(id);
    }
    
    public boolean update(String id, String reference, String description, float retailPrice, float wholesalePrice, float distributorPrice, int amount,String descriptionMeasuredItem, float valueMeasuredItem, String unitMeasuredItem){
        
        Price price = new Price(retailPrice, wholesalePrice, distributorPrice);
        MeasuredItem measuredItem = new MeasuredItem(descriptionMeasuredItem, valueMeasuredItem, unitMeasuredItem);
        Product product = new Product(id, reference, description, price, amount, measuredItem);
        
        return inventory.update(id,product);
    }
    
            
}
