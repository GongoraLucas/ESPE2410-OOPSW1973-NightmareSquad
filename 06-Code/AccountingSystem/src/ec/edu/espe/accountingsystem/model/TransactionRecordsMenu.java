package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.model.Transaction;
import ec.edu.espe.accountingsystem.model.TransactionsRecord;
import java.util.Locale;
import java.util.Scanner;

public class TransactionRecordsMenu {

    private Scanner scanner;
    private int option;
    private boolean executionMenu;
    private TransactionsRecord transactionsRecord;

    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String HEADER_COLOR = "\u001B[34m";  // Blue
    private static final String SUBHEADER_COLOR = "\u001B[35m";  // Magenta
    private static final String MENU_OPTION_COLOR = "\u001B[32m";  // Green
    private static final String ERROR_COLOR = "\u001B[31m";  // Red
    private static final String SUCCESS_COLOR = "\u001B[33m";  // Yellow

    public TransactionRecordsMenu(TransactionsRecord transactionsRecord) {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
        this.option = 0;
        this.executionMenu = true;
        this.transactionsRecord = transactionsRecord;
    }

    public void runMenu() {
        do {
            try {
                displayTransactionMenu();
                option = getUserInput();

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
                        executionMenu = false;
                        System.out.println(SUCCESS_COLOR + "Returning to the main menu..." + RESET);
                        break;
                    default:
                        System.out.println(ERROR_COLOR + "Invalid option. Please select a number between 1 and 4." + RESET);
                }
            } catch (Exception e) {
                System.out.print(ERROR_COLOR + "An error occurred: " + e.getMessage() + RESET);
                scanner.nextLine(); 
            }
        } while (executionMenu);
    }

    private void displayTransactionMenu() {
        System.out.println(HEADER_COLOR + "\tAccounting System\t" + RESET);
        System.out.println(SUBHEADER_COLOR + "Transaction record Menu" + RESET);
        System.out.println(MENU_OPTION_COLOR + "1. View transactions" + RESET);
        System.out.println(MENU_OPTION_COLOR + "2. Update payment status" + RESET);
        System.out.println(MENU_OPTION_COLOR + "3. Delete transactions" + RESET);
        System.out.println(MENU_OPTION_COLOR + "4. Back to the main menu" + RESET);
        System.out.print(MENU_OPTION_COLOR + "Enter the option number: " + RESET);
    }

    private int getUserInput() {
        int input = -1;
        while (input == -1) {
            try {
                input = scanner.nextInt();
                scanner.nextLine(); 
                if (input < 1 || input > 4) {
                    System.out.println(ERROR_COLOR + "Please enter a valid option between 1 and 4." + RESET);
                    input = -1; 
                }
            } catch (Exception e) {
                System.out.println(ERROR_COLOR + "Invalid input. Please enter a valid number: " + RESET);
                scanner.nextLine(); 
            }
        }
        return input;
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
            System.out.print(MENU_OPTION_COLOR + "Enter the ID of the transaction: " + RESET);
            transactionId = scanner.nextLine();

            transaction = transactionsRecord.findTransactionById(transactionId);
            if (transaction == null) {
                System.out.println(ERROR_COLOR + "Transaction not found." + RESET);
                return;
            }

            System.out.print(MENU_OPTION_COLOR + "Enter the new payment status: " + RESET);
            paymentStatus = scanner.nextLine();
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
            System.out.print(MENU_OPTION_COLOR + "Enter the ID of the transaction to delete: " + RESET);
            id = scanner.nextLine();

            transactionsRecord.delete(id);
            transactionsRecord.updateJsonFile();
            System.out.println(SUCCESS_COLOR + "Transaction deleted successfully." + RESET);
        } catch (Exception e) {
            System.out.println(ERROR_COLOR + "Error deleting transaction: " + e.getMessage() + RESET);
        }
    }
}
