package ui;

import model.Category;
import model.Expense;
import model.ListOfCategories;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Spending tracker application
public class SpendingTracker extends JFrame {
    private static final String JSON_STORE = "./data/workroom.json";
    private Scanner input;
    private ListOfCategories loc;
    private ArrayList<Category> categories;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private AddExpensePanel expensePanel;
    private AddMenuPanel menuPanel;

    private JFrame frame;
    private JOptionPane popup = new JOptionPane();

    public SpendingTracker() {
        input = new Scanner(System.in);
        loc = new ListOfCategories("Spending Tracker");
        categories = loc.getListOfCategories();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }

    public void setExpensePanel(AddExpensePanel p) {
        expensePanel = p;
    }

    public void setMenuPanel(AddMenuPanel p) {
        menuPanel = p;
    }


    //MODIFIES: this
    //EFFECTS: quit
    public void quitAction() {
        JOptionPane popup = new JOptionPane();
        popup.showMessageDialog(frame, new JLabel(new ImageIcon("./data/goodbye.jpg")));
        frame.dispose();
    }




    // MODIFIES: this
    // EFFECTS: add a spending category with a name and a budget to the list of categories
    public void addCategory() {
        System.out.print("Enter the name of the spending category you wish to add\n");
        String name = input.next();
        System.out.print("Enter the budget for " + name + "\n");
        double budget = input.nextDouble();

        Category c = new Category(name, budget);
        categories.add(c);
        System.out.print(name + " is added to your list!\n");

    }

    // MODIFIES: this
    // EFFECTS: add an expense with an amount to a category, prints the amount spent over budget if valid
    private void addExpense() {
        if (!categories.isEmpty()) {
            //Category
            int categoryIndex = 0;

            Category category = findCategoryForExpense(categoryIndex);

            System.out.println("Please enter the name of your expense\n");
            String name = input.next();

            //Expense amount
            System.out.print("Enter the expense amount\n");
            double amount = input.nextDouble();
            category.addExpenseOfTypeDouble(amount);
            if (category.getAmountSpent() > category.getBudget()) {
                System.out.print("You exceeded the limit by " + (category.getAmountSpent() - category.getBudget()));
            }
            //create new expense
            Expense e = new Expense(name, amount);

            //add expense to its category's list of expenses
            category.addExpense(e);

            System.out.print("\nExpense added!");
        } else {
            checkEmptyArrays();
        }

    }


    // EFFECTS: tells user to add a spending category first if the list of categories is empty
    private void checkEmptyArrays() {
        if (categories.isEmpty()) {
            System.out.print("Please add a spending category first!\n");
        }
    }

    // EFFECTS: finds a category for an expense
    private Category findCategoryForExpense(int categoryIndex) {
        System.out.print("Here is a list of current categories, type the category name for this expense\n");
        for (Category c : categories) {
            System.out.print("\t" + c.getName() + "\n");
        }

        String categoryName = input.next();

        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getName().equals(categoryName)) {
                categoryIndex = i;
                break;
            }
        }
        Category category = categories.get(categoryIndex);
        return category;
    }

    // EFFECTS: prints the list of spending categories and list the list of expenses
    //          under the category the user selects
    private void seeListOfCategories() {
        if (!categories.isEmpty()) {
            System.out.print("Here is a list of your spending categories:\n");
            for (Category c : categories) {
                System.out.print("\t" + c.getName() + "\n");
            }

            System.out.print("Enter name of the category to see its list of expenses: \n");
            String categoryName = input.next();

            boolean categoryExists = false;
            for (Category c : categories) {
                if (categoryName.equals(c.getName())) {
                    getCategoryReport(c);
                    categoryExists = true;
                    break;
                }
            }
            if (!categoryExists) {
                System.out.print("The category you entered does not exist. \n");
            }


        } else {
            System.out.print("You currently have no spending category.\n");
        }
    }

    // EFFECTS: prints the budget, total amount spent, and the amount spend over the budget if valid
    private void getCategoryReport(Category c) {
        System.out.print(c.listOfExpenses());
        System.out.print("\nBudget: " + c.getBudget());
        System.out.print("\nTotal Amount Spent: " + c.getAmountSpent() + "\n");
        System.out.print("\nYou spent " + (c.getAmountSpent() - c.getBudget()) + " more than the budget.\n");
    }


    // EFFECTS: saves the workroom to file
    public void saveCategories() {
        try {
            jsonWriter.open();
            jsonWriter.write(loc);
            jsonWriter.close();
            System.out.println("Saved " + loc.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads loc from file
    private void loadCategories() {
        try {
            loc = jsonReader.read();
            System.out.println("Loaded " + loc.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}


