package ui.components;

import ui.AddMenuPanel;
import ui.SpendingTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//loads previous data
public class LoadButton implements ActionListener {
    private SpendingTracker st;
    private JButton load;

    public LoadButton(SpendingTracker st, AddMenuPanel p) {
        load = new JButton("Load");
        load.addActionListener(this);
        p.add(load);
        this.st = st;
    }

    public void actionPerformed(ActionEvent e) {
        st.loadCategories();
    }
}
