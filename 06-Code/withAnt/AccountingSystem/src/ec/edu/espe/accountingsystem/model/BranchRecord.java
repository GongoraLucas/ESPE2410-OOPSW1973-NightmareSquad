

package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Lucas Gongora
 */
public class BranchRecord extends Record<Branch>{
    /*
    JsonFileManager branches;

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
    
    
    public BranchRecord(String branchesFile) {
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
    */
    public BranchRecord(String filename) {
        super(filename);
    }
    
    @Override
    protected Class<Branch> getEntityClass() {
        return Branch.class;
    }
    
    @Override
    public Branch findBranchById(String id) {
        return getAll().stream()
            .filter(branch -> branch.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
    @Override
    public String toString() {
        String horizontalLine = "------------------------------------------------------";
        StringBuilder content = new StringBuilder();
        
        content.append(horizontalLine)
               .append(horizontalLine)
               .append(String.format("\n| %12s | %12s | %30s | %12s | %12s |\n",
                    "ID", "Name", "Address", "Phone number", "Manager"));
        
        getAll().forEach(branch -> content.append(branch.toString()));
        
        content.append(horizontalLine)
               .append("\n");
        
        return content.toString();
    }
}
