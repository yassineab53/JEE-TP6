package net.yassine.pres;


import net.yassine.metier.Etudiant;
import net.yassine.metier.ScolariteService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/SCOLARITE";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            ScolariteService service = new ScolariteService(connection);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez un mot-clé pour rechercher les étudiants : ");
            String mc = scanner.nextLine();

            List<Etudiant> etudiants = service.getEtudiants(mc);
            if (etudiants.isEmpty()) {
                System.out.println("Aucun étudiant trouvé.");
            } else {
                for (Etudiant e : etudiants) {
                    System.out.println("ID: " + e.getIdEtudiant() +
                            ", Nom: " + e.getNom() +
                            ", Prénom: " + e.getPrenom() +
                            ", Email: " + e.getEmail() +
                            ", Ville: " + e.getVille());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Hello world!");
    }
}