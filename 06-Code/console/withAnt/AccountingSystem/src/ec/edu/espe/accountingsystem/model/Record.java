package ec.edu.espe.accountingsystem.model;

import java.util.ArrayList;
import utils.Identifiable;
import utils.JsonFileManager;

/**
 *
 * @author David Cuichan
 */

public abstract class Record<T extends Identifiable> {
    protected JsonFileManager fileManager;
    
    public Record(String filename) {
        this.fileManager = new JsonFileManager(filename);
    }
    
    public void add(T item) {
        this.fileManager.add(item, (Class<T>) item.getClass());
    }
    
    public void delete(String id) {
        this.fileManager.delete(id, (Class<T>) getEntityClass());
    }
    
    public void update(String id, T item) {
        this.fileManager.update(id, item, (Class<T>) item.getClass());
    }
    
    public ArrayList<T> getAll() {
        return this.fileManager.read((Class<T>) getEntityClass());
    }
    
    protected abstract Class<T> getEntityClass();
    public abstract T findBranchById(String id);
    public abstract String toString();
}
