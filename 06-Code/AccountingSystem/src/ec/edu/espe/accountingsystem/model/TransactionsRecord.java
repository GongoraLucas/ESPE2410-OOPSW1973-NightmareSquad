package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Lucas Gongora
 */
public class TransactionsRecord {

    private ArrayList<Transaction> transactions;

    @Override
    public String toString() {
        return "TransactionsRecord{" + "transactions=" + transactions + '}';
    }

    public TransactionsRecord(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * @return the transactions
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions the transactions to set
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void add(Transaction transaction) {
        boolean newTransaction = this.transactions.add(transaction);

        if (newTransaction) {
            System.out.println("the transaction has been added successfully");

        }

    }

    public Transaction searchById(String transactionId) {

        for (Transaction transaction : this.transactions) {
            if (transaction.getId().equals(transactionId)) {
                return transaction;
            }
        }
        throw new Error("The transaction was not found");

    }

    public void delete(String transactionId) {
        this.transactions.remove(this.searchById(transactionId));
    }

    public ArrayList<Transaction> getTransactionByType(String type) {
        ArrayList<Transaction> transactionsByType;

        transactionsByType = new ArrayList<>();

        for (Transaction transaction : this.transactions) {
            if (transaction.getType().equals(type)) {
                transactionsByType.add(transaction);
            }
        }
        return transactionsByType;

    }

    public void viewTransactionsForConsole() {
        System.out.printf("%-10s %-20s %-10s %-8s %-30s %-15s\n", "ID", "Transaction Type", "Voucher Id", "Issue Date", "Payment method", "Total");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Transaction transaction : this.transactions) {
            System.out.printf("%-10s %-20s %-10s %-8s %-30s %-15s\n",
                    transaction.getId(), transaction.getType(),
                    transaction.getVoucher().getId(), transaction.getVoucher().getIssueDate(),
                    transaction.getVoucher().getPaymentMethod(), transaction.getVoucher().getTotal());
        }

    }

    public void viewOnlyTransactionForConsole(String transactionId) {
        System.out.printf("%-10s %-20s %-10s %-8s %-30s %-15s\n", "ID", "Transaction Type", "Voucher Id", "Issue Date", "Payment method", "Total");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        Transaction selectedTransaction = this.searchById(transactionId);

        System.out.printf("%-10s %-20s %-10s %-8s %-30s %-15s\n",
                selectedTransaction.getId(), selectedTransaction.getType(),
                selectedTransaction.getVoucher().getId(), selectedTransaction.getVoucher().getIssueDate(),
                selectedTransaction.getVoucher().getPaymentMethod(), selectedTransaction.getVoucher().getTotal());

    }
    public void viewTransactionsByTypeForConsole(String type) {
        System.out.printf("%-10s %-20s %-10s %-8s %-30s %-15s\n", "ID", "Transaction Type", "Voucher Id", "Issue Date", "Payment method", "Total");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        ArrayList<Transaction> selectedTransactions = this.getTransactionByType(type);
        for (Transaction transaction : selectedTransactions) {
            System.out.printf("%-10s %-20s %-10s %-8s %-30s %-15s\n",
                    transaction.getId(), transaction.getType(),
                    transaction.getVoucher().getId(), transaction.getVoucher().getIssueDate(),
                    transaction.getVoucher().getPaymentMethod(), transaction.getVoucher().getTotal());
        }
        

    }
    
    

}
