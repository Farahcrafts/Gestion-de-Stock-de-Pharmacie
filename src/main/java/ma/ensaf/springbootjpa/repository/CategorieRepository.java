package ma.ensaf.springbootjpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.ensaf.springbootjpa.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer>{
}
