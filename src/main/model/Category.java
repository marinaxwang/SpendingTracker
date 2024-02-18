package model;

import java.util.ArrayList;

public class Category {
    private String name;
    private double budget;
    private double amountSpent;
    private ArrayList<Expense> expenses;

    public Category(String name, double budget) {
        this.name = name;
        this.budget = budget;
        amountSpent = 0.0;
        expenses = new ArrayList<>();
    }

    public double remainingAmountToSpend() {
        double remainingAmount = budget - amountSpent;
        if (remainingAmount < 0) {
            return 0.0;
        }
        return remainingAmount;
    }

    public String listOfExpenses() {
        String allExpenses = "";
        if (expenses.isEmpty()) {
            return "There is no expenses under this category.";
        }
        for (Expense e : expenses) {
            String expenseAmount = String.format("%.2f", e.getAmount()); // get expense to 2 decimal places as string
            allExpenses += ": - $" + expenseAmount + "\n";
        }
        return allExpenses;
    }

    public boolean reachedLimit() {
        return (amountSpent >= budget);
    }

    public void addExpense(Expense e) {
        expenses.add(e);
        //amountSpent += e.getAmount();
    }

    public void addExpenseofTypeDouble(double e) {
        amountSpent += e;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public double getAmountSpent() {
        return amountSpent;
    }

}
