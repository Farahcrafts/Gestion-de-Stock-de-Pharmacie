package ma.ensaf.spingbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.ensaf.springbootjpa.model.Tag;
import ma.ensaf.springbootjpa.repository.TagRepository;

@Controller
public class TagController {
	
	@Autowired
	private TagRepository tagRepo;
	
	//Create & Update
	@GetMapping(value = "/addTag")
	public String addTag() {
		return "addTag";
	}
	
	@PostMapping(value = "/addTag")
	public ModelAndView addTag(@RequestParam(value= "libelle") String libelle) {
		
		Tag tag= new Tag(libelle);
		
		tagRepo.save(tag);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SuccesInsertion");
		mv.addObject("libelle", libelle);
		return mv;
	}
	

	//Get
	@GetMapping(value = "/showAllTags")
	public ModelAndView getTags(){
		List<Tag> tags= tagRepo.findAll();
		ModelAndView mv= new ModelAndView();
		mv.setViewName("tags");
		mv.addObject("tags", tags);
		return mv;
	}
	
	//delete
	@GetMapping(value = "/deleteTag")
	public String deleteTag() {
		return "deleteTag";
	}
	
	@PostMapping(value="/deleteTag")
	public String deleteTag(@RequestParam(value="id") Long id) {
	    tagRepo.deleteById(id);
	    return "redirect:/showAllTags";
	}
	
	
}
