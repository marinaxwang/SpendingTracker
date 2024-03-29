package persistence;

import model.ListOfCategories;
import model.Category;
import model.Expense;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads list of category from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads list of category from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ListOfCategories read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseLOC(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses list of category from JSON object and returns it
    private ListOfCategories parseLOC(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ListOfCategories c = new ListOfCategories(name);
        addCategories(c, jsonObject);
        return c;
    }

    // MODIFIES: c
    // EFFECTS: parses category from JSON object and adds them to list of category
    private void addCategories(ListOfCategories c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("category");
        for (Object json : jsonArray) {
            JSONObject nextExpense = (JSONObject) json;
            addCategory(c, nextExpense);
        }
    }

    // MODIFIES: c
    // EFFECTS: parses category from JSON object and adds it to list of category
    private void addCategory(ListOfCategories c, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double amount = jsonObject.getDouble("amount");
        Category e = new Category(name, amount);
        c.addCategory(e);
    }
}
