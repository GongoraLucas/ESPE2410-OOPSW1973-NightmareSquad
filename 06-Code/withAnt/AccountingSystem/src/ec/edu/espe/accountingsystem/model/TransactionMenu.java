package ec.edu.espe.accountingsystem.model;

public class TransactionMenu extends Menu {

    private  TransactionsRecord transactionsRecord;

    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow

    public TransactionMenu() {
        super();
        this.transactionsRecord = new TransactionsRecord();
    }


    @Override
    public void processOption(int option) throws IllegalArgumentException {
        switch (option) {
            case 1:
                viewTransactions();
                break;
            case 2:
                updateTransactionPaymentStatus();
                break;
            case 3:
                deleteTransaction();
                break;
            case 4:
                super.setExecutionMenu(false);
                System.out.println(SUCCESS_COLOR + "Returning to the main menu..." + RESET);
                break;
            default:
                throw new IllegalArgumentException("Option must be between 1 and 4.");
        }
    }

    @Override
    public void showOptions() {
        System.out.println(HEADER_COLOR + "\tAccounting System\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Transaction record Menu" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. View transactions" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Update payment status" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Delete transactions" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Back to the main menu" + RESET);
    }
    
    
    public void viewTransactions() {
        try {
            System.out.printf(this.transactionsRecord.toString());
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error viewing transactions: " + e.getMessage() + RESET);
        }
    }

    public void updateTransactionPaymentStatus() {
        String transactionId;
        String paymentStatus;
        Transaction transaction;

        try {
            System.out.print( "Enter the ID of the transaction: " );
            transactionId = super.getScanner().nextLine();

            transaction = transactionsRecord.findTransactionById(transactionId);
            if (transaction == null) {
                System.out.println(ERROR_COLOR + "Transaction not found." + RESET);
                return;
            }

            System.out.print( "Enter the new payment status: " );
            paymentStatus = super.getScanner().nextLine();
            transaction.setPaymentStatus(paymentStatus);

            transactionsRecord.update(transactionId, transaction);
            transactionsRecord.updateJsonFile();
            System.out.println(SUCCESS_COLOR + "Transaction payment status updated successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error updating payment status: " + e.getMessage() + RESET);
        }
    }

    public void deleteTransaction() {
        String id;

        try {
            System.out.print("Enter the ID of the transaction to delete: ");
            id = super.getScanner().nextLine();

            transactionsRecord.delete(id);
            transactionsRecord.updateJsonFile();
            System.out.println(SUCCESS_COLOR + "Transaction deleted successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error deleting transaction: " + e.getMessage() + RESET);
        }
    }
}
