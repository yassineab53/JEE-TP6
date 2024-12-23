package net.yassine.metier;


import java.io.Serializable;

public class Etudiant implements Serializable {
    //idEtudiant, nom, prenom, email et ville
    private Long idEtudiant;
    private String nom;
    private String prenom;
    private String email;
    private String ville;

    public Etudiant(){}
    public Etudiant(Long id, String nom, String prenom, String email, String ville) {
        this.idEtudiant = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.ville = ville;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getVille() {
        return ville;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return idEtudiant + " " + nom + " " + prenom + " " + email + " " + ville;
    }
}
