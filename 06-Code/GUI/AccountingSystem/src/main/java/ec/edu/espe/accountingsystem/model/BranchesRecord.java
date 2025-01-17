

package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Lucas Gongora
 */
public class BranchesRecord extends Record{
    private static String collection = "branches";

    public BranchesRecord() {
        super();
    }
    
    public void add(Branch branch){
        super.getDatabase().insertData(collection, branch);
    }
    
    public void delete(String branchId){
        super.getDatabase().deleteData(collection, branchId);
    }
    
    public void update(String branchId,Branch branch){
        super.getDatabase().updateData(collection, branchId, branch);
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
