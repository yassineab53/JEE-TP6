package net.yassine.metier;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ScolariteService {
    private Connection connection;
    public ScolariteService(Connection connection) {
        this.connection = connection;
    }
    public List<Etudiant> getEtudiants(String mc){
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM ETUDIANTS WHERE nom LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + mc + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Etudiant e = new Etudiant(
                        (long) rs.getInt("idEtudiant"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("ville")
                );
                etudiants.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }
}
