package ec.edu.espe.accountingsystem.model;

import utils.JsonFileManager;
import java.util.ArrayList;

/**
 *
 * @author Lucas Gongora
 */
public class TransactionsRecord {

    private String fileName;
    private JsonFileManager transactionsJson;
    private ArrayList<Transaction> transactions;

    @Override
    public String toString() {
        StringBuilder content;

        content = new StringBuilder();

        content.append(String.format("%20s %20s %20s %40s %20s %20s\n",
                "ID", "Transaction Type", "Voucher Id", "Issue Date", "Payment method", "Total"));
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Transaction transaction : this.transactions) {
            content.append(transaction.toString());
        }

        return content.toString();
    }

    public TransactionsRecord() {
        this.transactionsJson = new JsonFileManager("Transactions.json");
        this.transactions = this.transactionsJson.read(Transaction.class);
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
        this.transactionsJson.add(transaction, Transaction.class);

    }
    
    public Transaction findTransactionById(String transactionId) {
        for (Transaction transaction : this.transactions) {
            if (transaction.getId().equals(transactionId)) {
                return transaction;
            }
        }
        return null;
    }

    public void delete(String transactionId) {
        this.transactionsJson.delete(transactionId, Transaction.class);
    }

    public void update(String transactionId, Transaction transaction) {
        this.transactionsJson.update(transactionId, transaction, Transaction.class);

    }

    public void updateJsonFile() {
        this.transactions = this.transactionsJson.read(Transaction.class);
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
