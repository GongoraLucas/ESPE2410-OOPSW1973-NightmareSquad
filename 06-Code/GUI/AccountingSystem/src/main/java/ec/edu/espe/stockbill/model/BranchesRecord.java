

package ec.edu.espe.stockbill.model;

import ec.edu.espe.stockbill.model.Record;
import ec.edu.espe.stockbill.model.Branch;
import java.util.ArrayList;

/**
 *
 * @author Lucas Gongora
 * @author Andrés Espinosa
 */
public class BranchesRecord extends Record{
    private static String collection = "branches";

    public BranchesRecord() {
        super();
    }
    
    public boolean add(Branch branch){
        return super.getDatabase().insertData(collection, branch);
    }
    
    public boolean delete(String branchId){
        return super.getDatabase().deleteData(collection, branchId);
    }
    
    public boolean update(String branchId,Branch branch){
        return super.getDatabase().updateData(collection, branchId, branch);
    }
    
    public Branch findBranchById(String branchId) {
        for (Branch branch : super.getDatabase().readAllData(collection, Branch.class) ){
            if (branch.getId().equals(branchId)) {
                return branch;
            }
        }
        return null;
    }
    public ArrayList<Branch> getBranches(){
        return super.getDatabase().readAllData(collection, Branch.class) ;
    }
}
