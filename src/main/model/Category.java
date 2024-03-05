package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a spending category having a name, a budget, an amount spent, and a list of expenses
public class Category implements Writable {
    private String name;
    private double budget;
    private double amountSpent;
    private List<Expense> expenses;

    // EFFECTS: construct a category with name set to parameter name, budget set to parameter budget
    //          amount spent set to 0, and an empty list of expenses
    public Category(String name, double budget) {
        this.name = name;
        this.budget = budget;
        this.amountSpent = 0.0;
        expenses = new ArrayList<>();
    }

    // EFFECTS: returns a string of the list of expenses
    public String listOfExpenses() {
        String allExpenses = "";
        if (expenses.isEmpty()) {
            return "There is no expenses under this category.";
        }
        for (Expense e : expenses) {
            String expenseAmount = String.format("%.2f", e.getAmount()); // get expense to 2 decimal places as string
            allExpenses += "- $" + expenseAmount + "\n";
        }

        return allExpenses;
    }

    // MODIFIES: this
    // EFFECTS: add an expense to the list of expenses
    public void addExpense(Expense e) {
        expenses.add(e);
    }

    public String getName() {
        return name;
    }


    // EFFECTS: returns an unmodifiable list of expenses in this category
    public List<Expense> getExpenses() {
        return Collections.unmodifiableList(expenses);
    }

    // EFFECTS: returns number of expenses in this category
    public int numExpenses() {
        return expenses.size();
    }

    // REQUIRES: e > 0
    // MODIFIES: this
    // EFFECTS: add the amount of parameter e to the amount spent in this category
    public void addExpenseOfTypeDouble(double e) {
        amountSpent += e;
    }

    public double getBudget() {
        return budget;
    }

    public double getAmountSpent() {
        return amountSpent;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("thingies", thingiesToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray thingiesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Expense e : expenses) {
            jsonArray.put(e.toJson());
        }

        return jsonArray;
    }


    //public List getExpenses() {
    //    return expenses;
    //}


}
