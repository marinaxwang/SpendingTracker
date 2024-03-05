package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfCategories implements Writable {
    private String name;
    private ArrayList<Category> category;


    public ListOfCategories(String name) {
        this.name = name;
        category = new ArrayList<>();
    }

    // EFFECTS: returns a list of categories
    public ArrayList getListOfCategories() {
        return category;
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds thingy to this workroom
    public void addCategory(Category c) {
        category.add(c);
    }

    // EFFECTS: returns an unmodifiable list of expenses in this category
    public List<Category> getCategories() {
        return Collections.unmodifiableList(category);
    }

    // EFFECTS: returns number of expenses in this category
    public int numExpenses() {
        return category.size();
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("category", categoriesToJson());
        return json;
    }

    // EFFECTS: returns categories in this list of categories as a JSON array
    private JSONArray categoriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Category c : category) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }
}
