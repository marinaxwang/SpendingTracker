package ui;

import ui.components.AddExpenseButton;
import ui.components.RemoveExpenseButton;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



//referenced from https://docs.oracle.com/javase/tutorial/displayCode.html?code=
// https://docs.oracle.com/javase/tutorial/uiswing/examples/components/ListDemoProject/src/components/ListDemo.java
public class AddExpensePanel extends JPanel implements ListSelectionListener {
    private SpendingTracker st;
    AddExpenseButton button;

    private JList list;
    private DefaultListModel listModel;

    private static final String add = "Add";
    private static final String remove = "Remove";
    private JButton removeButton;
    private JTextField expenseName;
    private JTextField amountName;

    private Object[] object = {"", "", ""};
    private final String[] columnNames = {"Name", "Budget", "Amount"};
    private DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    private static final int WIDTH = 400;
    private static final int HEIGHT = 250;

    public AddExpensePanel(SpendingTracker st) {
        super(new BorderLayout());
        button = new AddExpenseButton(st, this);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        listModel = new DefaultListModel();

        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);

        JButton addButton = new JButton(add);
        HireListener hireListener = new HireListener(addButton);
        addButton.setActionCommand(add);
        addButton.addActionListener(hireListener);
        addButton.setEnabled(false);

        removeButton = new JButton(remove);
        removeButton.setActionCommand(remove);
        removeButton.addActionListener(new FireListener());


        createTextFields(hireListener);

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = createPanel(addButton);

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
        this.st = st;
    }

    public JPanel createPanel(JButton addButton) {
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(removeButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(expenseName);
        buttonPane.add(amountName);
        buttonPane.add(addButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        return buttonPane;
    }

    public void createTextFields(HireListener hireListener) {
        expenseName = new JTextField(5);
        expenseName.addActionListener(hireListener);
        expenseName.getDocument().addDocumentListener(hireListener);

        amountName = new JTextField(5);
        amountName.addActionListener(hireListener);
        amountName.getDocument().addDocumentListener(hireListener);
    }


    class FireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int index = list.getSelectedIndex();
            listModel.remove(index);

            int size = listModel.getSize();

            if (size == 0) { //Nobody's left, disable firing.
                removeButton.setEnabled(false);

            } else { //Select an index.
                if (index == listModel.getSize()) {
                    //removed item in last position
                    index--;
                    st.removeCategory(index);
                }
                st.addExpenseLogAdd();

                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }


        }
    }

    //This listener is shared by the text field and the hire button.
    class HireListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;

        public HireListener(JButton button) {
            this.button = button;
        }

        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
            String name = expenseName.getText();
            String amount = amountName.getText();
            //User didn't type in anything
            if (name.equals("") || amount.equals("")) {
                Toolkit.getDefaultToolkit().beep();
                expenseName.requestFocusInWindow();
                expenseName.selectAll();
                amountName.requestFocusInWindow();
                amountName.selectAll();
                return;
            }

            int index = list.getSelectedIndex(); //get selected index
            if (index == -1) { //no selection, so insert at beginning
                index = 0;
            } else {           //add after the selected item
                index++;
                st.addCategory();
            }

            listModel.insertElementAt(expenseName.getText() + " $" + amountName.getText(), index);
            st.addExpenseLog(expenseName.getText(), amountName.getText());
            //If we just wanted to add to the end, we'd do this:
            //listModel.addElement(employeeName.getText());

            //Reset the text field.
            expenseName.requestFocusInWindow();
            expenseName.setText("");
            amountName.requestFocusInWindow();
            amountName.setText("");

            //Select the new item and make it visible.
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }

        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }

        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                removeButton.setEnabled(false);

            } else {
                //Selection, enable the fire button.
                removeButton.setEnabled(true);
            }
        }
    }



}
