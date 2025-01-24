package ec.edu.espe.stockbill.model;

import ec.edu.espe.stockbill.model.Record;
import ec.edu.espe.stockbill.model.Supplier;
import java.util.ArrayList;

/**
 *
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class SuppliersRecord extends Record {

    private static String collection = "suppliers";

    public SuppliersRecord() {
        super();
    }

    public boolean add(Supplier supplier) {

        return super.getDatabase().insertData(collection, supplier);

    }

    public boolean delete(String supplierId) {

        return super.getDatabase().deleteData(collection, supplierId);
    }

    public boolean update(String supplierId, Supplier supplier) {

        return super.getDatabase().updateData(collection, supplierId, supplier);

    }

    public ArrayList<Supplier> getSuppliers() {
    
        return super.getDatabase().readAllData(collection, Supplier.class);

    }

    public Supplier findSupplierById(String supplierId) {
     
        for (Supplier supplier : getSuppliers()) {
            if (supplier.getId().equals(supplierId)) {
                return supplier;
            }
        }
  
        return null;
    }
}
