package ma.ensaf.springbootjpa.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProduitTagId implements Serializable{
private Long produitId;
private Long tagId;
public Long getProduitId() {
	return produitId;
}
public void setProduitId(Long produitId) {
	this.produitId = produitId;
}
public Long getTagId() {
	return tagId;
}
public void setTagId(Long tagId) {
	this.tagId = tagId;
}
@Override
public int hashCode() {
	return Objects.hash(produitId, tagId);
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
	return Objects.equals(produitId, other.produitId) && Objects.equals(tagId, other.tagId);
}



}
