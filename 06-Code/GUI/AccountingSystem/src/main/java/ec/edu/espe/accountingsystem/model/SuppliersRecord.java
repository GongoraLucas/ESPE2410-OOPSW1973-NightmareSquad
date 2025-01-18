package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;


/**
 *
 * @author Lucas Gongora
 */
public class SuppliersRecord extends Record {

    private static String collection = "suppliers";

    public SuppliersRecord(String suppliersFile) {
        super();
    }

    public void add(Supplier supplier) {
       super.getDatabase().insertData(collection, supplier);
    }

    public void delete(String supplierId) {
        super.getDatabase().deleteData(collection, supplierId);
    }

    public void update(String supplierId, Supplier supplier) {
        super.getDatabase().updateData(collection, supplierId, supplier);
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
