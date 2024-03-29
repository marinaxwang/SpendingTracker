package ui.components;

import ui.AddExpensePanel;
import ui.SpendingTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddExpenseButton implements ActionListener {
    private SpendingTracker st;
    private JButton addCategory;

    public AddExpenseButton(SpendingTracker st, AddExpensePanel p) {
        addCategory = new JButton("Add Expense");
        addCategory.addActionListener(this);
        p.add(addCategory);
        this.st = st;
    }

    public void actionPerformed(ActionEvent e) {
        st.addCategory();
    }

}
