package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import javax.swing.*;
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
    // EFFECTS: adds category to this workroom
    public void addCategory(Category c) {
        category.add(c);
        //EventLog.getInstance().logEvent(new Event("New Expense Added!"));
    }

    public void addExpenseLogAdd(String expenseName, String amountName) {
        EventLog.getInstance().logEvent(new Event("$" + amountName + " added to " + expenseName));
    }

    // MODIFIES: this
    // EFFECTS: adds category to this workroom
    public void removeCategory(int index) {
        if (index < category.size()) {
            category.remove(index);
        }
        EventLog.getInstance().logEvent(new Event("expense removed!"));
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
