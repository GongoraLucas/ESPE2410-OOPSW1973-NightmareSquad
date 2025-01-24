

package ec.edu.espe.stockbill.model;

import org.bson.Document;

/**
 *
 * @author Lucas Gongora
 */
public class ProfilesRecord extends Record{
    private static final String COLLECTION = "profiles";
    public ProfilesRecord() {
        super();
    }
    
    
    
    public Customer getByCustomer(){
        return super.getDatabase().readData(COLLECTION, Customer.class, new Document("id","1")).get(0);
    }
    
    public Supplier getBySupplier(){
           return super.getDatabase().readData(COLLECTION, Supplier.class, new Document("id","0")).get(0);
    }
}
