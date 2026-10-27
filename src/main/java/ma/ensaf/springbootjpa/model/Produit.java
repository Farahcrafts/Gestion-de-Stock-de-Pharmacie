package ma.ensaf.springbootjpa.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Produit {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String description;
	private float prix;
	private String codeBarre;
	private LocalDate dateExpiration;
	
	@ManyToOne
	@JoinColumn(name= "categorie_id")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name= "fournisseur_id")
	private Fournisseur fournisseur;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detail_id")
	private DetailProduit detail;
	
	@ManyToMany
	@JoinTable(
	    name = "produit_tag", 
	    joinColumns = @JoinColumn(name = "produit_id"), 
	    inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	Set<Tag> tags = new HashSet<>();
	
	
	//constructeur
	public Produit() {}
	public Produit(String nom, String description, float prix, String code_barre, LocalDate date_expiration,
			Categorie categorie, Fournisseur fournisseur, DetailProduit detail) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.codeBarre = code_barre;
		this.dateExpiration = date_expiration;
		this.categorie = categorie;
		this.fournisseur = fournisseur;
		this.detail = detail;
	}


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}


	public String getCodeBarre() {
		return codeBarre;
	}
	public void setCodeBarre(String codeBarre) {
		this.codeBarre = codeBarre;
	}
	public LocalDate getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	public DetailProduit getDetail() {
		return detail;
	}
	public void setDetail(DetailProduit detail) {
		this.detail = detail;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Set<Tag> getTags() {
		return tags;
	}
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
}
