package ma.ensaf.springbootjpa.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProduitTagId implements Serializable{
private int produitId;
private int tagId;


public int getProduitId() {
	return produitId;
}
public void setProduitId(int produitId) {
	this.produitId = produitId;
}
public int getTagId() {
	return tagId;
}
public void setTagId(int tagId) {
	this.tagId = tagId;
}
@Override
public int hashCode() {
	return Objects.hash(Integer.valueOf(produitId), Integer.valueOf(tagId));
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ProduitTagId other = (ProduitTagId) obj;
	return produitId == other.produitId && tagId == other.tagId;
}


}
