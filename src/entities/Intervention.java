package entities;

import java.time.LocalDateTime;
import java.util.List;

public class Intervention {
    
    private Long id;
    private String statut; // En attente, Validée, Planifiée, En cours, Terminée
    private LocalDateTime dateIntervention;
    private Client client; // Intervention liée à un client
    private Technicien technicien; // Intervention attribuée à un technicien
    private List<Equipement> equipements; // Liste des équipements affectés
    private Facture facture; // Facture liée à l'interventions

    
    
    public Intervention() {}

    public Intervention(String statut, LocalDateTime dateIntervention, Client client, Technicien technicien) {
        this.statut = statut;
        this.dateIntervention = dateIntervention;
        this.client = client;
        this.technicien = technicien;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public LocalDateTime getDateIntervention() { return dateIntervention; }
    public void setDateIntervention(LocalDateTime dateIntervention) { this.dateIntervention = dateIntervention; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Technicien getTechnicien() { return technicien; }
    public void setTechnicien(Technicien technicien) { this.technicien = technicien; }

    public List<Equipement> getEquipements() { return equipements; }
    public void setEquipements(List<Equipement> equipements) { this.equipements = equipements; }

    public Facture getFacture() { return facture; }
    public void setFacture(Facture facture) { this.facture = facture; }
}


