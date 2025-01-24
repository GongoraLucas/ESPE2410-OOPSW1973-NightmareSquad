package ec.edu.espe.stockbill.controller;

import ec.edu.espe.stockbill.model.Branch;
import ec.edu.espe.stockbill.model.BranchesRecord;

/**
 *
 * @author Lucas Gongora
 */
public class BranchController {
    BranchesRecord branchesRecord;
    
    public BranchController (){
        branchesRecord = new BranchesRecord();
    }
    
    public boolean add(String id, String name, String address, String phoneNumber, String manager){
        Branch branch = new Branch(id, name, address, phoneNumber, manager);
        return branchesRecord.add(branch);
    }
    
    public boolean  delete(String id){
        return branchesRecord.delete(id);
    }
    
    public Branch getBranch(String id){
        return this.branchesRecord.findBranchById(id);
    }
    
    public boolean update(String id, String name, String address, String phoneNumber, String manager){
        Branch branch = new Branch(id, name, address, phoneNumber, manager);
        return branchesRecord.update(id,branch);
    }
}
