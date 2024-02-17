package model;

public class Expense {
    private Category category;
    private double amount;
    private User person;


    public Expense(Category c, double a, User p) {
        category = c;
        amount = a;
        person = p;
    }

    public Category getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public User getPerson() {
        return person;
    }

}
