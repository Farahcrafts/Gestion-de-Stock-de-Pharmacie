package ma.ensaf.springbootjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tag {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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

	public Long getId() {
		return id;
	}
	public void setId(Long produit_id) {
		this.id = produit_id;
	}
	public void setProduit_id(Long id2) {
		// TODO Auto-generated method stub
		
	}

}
