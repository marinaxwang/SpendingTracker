package ui.components;

import ui.AddMenuPanel;
import ui.SpendingTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveButton  implements ActionListener {
    private SpendingTracker st;
    private JButton quit;

    public SaveButton(SpendingTracker st, AddMenuPanel p) {
        quit = new JButton("Save");
        quit.addActionListener(this);
        p.add(quit);
        this.st = st;
    }

    public void actionPerformed(ActionEvent e) {
        st.saveCategories();
    }
}
