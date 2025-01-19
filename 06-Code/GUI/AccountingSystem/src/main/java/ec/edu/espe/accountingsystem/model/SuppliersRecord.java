package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;


/**
 *
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class SuppliersRecord extends Record {

    private static String collection = "suppliers";

    public SuppliersRecord(String suppliersFile) {
        super();
    }

    public void add(Supplier supplier) {
       super.getDatabase().connectDB();
       super.getDatabase().insertData(collection, supplier);
       super.getDatabase().closeConnection();
    }

    public void delete(String supplierId) {
        super.getDatabase().connectDB();
        super.getDatabase().deleteData(collection, supplierId);
        super.getDatabase().closeConnection();
    }

    public void update(String supplierId, Supplier supplier) {
        super.getDatabase().connectDB();
        super.getDatabase().updateData(collection, supplierId, supplier);
        super.getDatabase().closeConnection();
    }

    public ArrayList<Supplier> getSuppliers() {
        super.getDatabase().connectDB();
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
