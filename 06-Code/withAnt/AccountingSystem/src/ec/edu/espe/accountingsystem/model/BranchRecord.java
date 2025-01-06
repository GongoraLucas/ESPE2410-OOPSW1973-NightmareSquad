package ec.edu.espe.accountingsystem.model;

/**
 *
 * @author Lucas Gongora
 */
public class BranchRecord extends Record<Branch>{
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
        
        content.append(horizontalLine);
        content.append(horizontalLine);
        content.append(String.format("\n| %12s | %12s | %30s | %12s | %12s |\n",
                    "ID", "Name", "Address", "Phone number", "Manager"));
        
        getAll().forEach(branch -> content.append(branch.toString()));
        
        content.append(horizontalLine);
        content.append("\n");
        
        return content.toString();
    }    
}
