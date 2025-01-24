package ec.edu.espe.stockbill.controller;

import ec.edu.espe.stockbill.exception.InvalidIdentityCardException;
import ec.edu.espe.stockbill.model.IdentityCard;
import ec.edu.espe.stockbill.model.Supplier;
import ec.edu.espe.stockbill.model.SuppliersRecord;

/**
 *
 * @author Lucas Gongora
 */
public class SupplierController {

    SuppliersRecord suppliersRecord;

    public SupplierController() {
        suppliersRecord = new SuppliersRecord();
    }

    public boolean addSupplier(String id, String name, String identityCardType, String identityCardNumber, String address, String phoneNumber, String email) throws InvalidIdentityCardException {
        try {
            IdentityCard identityCard = new IdentityCard(identityCardType, identityCardNumber);
            Supplier supplier = new Supplier(id, name, identityCard, address, phoneNumber, email);
            return suppliersRecord.add(supplier);
        } catch (InvalidIdentityCardException ex) {
            return false;
        }
    }
    
    public boolean delete(String id){
        return suppliersRecord.delete(id);
    }
    
    public Supplier getSupplier(String id){
        Supplier supplier ;
        supplier = suppliersRecord.findSupplierById(id);
        return supplier;
    }
    
     public boolean update(String id, String name, String identityCardType, String identityCardNumber, String address, String phoneNumber, String email) throws InvalidIdentityCardException {
        try {
            IdentityCard identityCard = new IdentityCard(identityCardType, identityCardNumber);
            Supplier supplier = new Supplier(id, name, identityCard, address, phoneNumber, email);
            return suppliersRecord.update(id,supplier);
        } catch (InvalidIdentityCardException ex) {
            return false;
        }
    }
}
