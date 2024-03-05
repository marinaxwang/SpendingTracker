package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents an expense having a category and an amount
public class Expense implements Writable {
    private String name;
    private double amount;

    //add another field (name of expense)

    // EFFECTS: constructs an expense with a category and an amount
    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }
    public double getAmount() {
        return amount;
    }


    // EFFECTS: returns string representation of this expense
    public String toString() {
        return name + ": $" + amount;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("amount", amount);
        return json;
    }
}
