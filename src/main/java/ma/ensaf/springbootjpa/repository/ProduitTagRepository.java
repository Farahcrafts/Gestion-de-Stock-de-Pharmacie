package ma.ensaf.springbootjpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.ensaf.springbootjpa.model.ProduitTag;
import ma.ensaf.springbootjpa.model.ProduitTagId;

public interface ProduitTagRepository extends JpaRepository<ProduitTag, ProduitTagId> {

}
