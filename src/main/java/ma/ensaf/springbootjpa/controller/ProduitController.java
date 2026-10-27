package ma.ensaf.springbootjpa.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.ensaf.springbootjpa.model.Produit;
import ma.ensaf.springbootjpa.repository.ProduitRepository;


@RestController
@RequestMapping("/api/produits")
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepo;
	
	//Get all
	@GetMapping
	public List<Produit> getAllProduits(){
		return produitRepo.findAll();
	}
	
	//Get by id
	@GetMapping("/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable Long id ){
		return produitRepo.findById(id)
				.map(p -> ResponseEntity.ok(p))
				.orElse(ResponseEntity.notFound().build());  
	}
	
	//Create 
	@PostMapping
	public ResponseEntity<Produit> addProduit(@RequestBody Produit produit) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produitRepo.save(produit));
	}
	
	//Update
	@PutMapping("/{id}")
	public ResponseEntity<Produit> putProduit(@PathVariable Long id, @RequestBody Produit produit) {
		if (!produitRepo.existsById(id)) {
	        return ResponseEntity.notFound().build();   // 404
	    }
	    produit.setId(id);
	    return ResponseEntity.ok(produitRepo.save(produit));          // 200
	}
	
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Produit> deleteProduit(@PathVariable Long id) {
		if (!produitRepo.existsById(id)) {
	        return ResponseEntity.notFound().build();        // 404
	    }
	    produitRepo.deleteById(id);
	    return ResponseEntity.noContent().build();           // 204
	}
}
