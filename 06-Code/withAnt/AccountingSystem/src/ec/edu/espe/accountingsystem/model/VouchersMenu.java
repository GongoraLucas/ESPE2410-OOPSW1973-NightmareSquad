package ec.edu.espe.accountingsystem.model;

public class VouchersMenu extends Menu {

    private  VouchersRecord vouchersRecord;

    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow

    public VouchersMenu() {
        super();
        this.vouchersRecord = new VouchersRecord();
    }


    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                showVouchers();
                break;
            case 2:
                deleteVoucher();
                break;
            case 3:
                super.setExecutionMenu(false);
                break;
            default:
                throw new IllegalArgumentException("Option must be between 1 and 3.");
        }
    }

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\tVoucher\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Transaction record Menu" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. View transactions" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Delete transactions" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Back to the main menu" + RESET);
    }
    
    
    private void showVouchers() {
        try {
            System.out.printf(this.vouchersRecord.toString());
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error viewing transactions: " + e.getMessage() + RESET);
        }
    }

  

    private void deleteVoucher() {
        String id;
        Voucher voucher;

        try {
            System.out.print("Enter the ID of the transaction to delete: " );
            id = super.getScanner().nextLine();
            voucher = this.vouchersRecord.findVoucherById(id);
            if (voucher == null){
                System.out.println("The voucher does not exist");
                return;
            }
            vouchersRecord.delete(id);
            System.out.println(SUCCESS_COLOR + "Transaction deleted successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error deleting transaction: " + e.getMessage() + RESET);
        }
    }
}
