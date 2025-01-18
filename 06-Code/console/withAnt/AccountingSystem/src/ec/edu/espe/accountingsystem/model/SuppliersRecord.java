package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;
import utils.JsonFileManager;

/**
 *
 * @author Lucas Gongora
 */
public class SuppliersRecord {

    JsonFileManager suppliers;

    @Override
    public String toString() {
        String horizontalLine;
        StringBuilder content;

        horizontalLine = "-------------------------------------------------------";
        content = new StringBuilder();

        content.append(horizontalLine);
        content.append(horizontalLine);
        content.append(String.format("\n| %12s  | %30s | %12s | %12s | %12s | %12s | %12s |\n",
                "ID", "Name", "Identity Card Type", "Identity Card number", "Adress", "Phone number", "Email"));

        for (Supplier supplier : suppliers.read(Supplier.class)) {
            content.append(supplier.toString());
        }

        content.append(horizontalLine);
        content.append("\n");

        return content.toString();
    }

    public SuppliersRecord(String suppliersFile) {
        this.suppliers = new JsonFileManager(suppliersFile);
    }

    public void add(Supplier supplier) {
        this.suppliers.add(supplier, Supplier.class);
    }

    public void delete(String supplierId) {
        this.suppliers.delete(supplierId, Supplier.class);
    }

    public void update(String supplierId, Supplier supplier) {
        this.suppliers.update(supplierId, supplier, Customer.class);
    }

    public ArrayList<Supplier> getSuppliers() {
        return this.suppliers.read(Supplier.class);
    }

    public Supplier findSupplierById(String supplierId) {
        for (Supplier supplier : this.suppliers.read(Supplier.class)) {
            if (supplier.getId().equals(supplierId)) {
                return supplier;
            }
        }
        return null;
    }
}
