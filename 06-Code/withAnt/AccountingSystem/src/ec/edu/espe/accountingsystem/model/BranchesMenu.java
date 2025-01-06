package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.exception.InvalidBranchException;
import java.util.InputMismatchException;

/**
 *
 * @author Lucas Gongora
 */
public class BranchesMenu extends Menu {

    BranchesRecord branchesRecord;

    // ANSI Color Codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green

    public BranchesMenu() {
        branchesRecord = new BranchesRecord("branches.json");
    }

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\n\tAccounting System\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Branches" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. Add branch" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Show branches" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Update branch" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Delete branch" + RESET);
        System.out.println(MENU_OPTION_COLOR + "5. Exit" + RESET);
    }

    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                this.addBranch();
                break;
            case 2:
                this.showBranches();
                break;
            case 3:
                this.updateBranch();
                break;
            case 4:
                this.deleteBranch();
                break;
            case 5:
                super.setExecutionMenu(false);
                break;
            default:
                throw new IllegalArgumentException("Option must be between 1 and 5.");
        }
    }

    private void addBranch()  {
        String id;
        String name;
        String address;
        int phoneNumber;
        String manager;
        Branch branch;
        try {
            System.out.print("Enter the id: ");
            id = super.getScanner().nextLine();
            branch = branchesRecord.findBranchById(id);
            if (branch != null) {
                System.out.println("the branch already exists");
                return;
            }
            System.out.print("Enter the name: ");
            name = super.getScanner().nextLine();

            System.out.print("Enter the address: ");
            address = super.getScanner().nextLine();

            System.out.print("Enter the phone number: ");
            phoneNumber = super.getScanner().nextInt();
            super.getScanner().nextLine();

            System.out.print("Enter the manager: ");
            manager = super.getScanner().nextLine();

            branch = new Branch(id, name, address, phoneNumber, manager);
            this.branchesRecord.add(branch);

        } catch (InputMismatchException ex) {
            System.out.println("Enter the correct phone number");
        }catch (InvalidBranchException ex){
            System.out.println(ex.getMessage());
        }

    }

    private void showBranches() {
        System.out.println(this.branchesRecord.toString());
    }

    private void updateBranch()  {
        String id;
        String name;
        String address;
        int phoneNumber;
        String manager;
        Branch branch;
        try {
            System.out.print("Enter the id: ");
            id = super.getScanner().nextLine();
            branch = branchesRecord.findBranchById(id);
            if (branch == null) {
                System.out.println("the branch does not exist");
                return;
            }
            System.out.print("Enter the name: ");
            name = super.getScanner().nextLine();

            System.out.print("Enter the address: ");
            address = super.getScanner().nextLine();

            System.out.print("Enter the phone number: ");
            phoneNumber = super.getScanner().nextInt();
            super.getScanner().nextLine();

            System.out.print("Enter the manager: ");
            manager = super.getScanner().nextLine();

            branch = new Branch(id, name, address, phoneNumber, manager);
            this.branchesRecord.update(id, branch);

        } catch (InputMismatchException ex) {
            System.out.println("Enter the correct phone number");
        } catch (InvalidBranchException ex){
            System.out.println(ex.getMessage());
        }

    }

    private void deleteBranch() {
        String id;
        Branch branch;
        System.out.print("Enter the id: ");
        id = super.getScanner().nextLine();
        branch = branchesRecord.findBranchById(id);
        if (branch == null) {
            System.out.println("the branch does not exist");
            return;
        }
        this.branchesRecord.delete(id);

    }

}
