package ma.ensaf.springbootjpa.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ensaf.springbootjpa.model.Categorie;
import ma.ensaf.springbootjpa.repository.CategorieRepository;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {
	
	@Autowired
	private CategorieRepository categorieRepo;
	
	
	//Get all
	@GetMapping
	public List<Categorie> getAllCategories(){
		return categorieRepo.findAll();
	}
	
	//Get by id
	@GetMapping("/{id}")
	public ResponseEntity<Categorie> getCategorieById(@PathVariable Long id ){
		return categorieRepo.findById(id)
				.map(c -> ResponseEntity.ok(c))
				.orElse(ResponseEntity.notFound().build());  
	}
	
	//Create 
	@PostMapping
	public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categorieRepo.save(categorie));
	}
	
	//Update
	@PutMapping("/{id}")
	public Categorie putCategorie(@PathVariable Long id, @RequestBody Categorie categorie) {
		categorie.setId(id);
		return categorieRepo.save(categorie);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Categorie> deleteCategorie(@PathVariable Long id) {
		if (!categorieRepo.existsById(id)) {
	        return ResponseEntity.notFound().build();        // 404
	    }
	    categorieRepo.deleteById(id);
	    return ResponseEntity.noContent().build();           // 204
	}
	
}
