package ma.ensaf.springbootjpa.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private String code_barre;
	private Date date_expiration;
	
	@ManyToOne
	@JoinColumn(name= "categorie_id")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name= "fournisseur_id")
	private Fournisseur fournisseur;
	
	@OneToOne
	@JoinColumn(name = "detail_id")
	private DetailProduit detail;
	
	
	public Produit() {}


	public Produit(String nom, String description, float prix, String code_barre, Date date_expiration,
			Categorie categorie, Fournisseur fournisseur, DetailProduit detail) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.code_barre = code_barre;
		this.date_expiration = date_expiration;
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


	public String getCode_barre() {
		return code_barre;
	}


	public void setCode_barre(String code_barre) {
		this.code_barre = code_barre;
	}


	public Date getDate_expiration() {
		return date_expiration;
	}


	public void setDate_expiration(Date date_expiration) {
		this.date_expiration = date_expiration;
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
	
	

}
