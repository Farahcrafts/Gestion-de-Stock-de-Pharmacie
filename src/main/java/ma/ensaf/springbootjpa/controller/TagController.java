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

import ma.ensaf.springbootjpa.model.Tag;
import ma.ensaf.springbootjpa.repository.TagRepository;

@RestController
@RequestMapping("/api/tags")
public class TagController {
	
	@Autowired
	private TagRepository tagRepo;
	
	//Get all
	@GetMapping
	public List<Tag> getAllTags(){
		return tagRepo.findAll();
	}
	
	//Get by id
	@GetMapping("/{id}")
	public ResponseEntity<Tag> getTagById(@PathVariable Long id ){
		return tagRepo.findById(id)
				.map(t -> ResponseEntity.ok(t))
				.orElse(ResponseEntity.notFound().build());  
	}
	
	//Create 
	@PostMapping
	public ResponseEntity<Tag> addTag(@RequestBody Tag tag) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tagRepo.save(tag));
	}
	
	//Update
	@PutMapping("/{id}")
	public Tag putTag(@PathVariable Long id, @RequestBody Tag tag) {
		tag.setId(id);
		return tagRepo.save(tag);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Tag> deleteTag(@PathVariable Long id) {
		if (!tagRepo.existsById(id)) {
	        return ResponseEntity.notFound().build();        // 404
	    }
	    tagRepo.deleteById(id);
	    return ResponseEntity.noContent().build();           // 204
	}
	
}
