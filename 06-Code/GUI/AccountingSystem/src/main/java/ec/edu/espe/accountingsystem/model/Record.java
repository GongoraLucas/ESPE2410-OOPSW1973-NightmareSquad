package ec.edu.espe.accountingsystem.model;

import ec.edu.espe.accountingsystem.exception.CredentialsNotFoundInPath;
import utils.MongoDbManager;

/**
 *
 * @author Lucas Gongora
 */
public abstract class Record {

    private MongoDbManager database;

    public Record() {
        try {
            database = new MongoDbManager("AccountingSystem");

        } catch ( CredentialsNotFoundInPath ex){
            System.out.println(ex.getMessage());
        }
       
    }

    /**
     * @return the database
     */
    public MongoDbManager getDatabase() {
        return database;
    }
    
    

}
