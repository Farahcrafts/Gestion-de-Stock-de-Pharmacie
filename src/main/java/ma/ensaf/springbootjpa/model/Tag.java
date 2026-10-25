package ma.ensaf.springbootjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tag {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long produit_id;
	
	private String libelle;

	public Tag() {}
	public Tag(String libelle) {
		super();
		this.libelle = libelle;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}
