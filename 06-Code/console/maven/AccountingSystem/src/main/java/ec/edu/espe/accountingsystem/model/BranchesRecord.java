

package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;
import utils.JsonFileManager;

/**
 *
 * @author Lucas Gongora
 */
public class BranchesRecord {
    JsonFileManager branches;

    public BranchesRecord(JsonFileManager branches) {
        this.branches = branches;
    }

    
        
    @Override
    public String toString() {
       String horizontalLine;
        StringBuilder content;

        horizontalLine = "-------------------------------------------------------";
        content = new StringBuilder();

        content.append(horizontalLine);
        content.append(horizontalLine);
        content.append(String.format("\n| %12s | %12s | %30s | %12s | %12s |\n",
                "ID", "Name", "Address", "Phone number", "Manager"));

        for (Branch branch : branches.read(Branch.class)) {
            content.append(branch.toString());
        }

        content.append(horizontalLine);
        content.append("\n");

        return content.toString();
    }
    
    
    

    public BranchesRecord(String branchesFile) {
        this.branches = new JsonFileManager(branchesFile);
    }
    
    public void add(Branch branch){
        this.branches.add(branch, Branch.class);
    }
    
    public void delete(String branchId){
        this.branches.delete(branchId, Branch.class);
    }
    
    public void update(String branchId,Branch branch){
        this.branches.update(branchId, branchId, Branch.class);
    }
    
    public Branch findBranchById(String branchId) {
        for (Branch branch : this.branches.read(Branch.class)) {
            if (branch.getId().equals(branchId)) {
                return branch;
            }
        }
        return null;
    }
    public ArrayList<Branch> getBranches(){
        return this.branches.read(Branch.class);
    }
}
