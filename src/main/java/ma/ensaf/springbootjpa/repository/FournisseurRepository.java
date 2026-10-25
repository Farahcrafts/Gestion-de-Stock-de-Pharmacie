package ma.ensaf.springbootjpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.ensaf.springbootjpa.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository <Fournisseur, Integer> {

}
