package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/gestion_users?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";      // ton utilisateur MySQL
    private static final String PASSWORD = "";      // mot de passe MySQL

    // Méthode pour récupérer la connexion
    public static Connection getConnection() throws SQLException {
        try {
            // Charge le driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL non trouvé !");
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Test de connexion
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            System.out.println("Connexion à la base de données OK !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base :");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}