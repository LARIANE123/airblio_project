package entities;



import java.time.LocalDate;


public class Facture {
  
    private Long id;
    
    private String detail;
    private Double montant;
    private String statut; // "En attente", "Payée", "Impayée"
    private LocalDate dateEmission;
    private LocalDate dateEcheance;


    private Client client; // Facture associée à un client
    private Intervention intervention; // Facture associée à une intervention

    public Facture() {}

    public Facture(Double montant, String statut, LocalDate dateEmission, LocalDate dateEcheance, Client client, Intervention intervention) {
        this.montant = montant;
        this.statut = statut;
        this.dateEmission = dateEmission;
        this.dateEcheance = dateEcheance;
        this.client = client;
        this.intervention = intervention;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public LocalDate getDateEmission() { return dateEmission; }
    public void setDateEmission(LocalDate dateEmission) { this.dateEmission = dateEmission; }

    public LocalDate getDateEcheance() { return dateEcheance; }
    public void setDateEcheance(LocalDate dateEcheance) { this.dateEcheance = dateEcheance; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Intervention getIntervention() { return intervention; }
    public void setIntervention(Intervention intervention) { this.intervention = intervention; }

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}

