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

import ma.ensaf.springbootjpa.model.Fournisseur;
import ma.ensaf.springbootjpa.repository.FournisseurRepository;


@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurController {
	@Autowired
	private FournisseurRepository fournisseurRepo;
	
	//Get all
	@GetMapping
	public List<Fournisseur> getAllFournisseurs(){
		return fournisseurRepo.findAll();
	}
	
	//Get by id
	@GetMapping("/{id}")
	public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Long id ){
		return fournisseurRepo.findById(id)
				.map(f -> ResponseEntity.ok(f))
				.orElse(ResponseEntity.notFound().build());  
	}
	
	//Create 
	@PostMapping
	public ResponseEntity<Fournisseur> addFournisseur(@RequestBody Fournisseur fournisseur) {
		return ResponseEntity.status(HttpStatus.CREATED).body(fournisseurRepo.save(fournisseur));
	}
	
	//Update
	@PutMapping("/{id}")
	public Fournisseur putFournisseur(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {
		fournisseur.setId(id);
		return fournisseurRepo.save(fournisseur);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Fournisseur> deleteFournisseur(@PathVariable Long id) {
		if (!fournisseurRepo.existsById(id)) {
	        return ResponseEntity.notFound().build();        // 404
	    }
	    fournisseurRepo.deleteById(id);
	    return ResponseEntity.noContent().build();           // 204
	}
}
