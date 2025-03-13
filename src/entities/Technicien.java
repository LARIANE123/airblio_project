package entities;

import java.util.List;


public class Technicien {
    
    private Long id;
    private String nom;
    private String email;
    private String telephone;
    private String specialite; 
    List<Intervention> interventions; // Liste des interventions du technicien

    public Technicien() {}

    public Technicien(String nom, String email, String telephone, String specialite) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.specialite = specialite;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public List<Intervention> getInterventions() { return interventions; }
    public void setInterventions(List<Intervention> interventions) { this.interventions = interventions; }
}

