/*
package ui;

import model.Category;
import model.Expense;
import model.ListOfCategories;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCategory extends JPanel implements ActionListener {

    private ListOfCategories loc;
    private JTable table;
    private SpendingTracker st;
    private JButton button;
    private Object[] object = {"", ""};
    private final String[] columnNames = {"Name", "Amount"};
    private DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);


    //Constructor of Add Account
    public AddCategory(SpendingTracker st) {
        panel = new JPanel();
        this.loc = loc;
        this.st = st;
        setupButton();
        setupTable();
        setupPanel();
        setupFrame();
    }

    //EFFECTS: set up button for the AddAccount
    private void setupButton() {
        button = new JButton("Add");
        button.addActionListener(this);
    }

    //EFFECTS: set up frame for the AddAccount
    private void setupFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Add Category");
        frame.setSize(600, 300);
        frame.setVisible(true);

    }

    //EFFECTS: set up panel for the AddAccount
    private void setupPanel() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(scrollPane);
        panel.add(button);
    }

    //EFFECTS: set up the table for AddAccount
    private void setupTable() {
        tableModel.addRow(object);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(20, 10));
    }

    //MODIFIES: this
    //EFFECTS: perform this method
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = String.valueOf(table.getValueAt(0, 0));
        double amount = Double.parseDouble(String.valueOf(table.getValueAt(0, 1)));

        Expense c = new Expense(name, amount);

        //spendingTracker.removeTable();
        loc.addCategory(c);
        spendingTracker.updateListOfCategories(loc.getCategories());

    }
}
*/
