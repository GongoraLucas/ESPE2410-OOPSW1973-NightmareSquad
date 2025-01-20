

package ec.edu.espe.accountingsystem.controller;

import ec.edu.espe.accountingsystem.controller.DAO;
import ec.edu.espe.accountingsystem.model.Voucher;
import java.util.ArrayList;

/**
 *
 * @author Lucas Gongora
 */
public class VouchersDAO extends DAO{
    private static String collection="vouchers";

    
    public VouchersDAO() {
        super();
    }
    
    public ArrayList<Voucher> getVouchers(){
        return super.getDatabase().readAllData(collection, Voucher.class);
    }

    public void add(Voucher voucher) {
        super.getDatabase().insertData(collection, voucher);
    }

    public void delete(String voucherId) {
        super.getDatabase().deleteData(collection, voucherId);
    }

    public void update(String voucherId,Voucher voucher) {
        super.getDatabase().updateData(collection, voucherId, voucher);

    }
    
    
    public Voucher findVoucherById(String voucherId){
        for (Voucher voucher : this.getVouchers()) {
            if (voucher.getId().equals(voucherId)) {
                return voucher;
            }
        }
        return null;
    }
}
