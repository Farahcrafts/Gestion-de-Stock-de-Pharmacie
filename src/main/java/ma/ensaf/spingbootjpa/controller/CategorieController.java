package ma.ensaf.spingbootjpa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.ensaf.springbootjpa.model.Categorie;
import ma.ensaf.springbootjpa.repository.CategorieRepository;

@Controller
public class CategorieController {
	@Autowired
	private CategorieRepository categorieRepo;
	
	//Create & Update
	@GetMapping(value = "/addCategorie")
	public String addCategorie() {
		return "addCategorie";
	}
	
	@PostMapping(value = "/addCategorie")
	public ModelAndView addCategorie(@RequestParam(value= "nom") String nom, @RequestParam(value= "description") String description) {
		
		Categorie categorie= new Categorie(nom, description);
		
		categorieRepo.save(categorie);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SuccesInsertion");
		mv.addObject("nom", nom);
		mv.addObject("description", description);
		return mv;
	}
	

	//Get
	@GetMapping(value = "/showAllCategories")
	public ModelAndView getTags(){
		List<Categorie> categories= categorieRepo.findAll();
		ModelAndView mv= new ModelAndView();
		mv.setViewName("categories");
		mv.addObject("categories", categories);
		return mv;
	}
	
	//delete
	@GetMapping(value = "/deleteCategorie")
	public String deleteCategorie() {
		return "deleteCategorie";
	}
	
	@PostMapping(value="/deleteCategorie")
	public String deleteCategorie(@RequestParam(value="id") Long id) {
	    categorieRepo.deleteById(id);
	    return "redirect:/showAllCategories";
	}
}
