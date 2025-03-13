package entities;

import java.time.LocalDate;


public class Equipement {
    
    private Long id;

    private String description;
    private String nom;
    private String type;
    private String etat; // disponible,affecte,en utilisation, en maintenance, hors service
    private LocalDate dateAchat;
    private String statut;

    
    private Intervention intervention; // L'équipement peut être affecté à une intervention

    public Equipement() {}

    public Equipement(String nom, String type, String etat, LocalDate dateAchat,String description,String statut) {
        this.nom = nom;
        this.type = type;
        this.etat = etat;
        this.dateAchat = dateAchat;
        this.setDescription(description);
        this.setStatut(statut);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }

    public LocalDate getDateAchat() { return dateAchat; }
    public void setDateAchat(LocalDate dateAchat) { this.dateAchat = dateAchat; }

    public Intervention getIntervention() { return intervention; }
    public void setIntervention(Intervention intervention) { this.intervention = intervention; }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
}
