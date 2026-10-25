package ma.ensaf.springbootjpa.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ProduitTag {
	
	@EmbeddedId
	private ProduitTagId id;
	

}
