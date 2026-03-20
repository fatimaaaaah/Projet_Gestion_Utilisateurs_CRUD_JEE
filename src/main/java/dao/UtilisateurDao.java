package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import beans.Utilisateurs;

public class UtilisateurDao {

    // Ajouter un utilisateur
    public static void add(Utilisateurs u) {
        String sql = "INSERT INTO utilisateurs (nom, prenom, login, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getLogin());
            ps.setString(4, u.getPassword());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lister tous les utilisateurs
    public static List<Utilisateurs> Lister() {
        List<Utilisateurs> liste = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurs";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Utilisateurs u = new Utilisateurs(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("login"),
                        rs.getString("password")
                );
                liste.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    // Trouver un utilisateur par ID
    public static Utilisateurs findById(int id) {
        String sql = "SELECT * FROM utilisateurs WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Utilisateurs(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("login"),
                        rs.getString("password")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Mettre à jour un utilisateur
    public static boolean update(Utilisateurs u) {
        String sql = "UPDATE utilisateurs SET nom=?, prenom=?, login=?, password=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getLogin());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Supprimer un utilisateur
    public static boolean delete(int id) {
        String sql = "DELETE FROM utilisateurs WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}