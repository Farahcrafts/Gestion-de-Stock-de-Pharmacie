package ma.ensaf.spingbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.ensaf.springbootjpa.model.Categorie;
import ma.ensaf.springbootjpa.model.DetailProduit;
import ma.ensaf.springbootjpa.repository.CategorieRepository;
import ma.ensaf.springbootjpa.repository.DetailProduitRepository;

@Controller
public class DetailProduitController {
	@Autowired
	private DetailProduitRepository dpRepo;
	
	//Create & Update
	@GetMapping(value = "/addDetail")
	public String addDetail() {
		return "addDetail";
	}
	
	@PostMapping(value = "/addDetail")
	public ModelAndView addDetail(@RequestParam(value= "fabricant") String fabricant,
			@RequestParam(value= "paysOrigine") String paysOrigine,
			@RequestParam(value= "composition") String composition,
			@RequestParam(value= "dosage") String dosage,
			@RequestParam(value= "indications") String indications) {
		
		DetailProduit dp= new DetailProduit(fabricant, paysOrigine, composition, dosage,  indications);
		
		dpRepo.save(dp);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SuccesInsertion");
		mv.addObject("fabricant", fabricant);
		mv.addObject("paysOrigine", paysOrigine);
		mv.addObject("composition", composition);
		mv.addObject("dosage", dosage);
		mv.addObject("indications", indications);
		return mv;
	}
	

	//Get
	@GetMapping(value = "/showAllProduitDetails")
	public ModelAndView getProduitDetails(){
		List<DetailProduit> dps= dpRepo.findAll();
		ModelAndView mv= new ModelAndView();
		mv.setViewName("detailsProduit");
		mv.addObject("detailsProduit", dps);
		return mv;
	}
	
	//delete
	@GetMapping(value = "/deleteDetailsProduit")
	public String deleteDetailProduit() {
		return "deleteDetailProduit";
	}
	
	@PostMapping(value="/deleteDetailsProduit")
	public String deleteDetailsProduit(@RequestParam(value="id") Long id) {
	    dpRepo.deleteById(id);
	    return "redirect:/showAllProduitDetails";
	}
}
