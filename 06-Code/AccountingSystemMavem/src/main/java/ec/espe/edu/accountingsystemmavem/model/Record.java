package ec.espe.edu.accountingsystemmavem.model;

import java.util.ArrayList;

/**
 *
 * @author Andrés Espinosa
 */
public class Record {
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
