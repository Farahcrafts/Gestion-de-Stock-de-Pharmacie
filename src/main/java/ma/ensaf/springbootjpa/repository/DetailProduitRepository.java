package ma.ensaf.springbootjpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.ensaf.springbootjpa.model.DetailProduit;

public interface DetailProduitRepository extends JpaRepository<DetailProduit, Integer>{

}
