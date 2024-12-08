package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.accountingsystem.model.Inventory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManagerInventory {

    private static final String FILE_PATH = "Inventory.json";
    private Gson gson;

    public FileManagerInventory() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveInventory(Inventory inventory) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(inventory, writer);
            System.out.println("Inventory saved successfully to " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error saving inventory: " + e.getMessage());
        }
    }

    public Inventory loadInventory() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, Inventory.class);
        } catch (IOException e) {
            System.err.println("Error loading inventory: " + e.getMessage());
            return new Inventory(new ArrayList<>()); // Return an empty inventory if loading fails
        }
    }
}