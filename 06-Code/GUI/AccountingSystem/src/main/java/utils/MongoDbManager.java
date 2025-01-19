package utils;

import com.google.gson.Gson;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.accountingsystem.exception.CredentialsNotFoundInPath;
import org.bson.Document;

import java.util.*;

public class MongoDbManager {

    private String uri;
    private String dbname;
    private MongoClient client;
    private MongoDatabase database;
    private Gson gson;

    public MongoDbManager(String dbname) throws CredentialsNotFoundInPath {
        String user = System.getenv("MONGO_USER");
        String password = System.getenv("MONGO_PASSWORD");
        System.out.println("CORRIENDO" + user + "  -->"+password);

        if (user == null || password == null) {
            throw new CredentialsNotFoundInPath();
        }

        this.uri = "mongodb+srv://" + user + ":" + password + "@cluster0.y73d4.mongodb.net/";

        if (dbname == null || dbname.isEmpty()) {
            throw new IllegalArgumentException("Database name cannot be null or empty");
        }

        this.dbname = dbname;
        this.client = MongoClients.create(uri);
        this.gson = new Gson();
    }

    public void connectDB() {
        try {
            this.database = client.getDatabase(this.dbname);
            System.out.println("Connected to database: " + this.dbname);
        } catch (MongoException e) {
            System.err.println("Can't connect to the database: " + e.getMessage());
        }
    }

    public boolean insertData(String collectionName, Object object) {
        if (database == null || collectionName == null || collectionName.isEmpty()) {
            System.err.println("Invalid database connection or collection name.");
            return false;
        }

        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Map<String, Object> map = gson.fromJson(gson.toJson(object), Map.class);
            collection.insertOne(new Document(map));
            System.out.println("Inserted document into collection: " + collectionName);
            return true;
        } catch (Exception e) {
            System.err.println("Error inserting data into collection " + collectionName + " - " + e.getMessage());
            return false;
        }
    }

    public <T> ArrayList<T> readData(String collectionName, Class<T> clazz, Document query) {
        ArrayList<T> results = new ArrayList<>();
        if (database == null || collectionName == null || collectionName.isEmpty()) {
            System.err.println("Invalid database connection or collection name.");
            return results;
        }

        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            FindIterable<Document> result = collection.find(query);
            for (Document doc : result) {
                T obj = gson.fromJson(doc.toJson(), clazz);
                results.add(obj);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving data from collection " + collectionName + " - " + e.getMessage());
        }
        return results;
    }

    public <T> ArrayList<T> readAllData(String collectionName, Class<T> clazz) {
        return readData(collectionName, clazz, new Document());
    }

    public boolean updateData(String collectionName, String id, Object newObject) {
        if (database == null || collectionName == null || collectionName.isEmpty()) {
            System.err.println("Invalid database connection or collection name.");
            return false;
        }

        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Document query = new Document("id", id);  // Usamos String id aquí
            Map<String, Object> map = gson.fromJson(gson.toJson(newObject), Map.class);
            Document updateDoc = new Document("$set", new Document(map));

            UpdateResult result = collection.updateOne(query, updateDoc);
            if (result.getMatchedCount() > 0) {
                System.out.println("Updated document in collection: " + collectionName);
                return true;
            } else {
                System.out.println("No matching document found for update.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error updating data in collection " + collectionName + " - " + e.getMessage());
            return false;
        }
    }

    public boolean deleteData(String collectionName, String id) {
        if (database == null || collectionName == null || collectionName.isEmpty()) {
            System.err.println("Invalid database connection or collection name.");
            return false;
        }

        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Document query = new Document("id", id);  // Usamos String id aquí
            DeleteResult result = collection.deleteOne(query);

            if (result.getDeletedCount() > 0) {
                System.out.println("Deleted document from collection: " + collectionName);
                return true;
            } else {
                System.out.println("No matching document found for deletion.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error deleting data from collection " + collectionName + " - " + e.getMessage());
            return false;
        }
    }

    public void addItemInMap(String collectionName, String key, String subkey, float valueOfSubkey) {
        try {
            if (collectionName == null || collectionName.isEmpty()) {
                System.err.println("Collection name cannot be null or empty.");
                return;
            }

            MongoCollection<Document> collection = database.getCollection(collectionName);

            Document query = new Document("key", key);
            Document existingItem = collection.find(query).first();

            if (existingItem != null) {
                Document updateDoc = new Document("$set", new Document("items." + subkey, valueOfSubkey));
                collection.updateOne(query, updateDoc);
            } else {
                Document newItem = new Document("key", key);
                newItem.append("items", new Document(subkey, valueOfSubkey));
                collection.insertOne(newItem);
            }

            System.out.println("Item added or updated successfully in collection: " + collectionName);
        } catch (Exception e) {
            System.err.println("Error adding item to MongoDB in collection " + collectionName + ": " + e.getMessage());
        }
    }

    public void deleteKeyInMap(String collectionName, String key) {
        try {
            if (collectionName == null || collectionName.isEmpty()) {
                System.err.println("Collection name cannot be null or empty.");
                return;
            }

            MongoCollection<Document> collection = database.getCollection(collectionName);

            Document query = new Document("key", key);
            Document existingItem = collection.find(query).first();

            if (existingItem != null) {
                collection.deleteOne(query);
                System.out.println("Key deleted successfully in collection: " + collectionName);
            } else {
                System.out.println("The key does not exist.");
            }
        } catch (Exception e) {
            System.err.println("Error deleting key from MongoDB in collection " + collectionName + ": " + e.getMessage());
        }
    }

    public void deleteSubkeyInMap(String collectionName, String key, String subkey) {
        try {
            if (collectionName == null || collectionName.isEmpty()) {
                System.err.println("Collection name cannot be null or empty.");
                return;
            }

            MongoCollection<Document> collection = database.getCollection(collectionName);

            Document query = new Document("key", key);
            Document existingItem = collection.find(query).first();

            if (existingItem != null) {
                Document updateDoc = new Document("$unset", new Document("items." + subkey, ""));
                UpdateResult result = collection.updateOne(query, updateDoc);

                if (result.getModifiedCount() > 0) {
                    System.out.println("Subkey deleted successfully in collection: " + collectionName);
                } else {
                    System.out.println("The subkey does not exist.");
                }
            } else {
                System.out.println("The key does not exist.");
            }
        } catch (Exception e) {
            System.err.println("Error deleting subkey from MongoDB in collection " + collectionName + ": " + e.getMessage());
        }
    }

    public HashMap<String, HashMap<String, Float>> readItemsFromMap(String collectionName) {
        HashMap<String, HashMap<String, Float>> map = new HashMap<>();
        try {
            if (collectionName == null || collectionName.isEmpty()) {
                System.err.println("Collection name cannot be null or empty.");
                return map;
            }

            MongoCollection<Document> collection = database.getCollection(collectionName);
            FindIterable<Document> documents = collection.find();

            for (Document doc : documents) {
                String key = doc.getString("key");
                Document itemsDoc = (Document) doc.get("items");

                HashMap<String, Float> submap = new HashMap<>();
                for (String subkey : itemsDoc.keySet()) {
                    submap.put(subkey, itemsDoc.getDouble(subkey).floatValue());
                }

                map.put(key, submap);
            }

        } catch (Exception e) {
            System.err.println("Error reading items from MongoDB collection " + collectionName + ": " + e.getMessage());
        }

        return map;
    }
    
    

    public void closeConnection() {
        try {
            if (client != null) {
                client.close();
                System.out.println("Connection closed.");
            }
        } catch (Exception e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
}
