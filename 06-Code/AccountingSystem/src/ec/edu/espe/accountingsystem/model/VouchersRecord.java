

package ec.edu.espe.accountingsystem.model;

import utils.JsonFileManager;
import java.util.ArrayList;

/**
 *
 * @author Lucas Gongora
 */
public class VouchersRecord {
    private JsonFileManager vouchersJson;
    private ArrayList<Voucher> vouchers;

    @Override
    public String toString() {
        String horizontalLine;
        StringBuilder content;
   
        horizontalLine = "-------------------------------------------------------";
        content = new StringBuilder();
        
        content.append(horizontalLine);
        content.append(horizontalLine);
        content.append("Vouchers");

       
        for (Voucher voucher : vouchers) {
            content.append(voucher.toString());
        }

 
        content.append(horizontalLine);
        content.append("\n");
        
        return content.toString();
    }
    
    public VouchersRecord() {
        this.vouchersJson = new JsonFileManager("Vouchers.json");
        this.vouchers = this.vouchersJson.read(Voucher.class);
    }

    public void add(Voucher voucher) {
        this.vouchersJson.create(voucher, Voucher.class);
    }

    public void delete(String voucherId) {
        this.vouchersJson.delete(voucherId, Voucher.class);
    }

    public void update(String voucherId,Voucher voucher) {
        this.vouchersJson.update(voucherId, voucher, Voucher.class);

    }
    
    public void updateJsonFile(){
        this.vouchers = this.vouchersJson.read(Voucher.class);
    }
    
    public Voucher findVoucherById(String voucherId){
        for (Voucher voucher : this.vouchers) {
            if (voucher.getId().equals(voucherId)) {
                return voucher;
            }
        }
        return null;
    }
}
