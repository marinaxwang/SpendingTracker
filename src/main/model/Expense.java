package model;

public class Expense {
    private Category category;
    private String note;
    private Person person;

    public Expense(Category c, String n, Person p) {
        category = c;
        note = n;
        person = p;
    }

    public Category getCategory() {
        return category;
    }

    public String getNote() {
        return note;
    }

    public Person getPerson() {
        return person;
    }

}
