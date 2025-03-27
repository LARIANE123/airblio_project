package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// test de la connextion



public class ClientDAO {

    /**
     * Récupère et affiche les informations d'un client à partir de son email.
     * @param email L'email du client à rechercher.
     */
    public void getClientByEmail(String email) {
        String sql = "SELECT * FROM clients WHERE email = ?";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Définir l'email dans la requête préparée
            stmt.setString(1, email);

            // Exécuter la requête
            ResultSet rs = stmt.executeQuery();

            // Parcourir le résultat et afficher les informations
            while (rs.next()) {
                long id = rs.getLong("id");
                String nom = rs.getString("nom");
                String emailClient = rs.getString("email");
                String telephone = rs.getString("telephone");
                String adresse = rs.getString("adresse");

                System.out.println("ID: " + id);
                System.out.println("Nom: " + nom);
                System.out.println("Email: " + emailClient);
                System.out.println("Téléphone: " + telephone);
                System.out.println("Adresse: " + adresse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode main pour tester la récupération des informations
    public static void main(String[] args) {
        ClientDAO dao = new ClientDAO();
        dao.getClientByEmail("jean.dupont@email.com");
    }
}
