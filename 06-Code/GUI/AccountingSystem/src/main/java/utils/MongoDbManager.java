package utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ec.edu.espe.accountingsystem.exception.VariablesNotFoundInPathException;
import org.bson.Document;

import java.util.*;

public class MongoDbManager {

    private String uri;
    private String dbname;
    private MongoClient client;
    private MongoDatabase database;
    private Gson gson;

    public MongoDbManager(String dbname) throws VariablesNotFoundInPathException {
        this.dbname = dbname;
        this.gson = new Gson();
        initializeConnection();
    }

    private void initializeConnection() throws VariablesNotFoundInPathException {
        try {
            String user = System.getenv("MONGO_USER");
            String password = System.getenv("MONGO_PASSWORD");

            if (user == null || password == null) {
                throw new VariablesNotFoundInPathException();
            }

            System.out.println("Connecting with user: " + user);

            this.uri = "mongodb+srv://" + user + ":" + password + "@cluster0.y73d4.mongodb.net/";
            this.client = MongoClients.create(uri);
            connectDB();
        } catch (VariablesNotFoundInPathException ex) {
            throw ex;
        } catch (MongoException ex) {
            System.err.println("Error creating MongoDB client: " + ex.getMessage());
        }
    }

    public void connectDB() {
        try {
            if (client != null) {
                this.database = client.getDatabase(this.dbname);
                System.out.println("Connected to database: " + this.dbname);
            } else {
                System.err.println("MongoClient is not initialized.");
            }
        } catch (MongoException ex) {
            System.err.println("Can't connect to the database: " + ex.getMessage());
        }
    }

    public boolean insertData(String collectionName, Object object) {
        if (isInvalidCollection(collectionName)) return false;

        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Map<String, Object> map = gson.fromJson(gson.toJson(object), Map.class);
            collection.insertOne(new Document(map));
            System.out.println("Inserted document into collection: " + collectionName);
            return true;
        } catch (MongoException ex) {
            System.err.println("MongoDB error inserting data into collection " + collectionName + " - " + ex.getMessage());
        } catch (JsonSyntaxException ex) {
            System.err.println("Error with JSON syntax while processing object - " + ex.getMessage());
        }
        return false;
    }

    public <T> ArrayList<T> readData(String collectionName, Class<T> objectType, Document query) {
        ArrayList<T> objectsFound = new ArrayList<>();
        if (isInvalidCollection(collectionName)) return objectsFound;

        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            FindIterable<Document> result = collection.find(query);
            for (Document doc : result) {
                T objectFound = gson.fromJson(doc.toJson(), objectType);
                objectsFound.add(objectFound);
            }
        } catch (MongoException ex) {
            System.err.println("Error retrieving data from collection " + collectionName + " - " + ex.getMessage());
        }
        return objectsFound;
    }

    public <T> ArrayList<T> readAllData(String collectionName, Class<T> objectType) {
        return readData(collectionName, objectType, new Document());
    }

    public boolean updateData(String collectionName, String id, Object newObject) {
        if (isInvalidCollection(collectionName)) return false;

        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Document query = new Document("id", id);
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
        } catch (MongoException ex) {
            System.err.println("Error updating data in collection " + collectionName + " - " + ex.getMessage());
        } catch (JsonSyntaxException ex) {
            System.err.println("Error with JSON syntax while processing object - " + ex.getMessage());
        }
        return false;
    }

    public boolean deleteData(String collectionName, String id) {
        if (isInvalidCollection(collectionName)) return false;

        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Document query = new Document("id", id);
            DeleteResult result = collection.deleteOne(query);
            if (result.getDeletedCount() > 0) {
                System.out.println("Deleted document from collection: " + collectionName);
                return true;
            } else {
                System.out.println("No matching document found for deletion.");
                return false;
            }
        } catch (MongoException e) {
            System.err.println("Error deleting data from collection " + collectionName + " - " + e.getMessage());
        }
        return false;
    }

    public void addItemInMap(String collectionName, String key, String subkey, float valueOfSubkey) {
        if (isInvalidCollection(collectionName)) return;

        try {
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
        } catch (MongoException e) {
            System.err.println("Error adding item to MongoDB in collection " + collectionName + ": " + e.getMessage());
        }
    }

    public void deleteKeyInMap(String collectionName, String key) {
        if (isInvalidCollection(collectionName)) return;

        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Document query = new Document("key", key);
            Document existingItem = collection.find(query).first();

            if (existingItem != null) {
                collection.deleteOne(query);
                System.out.println("Key deleted successfully in collection: " + collectionName);
            } else {
                System.out.println("The key does not exist.");
            }
        } catch (MongoException e) {
            System.err.println("Error deleting key from MongoDB in collection " + collectionName + ": " + e.getMessage());
        }
    }

    public void deleteSubkeyInMap(String collectionName, String key, String subkey) {
        if (isInvalidCollection(collectionName)) return;

        try {
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
        } catch (MongoException e) {
            System.err.println("Error deleting subkey from MongoDB in collection " + collectionName + ": " + e.getMessage());
        }
    }

    public HashMap<String, HashMap<String, Float>> readItemsFromMap(String collectionName) {
        HashMap<String, HashMap<String, Float>> map = new HashMap<>();
        if (isInvalidCollection(collectionName)) return map;

        try {
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

        } catch (MongoException e) {
            System.err.println("Error reading items from MongoDB collection " + collectionName + ": " + e.getMessage());
        }
        return map;
    }

    private boolean isInvalidCollection(String collectionName) {
        if (database == null || collectionName == null || collectionName.isEmpty()) {
            System.err.println("Invalid database connection or collection name.");
            return true;
        }
        return false;
    }

    public void closeConnection() {
        try {
            if (client != null) {
                client.close();
                System.out.println("Connection closed.");
            }
        } catch (MongoException ex) {
            System.err.println("Error closing connection: " + ex.getMessage());
        }
    }
}
