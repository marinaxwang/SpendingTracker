package ui.components;

import ui.AddExpensePanel;
import ui.SpendingTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//remove expense button to expense an expense
public class RemoveExpenseButton implements ActionListener {
    private SpendingTracker st;
    private JButton removeCategory;

    public RemoveExpenseButton(SpendingTracker st, AddExpensePanel p) {
        removeCategory = new JButton("Remove Expense");
        removeCategory.addActionListener(this);
        p.add(removeCategory);
        this.st = st;
    }

    public void actionPerformed(ActionEvent e) {
        //st.removeCategory();
    }

}
