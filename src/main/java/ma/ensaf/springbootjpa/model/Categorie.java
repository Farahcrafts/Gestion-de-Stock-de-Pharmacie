package ma.ensaf.springbootjpa.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Categorie {
	
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Long id ;
 private String nom ;
 private String description;
 
 @OneToMany(mappedBy = "categorie")
 @JsonIgnore
 private List<Produit> produits = new ArrayList<>();
 
 public Categorie() {}
 public Categorie(String nom, String description) {
	 this.nom = nom;
	 this.description = description;
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
 public Long getId() {
	return id;
 }
 public void setId(Long id) {
	this.id = id;
 }
 
 

}
