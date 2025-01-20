package ec.edu.espe.accountingsystem.controller;

import ec.edu.espe.accountingsystem.controller.DAO;
import ec.edu.espe.accountingsystem.model.Transaction;
import java.util.ArrayList;

/**
 *
 * @author Lucas Gongora
 */
public class TransactionsDAO extends DAO{

   private static String collection="transactions";

    

    public TransactionsDAO() {
       super();
    }

    /**
     * @return the transactions
     */
    public ArrayList<Transaction> getTransactions() {
        return super.getDatabase().readAllData(collection, Transaction.class);
    }


    public void add(Transaction transaction) {
        super.getDatabase().insertData(collection, transaction);

    }
    
    public Transaction findTransactionById(String transactionId) {
        for (Transaction transaction : this.getTransactions()) {
            if (transaction.getId().equals(transactionId)) {
                return transaction;
            }
        }
        return null;
    }

    public void delete(String transactionId) {
        super.getDatabase().deleteData(collection, transactionId);
    }

    public void update(String transactionId, Transaction transaction) {
        super.getDatabase().updateData(collection, transactionId, transaction);

    }

    public ArrayList<Transaction> getTransactionByType(String type) {
        ArrayList<Transaction> transactionsByType;

        transactionsByType = new ArrayList<>();

        for (Transaction transaction : this.getTransactions()) {
            if (transaction.getType().equals(type)) {
                transactionsByType.add(transaction);
            }
        }
        return transactionsByType;

    }

}
