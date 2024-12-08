package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.accountingsystem.model.Inventory;
import ec.edu.espe.accountingsystem.model.Product;
import ec.edu.espe.accountingsystem.model.Transaction;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonFileManager {

    private String filePath;
    private Gson gson;

    public JsonFileManager(String filePath) {
        gson = new GsonBuilder().setLenient().create();
        this.filePath = filePath;
    }

    public <T> void create(Object item, Class<T> typeItem) {
        ArrayList<T> items;

        items = this.read(typeItem);

        items.add((T) item);

        this.save(items);

    }
    
    public <T> void update(String id, Object updatedItem, Class<T> typeItem) {
        ArrayList<T> items = this.read(typeItem);

        for (int i = 0; i < items.size(); i++) {
            boolean conditionForProduct = items.get(i) instanceof Product && ((Product) items.get(i)).getId().equals(id);
            boolean conditionForTransaction = items.get(i) instanceof Transaction && ((Transaction) items.get(i)).getId().equals(id);

            if (conditionForProduct || conditionForTransaction) {
                items.set(i, (T) updatedItem);
                this.save(items);
                return;
            }
        }
        System.out.println("Product not found");
    }
    public <T> void delete(String id, Class<T> typeItem) {
        ArrayList<T> items = this.read(typeItem);

        for (int i = 0; i < items.size(); i++) {
            boolean conditionForProduct = items.get(i) instanceof Product && ((Product) items.get(i)).getId().equals(id);
            boolean conditionForTransaction = items.get(i) instanceof Transaction && ((Transaction) items.get(i)).getId().equals(id);

            if (conditionForProduct || conditionForTransaction) {
                items.remove(items.get(i));
                this.save(items);
                return;
            }
        }
        System.out.println("Product not found");
    }
    
    

    public <T> void save(ArrayList<T> objectsGroup) {
        try (FileWriter writer = new FileWriter(this.filePath)) {
            this.gson.toJson(objectsGroup, writer);
            System.out.println("saved successfully to " + this.filePath);
        } catch (IOException e) {
            System.err.println("Error saving the list of items to the file. The operation could not be completed.");
        }
    }

    public <T> ArrayList<T> read(Class<T> typeItem) {
        ArrayList<T> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            Type listType = TypeToken.getParameterized(ArrayList.class, typeItem).getType();
            items = this.gson.fromJson(json.toString(), listType);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            return new ArrayList<T>();
        } catch (IOException ex) {
            System.out.println("Error -> " + ex.getMessage());
            return new ArrayList<T>();
        }
        return items;
    }

    
}
