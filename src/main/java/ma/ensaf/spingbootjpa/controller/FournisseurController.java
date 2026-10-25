package ma.ensaf.spingbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.ensaf.springbootjpa.model.Fournisseur;
import ma.ensaf.springbootjpa.repository.FournisseurRepository;


@Controller
public class FournisseurController {
	@Autowired
	private FournisseurRepository fRepo;
	
	//Create & Update
	@GetMapping(value = "/addFournisseur")
	public String addFournisseur() {
		return "addFournisseur";
	}
	
	@PostMapping(value = "/addFournisseur")
	public ModelAndView addFournisseur(@RequestParam(value= "nom") String nom,
			@RequestParam(value= "contact") String contact,
			@RequestParam(value= "adresse") String adresse) {
		
		Fournisseur fournisseur= new Fournisseur(nom, contact, adresse);
		
		fRepo.save(fournisseur);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SuccesInsertion");
		mv.addObject("nom", nom);
		mv.addObject("contact", contact);
		mv.addObject("adresse", adresse);
		return mv;
	}
	

	//Get
	@GetMapping(value = "/showAllFournisseurs")
	public ModelAndView getFournisseurs(){
		List<Fournisseur> fournisseurs= fRepo.findAll();
		ModelAndView mv= new ModelAndView();
		mv.setViewName("fournisseurs");
		mv.addObject("fournisseurs", fournisseurs);
		return mv;
	}
	
	//delete
	@GetMapping(value = "/deleteFournisseur")
	public String deleteFournisseur() {
		return "deleteFournisseur";
	}
	
	@PostMapping(value="/deleteFournisseur")
	public String deleteCategorie(@RequestParam(value="id") Long id) {
	    fRepo.deleteById(id);
	    return "redirect:/showAllFournisseurs";
	}
}
