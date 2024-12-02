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

}
