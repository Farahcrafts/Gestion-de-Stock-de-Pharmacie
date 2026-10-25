package ma.ensaf.springbootjpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.ensaf.springbootjpa.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
