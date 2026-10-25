package ma.ensaf.springbootjpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.ensaf.springbootjpa.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{
}
