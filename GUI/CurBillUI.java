package GUI;

import business.Business;
import business.ordering.Bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurBillUI extends JFrame {
    private JPanel CurBill;
    private JTextField tableId;
    private JButton showBillButton;
    private JFormattedTextField insertTableIdFormattedTextField;
    private int tableid;

    public CurBillUI(Business  business) {

        setTitle("CurBill UI");
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setContentPane(CurBill);
        showBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tableid = Integer.parseInt(tableId.getText());

                    Bill bill = business.getBill(tableid);
                    if (bill != null) {
                        String billDetails = bill.generateBillDetails();
                        BillUI billUI = new BillUI(billDetails, tableid, business, "worker");
                    } else {
                        JOptionPane.showMessageDialog(null, "No bill found for Table ID: " + tableid);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid table ID.");
                }
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        CurBill = new JPanel();
        CurBill.setLayout(new GridBagLayout());
        tableId = new JTextField();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        CurBill.add(tableId, gbc);
        showBillButton = new JButton();
        showBillButton.setText("Show Bill");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        CurBill.add(showBillButton, gbc);
        insertTableIdFormattedTextField = new JFormattedTextField();
        insertTableIdFormattedTextField.setText("Insert Table Id : ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        CurBill.add(insertTableIdFormattedTextField, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return CurBill;
    }

}
