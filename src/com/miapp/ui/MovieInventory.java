package com.miapp.ui;

import com.miapp.model.Movie;
import javax.swing.table.DefaultTableModel;
import com.miapp.model.PremiumMovie;
import com.miapp.model.RegularMovie;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * MovieInventory is a GUI component that displays a table of movies in the inventory.
 * It allows adding new movies and displays their title, year, and gender.
 */
public class MovieInventory extends javax.swing.JInternalFrame {

  
    private DefaultTableModel movieTableModel;
    private List<Movie> movies = new ArrayList<>();

    public List<Movie> getMovies() {
        return movies;
    }

    
    public Movie getMovieByCode(String code) {
        for (Movie movie : movies) {
            if (movie.getMovieCode().equals(code)) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Constructs a new MovieInventory window and initializes the table model.
     */  
    public MovieInventory() {
        initComponents();
        this.movies = new ArrayList<>();
        movieTableModel = (DefaultTableModel) jTable1.getModel(); // Obtiene el modelo de la tabla
        loadMoviesFromFile(); // Cargar películas desde el archivo al iniciar
    }

    /**
     * Adds a new movie to the table.
     *
     * @param movie The Movie object to add to the inventory.
     */  
    
    
    public Movie findMovieByCode(String code) {
    System.out.println("Searching for movie with code: " + code);

    for (Movie movie : movies) {
        System.out.println("Available movie: " + movie.getMovieCode() + " - " + movie.getTitle());

        if (movie.getMovieCode().equals(code)) {
            System.out.println("Match found for code: " + code);
            return movie;
        }
    }
    System.out.println("No match found for code: " + code);
    return null;
}

     
   public void addMovie(Movie movie) {
    // Determina el año actual
    int currentYear = LocalDate.now().getYear();
    double rentalPrice;

    // Establece el precio de renta según el año de estreno de la película
    if (movie.getReleaseYear() == currentYear) {
        rentalPrice = 13000; // Precio para películas premium este año
        PremiumMovie premiumMovie = new PremiumMovie(movie.getTitle(), movie.getGenre(), movie.getReleaseYear(), rentalPrice, 0);
        movieTableModel.insertRow(0, new Object[]{premiumMovie.getMovieCode(), premiumMovie.getTitle(), premiumMovie.getReleaseYear(), premiumMovie.getGenre(), premiumMovie.isAvailable(), rentalPrice});
        movies.add(premiumMovie); // Añadir a la lista de películas
    } else {
        rentalPrice = 10000; // Precio para películas regulares
        RegularMovie regularMovie = new RegularMovie(movie.getTitle(), movie.getGenre(), movie.getReleaseYear(), rentalPrice);
        movieTableModel.insertRow(0, new Object[]{regularMovie.getMovieCode(), regularMovie.getTitle(), regularMovie.getReleaseYear(), regularMovie.getGenre(), regularMovie.isAvailable(), rentalPrice});
        movies.add(regularMovie); // Añadir a la lista de películas
    }
    
    // Guarda las películas actualizadas en el archivo después de añadir
    saveMoviesToFile();
}



    public DefaultTableModel getMovieTableModel() {
        return movieTableModel;
    }
    
  
    
    
    public Movie findMovieByTitle(String title, List<Movie> movieList) {
    for (Movie movie : movieList) {
        if (movie.getTitle().equalsIgnoreCase(title)) {
            return movie; // Retorna la película si encuentra un título coincidente
        }
    }
    return null; // Retorna null si no encuentra ninguna coincidencia
    }
    
    
      public Movie findMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null; // Retorna null si no encuentra ninguna coincidencia
    }
    
    // Método para guardar películas en un archivo
    // Método para guardar películas en un archivo
private void saveMoviesToFile() {
    File file = new File("movies.txt");
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        // Iterar sobre las filas de la tabla
        for (int row = 0; row < movieTableModel.getRowCount(); row++) {
            String code = (String) movieTableModel.getValueAt(row, 0);
            String title = (String) movieTableModel.getValueAt(row, 1);
            Integer yearObj = (Integer) movieTableModel.getValueAt(row, 2);
            String genre = (String) movieTableModel.getValueAt(row, 3);
            Boolean isAvailableObj = (Boolean) movieTableModel.getValueAt(row, 4);
            Double priceObj = (Double) movieTableModel.getValueAt(row, 5);

            if (code != null && title != null && genre != null) {
                int year = (yearObj != null) ? yearObj : 0; // valor por defecto
                boolean isAvailable = (isAvailableObj != null) ? isAvailableObj : false; // valor por defecto
                double price = (priceObj != null) ? priceObj : 0.0; // valor por defecto

                // Escribir en el archivo
                writer.write(code + "," + title + "," + year + "," + genre + "," + isAvailable + "," + price);
                writer.newLine();
            } else {
                System.err.println("Error: Valores nulos en la fila " + row);
            }
        }
        System.out.println("Películas guardadas exitosamente en: " + file.getAbsolutePath());
    } catch (IOException e) {
        System.err.println("Error al guardar las películas: " + e.getMessage());
        e.printStackTrace();
    }
}








    // Método para cargar películas desde un archivo
    private void loadMoviesFromFile() {
        File file = new File("movies.txt");
        if (!file.exists()) {
            return; // Si no existe el archivo, no hacemos nada
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String code = parts[0];
                String title = parts[1];
                int year = Integer.parseInt(parts[2]);
                String genre = parts[3];
                boolean isAvailable = Boolean.parseBoolean(parts[4]);
                double price = Double.parseDouble(parts[5]);

                // Crear una película basada en la información leída
                Movie movie;
                if (year == LocalDate.now().getYear()) {
                    movie = new PremiumMovie(title, genre, year, price, 0);
                } else {
                    movie = new RegularMovie(title, genre, year, price);
                }
                addMovie(movie); // Agregar la película al inventario
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejar excepciones adecuadamente
        }
    }

    /**
     * Closes the MovieInventory window.
     *
     * @param evt The action event triggered by clicking the Close button.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "code", "Title", "Year", "Gender", "IsAvailable", "Price"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(102, 102, 255));
        jTable1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jTable1.setSelectionForeground(new java.awt.Color(102, 51, 255));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setText("MOVIE INVENTORY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 /**
     * Closes the MovieInventory window.
     *
     * @param evt The action event triggered by clicking the Close button.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
        this.dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    List<Movie> getAllMovies() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
