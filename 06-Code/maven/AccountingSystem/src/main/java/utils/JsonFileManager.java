package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.accountingsystem.model.User;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class JsonFileManager {

    private String filePath;
    private Gson gson;

    public JsonFileManager(String filePath) {
        gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
        this.filePath = filePath;
    }

    public <T> void add(Object item, Class<T> typeItem) {
        ArrayList<T> items;

        items = this.read(typeItem);

        items.add((T) item);

        this.saveItems(items);

    }

    public <T extends Identifiable> void update(String id, Object updatedItem, Class<T> typeItem) {
        ArrayList<T> items = this.read(typeItem);

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getId().equals(id)) {
                items.set(i, (T) updatedItem);
                this.saveItems(items);
                return;
            }
        }
        System.out.println("Product not found");
    }

    public <T extends Identifiable> void delete(String id, Class<T> typeItem) {
        ArrayList<T> items = this.read(typeItem);

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                this.saveItems(items);
                return;
            }
        }
        System.out.println("Item not found");
    }

    public <T> void saveItems(ArrayList<T> objectsGroup) {
        try (FileWriter writer = new FileWriter(this.filePath)) {
            this.gson.toJson(objectsGroup, writer);
            System.out.println("saved successfully to " + this.filePath);
        } catch (IOException e) {
            System.err.println("Error saving the list of items to the file. The operation could not be completed.");
        }
    }

    public void addItemInMap(String key, String subkey, float valueOfSubkey) {
        HashMap<String, HashMap<String, Float>> map = new HashMap<>();

        map = readItemsFromMap();

        if (map.containsKey(key)) {
            map.get(key).put(subkey, valueOfSubkey);
        } else {
            HashMap<String, Float> subMap = new HashMap<>();
            subMap.put(subkey, valueOfSubkey);
            map.put(key, subMap);
        }
        saveItemsinMap(map);

    }

    public void deleteKeyInMap(String key) {
        HashMap<String, HashMap<String, Float>> map = new HashMap<>();

        map = readItemsFromMap();

        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            System.out.println("the key does not exist");
        }
    }

    public void deleteSubkeyInMap(String key, String subkey) {
        HashMap<String, HashMap<String, Float>> map = new HashMap<>();

        map = readItemsFromMap();

        if (map.containsKey(key)) {
            if (map.get(key).containsKey(subkey)) {

                map.get(key).remove(subkey);
            } else {
                System.out.println("the subkey does not exist");
            }

        } else {
            System.out.println("the key does not exist");
        }
    }

    public void updateSubkeyInMap(String key, String subkey, float valueOfSubkey) {
        HashMap<String, HashMap<String, Float>> map = new HashMap<>();

        map = readItemsFromMap();

        if (map.containsKey(key)) {
            if (map.get(key).containsKey(subkey)) {

                map.get(key).put(subkey, valueOfSubkey);
            } else {
                System.out.println("the subkey does not exist");
            }

        } else {
            System.out.println("the key does not exist");
        }

    }

    public void saveItemsinMap(HashMap<String, HashMap<String, Float>> map) {
        try (FileWriter writer = new FileWriter(this.filePath)) {
            this.gson.toJson(map, writer);
            System.out.println("saved successfully to " + this.filePath);
        } catch (IOException e) {
            System.err.println("Error saving the list of items to the file. The operation could not be completed.");
        }
    }

    public HashMap<String, HashMap<String, Float>> readItemsFromMap() {
        HashMap<String, HashMap<String, Float>> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {

            map = gson.fromJson(reader, HashMap.class);

            return map;

        } catch (FileNotFoundException ex) {
            return new HashMap<>();
        } catch (IOException ex) {
            System.out.println("could not read file content");
            return new HashMap<>();
        }
    }

    public void saveUsers(User[] users) {
        try (FileWriter writer = new FileWriter(this.filePath)) {
            if (users.length != 2) {
                throw new IllegalArgumentException("There must be only two users");
            }
            this.gson.toJson(users, writer);

        } catch (IOException ex) {
            System.out.println("Error saving the users");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void updateUserByType(String type, User updatedUser) {
        User[] users = this.readUsers();

        if (users.length != 2) {
            System.out.println("There must be exactly two users: one 'administrator' and one 'seller'");
            return;
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i].getType().equals(type)) {
                users[i] = updatedUser;
                this.saveUsers(users);
                return;
            }
        }
        System.out.println("The user not found");

    }

    public User[] readUsers() {
        User[] users;
        users = new User[2];
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            StringBuilder json;
            String line;
            json = new StringBuilder();
            line = reader.readLine();
            while (line != null) {
                json.append(line);
                line = reader.readLine();
            }
            Type usersArray = new TypeToken<User[]>() {
            }.getType();
            users = gson.fromJson(json.toString(), usersArray);
            return users;

        } catch (FileNotFoundException ex) {
            return new User[]{null, null};
        } catch (IOException ex) {
            System.out.println("Error reading the users");
            return new User[]{null, null};
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
