package GUI;

import business.Business;
import business.ordering.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;


public class StorageHandlingOUI2 extends JPanel {
    private JPanel topPanel;

    public StorageHandlingOUI2(Business business) {


        setSize(400, 680);
        setLayout(new BorderLayout());


        // Top panel for dish names and buttons
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        // Bottom panel with centered button
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        JButton button = new JButton("Order");
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        //Button Order
        button.addActionListener(e->{
            //createSupplierOrder();
            System.out.println("Print Supplier Order.");
        });
        // Bottom panel with centered button
        bottomPanel.add(button, BorderLayout.CENTER);

        loadPanel(business);

        JScrollPane scrollPane = new JScrollPane(topPanel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);

    }


    private void loadPanel(Business business){
        // Create table model with two columns: Name and Quantity
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Name", "Quantity"}, 0);

        // Create JTable with the table model
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        ArrayList<Item> storage = business.getStorage().getLowItems();
        for (Item item : storage) {
            tableModel.addRow(new Object[]{item.getName(), item.getQuantity()});
        }
        topPanel.revalidate();
        topPanel.repaint();
    }

}
