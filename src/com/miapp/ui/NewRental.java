/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.miapp.ui;
import com.miapp.model.Invoice;
import com.miapp.model.Person;
import com.miapp.model.Movie;
import com.miapp.ui.ClientList;
import com.miapp.ui.MovieInventory;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class NewRental extends javax.swing.JInternalFrame {
    private ClientList clientList;
    private MovieInventory movieInventory;

    public NewRental(ClientList clientList, MovieInventory movieInventory) {
        initComponents();
        this.clientList = clientList;
        this.movieInventory = movieInventory;
        setClosable(true); // Allows closing the form
        populateMovieComboBoxes(); // Populate movie combo boxes with available movies
    }

    private void populateMovieComboBoxes() {
        DefaultTableModel movieModel = movieInventory.getMovieTableModel();
        for (int i = 0; i < movieModel.getRowCount(); i++) {
            String movieTitle = (String) movieModel.getValueAt(i, 0);
            String movieCode = (String) movieModel.getValueAt(i, 1); // Assuming the movie code is in the second column

            if (movieCode != null && movieTitle != null) {
                String displayString = movieCode + " - " + movieTitle;
                jComboBox1.addItem(displayString);
                jComboBox2.addItem(displayString);
                jComboBox3.addItem(displayString);
            }
        }
    }

    private boolean verifyClientExists(String clientName) {
        // Check if the client exists in the client list
        return clientList.getTableModel().getDataVector().stream()
                .anyMatch(row -> ((String) row.get(0)).equalsIgnoreCase(clientName));
    }

    private boolean verifyMembership(String clientName) {
        // Check if the client is a member
        return clientList.getTableModel().getDataVector().stream()
                .filter(row -> ((String) row.get(0)).equalsIgnoreCase(clientName))
                .anyMatch(row -> ((String) row.get(3)).equalsIgnoreCase("Yes"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        button1 = new java.awt.Button();

        jTextField1.setText("jTextField1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        button1.setLabel("button1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
 String clientName = jTextField1.getText().trim();

    if (!verifyClientExists(clientName)) {
        JOptionPane.showMessageDialog(this, "Client not found.");
        return;
    }

    boolean hasMembership = verifyMembership(clientName);

    // Print combo box selections for debugging
    System.out.println("ComboBox1 selected item: " + jComboBox1.getSelectedItem());
    System.out.println("ComboBox2 selected item: " + jComboBox2.getSelectedItem());
    System.out.println("ComboBox3 selected item: " + jComboBox3.getSelectedItem());

    String code1 = getMovieCode(jComboBox1.getSelectedItem().toString());
    String code2 = getMovieCode(jComboBox2.getSelectedItem().toString());
    String code3 = getMovieCode(jComboBox3.getSelectedItem().toString());

    System.out.println("Extracted codes: " + code1 + ", " + code2 + ", " + code3);

    Movie movie1 = movieInventory.findMovieByCode(code1);
    Movie movie2 = movieInventory.findMovieByCode(code2);
    Movie movie3 = movieInventory.findMovieByCode(code3);

    if (movie1 == null || movie2 == null || movie3 == null) {
        JOptionPane.showMessageDialog(this, "Error retrieving selected movie details.");
        System.out.println("Movies not found. movie1: " + movie1 + ", movie2: " + movie2 + ", movie3: " + movie3);
        return;
    }

    // Proceed to create the invoice if movies are found
    Invoice invoice = new Invoice(LocalDate.now(), clientName, movie1, movie2, movie3, hasMembership);
    String invoiceFilePath = invoice.generateInvoiceFile();

    if (invoiceFilePath != null) {
        JOptionPane.showMessageDialog(this, "Invoice saved to " + invoiceFilePath);
    } else {
        JOptionPane.showMessageDialog(this, "Error saving invoice.");
    }

    // Clear fields after saving
    jTextField1.setText("");
    jComboBox1.setSelectedIndex(0);
    jComboBox2.setSelectedIndex(0);
    jComboBox3.setSelectedIndex(0);
    }//GEN-LAST:event_button1ActionPerformed
private String getMovieCode(String selectedItem) {
    if (selectedItem != null && selectedItem.contains(" - ")) {
        // Split the string by " - " and get the second part as the code
        return selectedItem.split(" - ")[1].trim();
    }
    return ""; // Return an empty string if no valid code is found
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
