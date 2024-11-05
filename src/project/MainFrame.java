
package project;

import com.miapp.ui.NewMovie;
import com.miapp.ui.NewClient;
import com.miapp.ui.MovieInventory;
import com.miapp.ui.ClientList;
import com.miapp.ui.NewRental;
import com.miapp.model.Movie;



/**
 * Main application frame for the Movie Rental System.
 * Manages the MDI layout and the menu options for managing movies, clients, and rentals.
 * @author Brayham Gallo
 */
public class MainFrame extends javax.swing.JFrame {
    
    private ClientList clientList;
    private MovieInventory movieInventory; // Declaración correcta como atributo de clase

    
/**
     * Initializes the main frame, setting up the title, size, and center position,
     * and initializing the internal frames for client list and movie inventory.
     */

    public MainFrame() {
        initComponents();
        this.setTitle("Movie Rental System");
        this.setSize(800, 600); 
        this.setLocationRelativeTo(null); 

        clientList = new ClientList(); 
        jDesktopPane1.add(clientList); 

        movieInventory = new MovieInventory(); 
        jDesktopPane1.add(movieInventory); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(0, 0, 0));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngegg (1) (1).png"))); // NOI18N

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel1)
                .addContainerGap(353, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 255));

        jMenu1.setText("File");

        jMenuItem1.setBackground(new java.awt.Color(153, 153, 255));
        jMenuItem1.setText("New Movie");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("New Client");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");

        jMenuItem4.setText("Movie Inventory");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Client List");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Rental");

        jMenuItem6.setText("New Rental");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0); // Closes the application.
    }//GEN-LAST:event_jMenuItem3ActionPerformed
/**
     * Shows the movie inventory internal frame.
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (movieInventory == null || movieInventory.isClosed()) { // Verifica si es null o cerrada
        movieInventory = new MovieInventory(); // Reinstanciar si estaba cerrada
        jDesktopPane1.add(movieInventory);
    }
    movieInventory.setVisible(true); // Mostrar la ventana
    }//GEN-LAST:event_jMenuItem4ActionPerformed
/**
     * Opens a new internal frame to add a new movie to the inventory.
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            NewMovie newMovie = new NewMovie(movieInventory); 
            jDesktopPane1.add(newMovie);
            newMovie.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
 /**
     * Opens a new internal frame to create a new rental.
     */
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
         // Crear una instancia de NewRental pasando clientList y movieInventory
    NewRental newRental = new NewRental(clientList, movieInventory);
    jDesktopPane1.add(newRental); // Agregar la instancia al escritorio
    newRental.setVisible(true); // Hacerla visible
    newRental.setSize(400, 300);
    }//GEN-LAST:event_jMenuItem6ActionPerformed
/**
     * Shows the client list internal frame.
     */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (clientList == null || clientList.isClosed()) { // Verifica si es null o cerrada
        clientList = new ClientList(); // Reinstanciar si estaba cerrada
        jDesktopPane1.add(clientList);
    }
    clientList.setVisible(true); // Mostrar la ventana
    }//GEN-LAST:event_jMenuItem5ActionPerformed
/**
     * Opens a new internal frame to register a new client.
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        NewClient newClient = new NewClient(clientList); 
        jDesktopPane1.add(newClient); 
        newClient.setVisible(true); 
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    
    /**
     *  Launches the main application frame.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}