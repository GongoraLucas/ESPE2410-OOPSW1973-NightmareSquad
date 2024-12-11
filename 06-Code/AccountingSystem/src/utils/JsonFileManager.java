package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.accountingsystem.model.Inventory;
import ec.edu.espe.accountingsystem.model.Product;
import ec.edu.espe.accountingsystem.model.Transaction;
import ec.edu.espe.accountingsystem.model.User;
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

        this.saveItems(items);

    }

    public <T> void update(String id, Object updatedItem, Class<T> typeItem) {
        ArrayList<T> items = this.read(typeItem);

        for (int i = 0; i < items.size(); i++) {
            boolean conditionForProduct = items.get(i) instanceof Product && ((Product) items.get(i)).getId().equals(id);
            boolean conditionForTransaction = items.get(i) instanceof Transaction && ((Transaction) items.get(i)).getId().equals(id);

            if (conditionForProduct || conditionForTransaction) {
                items.set(i, (T) updatedItem);
                this.saveItems(items);
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
                this.saveItems(items);
                return;
            }
        }
        System.out.println("Product not found");
    }

    public <T> void saveItems(ArrayList<T> objectsGroup) {
        try (FileWriter writer = new FileWriter(this.filePath)) {
            this.gson.toJson(objectsGroup, writer);
            System.out.println("saved successfully to " + this.filePath);
        } catch (IOException e) {
            System.err.println("Error saving the list of items to the file. The operation could not be completed.");
        }
    }

    public void saveUsers(User[] users) {
        try (FileWriter writer = new FileWriter(this.filePath)) {
            if (users.length != 2) {
                throw new IllegalArgumentException("There must be only two users");
            }
            this.gson.toJson(users,writer);

        } catch (IOException ex) {
            System.out.println("Error saving the users");
        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }
    
    public User[] readUsers(){
       User[] users;
       users= new User[2];
       try(BufferedReader reader = new BufferedReader(new FileReader(this.filePath))){
           StringBuilder json;
           String line;
           json= new StringBuilder();
           line = reader.readLine();
           while(line != null){
               json.append(line);
               line = reader.readLine(); 
           }
           Type usersArray = new TypeToken<User[]>(){}.getType();
           users = gson.fromJson(json.toString(),usersArray );
           return users;
           
       }catch (FileNotFoundException ex){
           return new User[]{null,null};
       }catch (IOException ex){
           System.out.println("Error reading the users");
           return new User[]{null,null};
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
            
            return new ArrayList<T>();
        } catch (IOException ex) {
            System.out.println("Error -> " + ex.getMessage());
            return new ArrayList<T>();
        }
        return items;
    }

}
