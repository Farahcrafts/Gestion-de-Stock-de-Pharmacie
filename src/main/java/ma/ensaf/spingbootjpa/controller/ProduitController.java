package ma.ensaf.spingbootjpa.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ma.ensaf.springbootjpa.model.Categorie;
import ma.ensaf.springbootjpa.model.DetailProduit;
import ma.ensaf.springbootjpa.model.Fournisseur;
import ma.ensaf.springbootjpa.model.Produit;
import ma.ensaf.springbootjpa.repository.CategorieRepository;
import ma.ensaf.springbootjpa.repository.DetailProduitRepository;
import ma.ensaf.springbootjpa.repository.FournisseurRepository;
import ma.ensaf.springbootjpa.repository.ProduitRepository;


@Controller
public class ProduitController {

	@Autowired
	private ProduitRepository pRepo;
	@Autowired
	private FournisseurRepository fournisseurRepo;
	@Autowired
	private DetailProduitRepository dpRepo;
	@Autowired
	private CategorieRepository cRepo;
	
	//Create & Update
	@GetMapping(value = "/addProduit")
	public String addProduit() {
		return "addProduit";
	}
		
	@PostMapping(value = "/addProduit")
	public ModelAndView addProduit(@RequestParam(value= "nom") String nom,
			@RequestParam(value= "description") String description,
			@RequestParam(value= "prix") float prix,
			@RequestParam(value= "codeBarre") String codeBarre,
			@RequestParam(value= "dateExpiration") Date dateExpiration,
			@RequestParam(value= "fournisseurId") Long fournisseur_id,
			@RequestParam(value= "DetailProduitId") Long detailProduit_id,
			@RequestParam(value= "CategorieProduit") Long categorie_id
			)
	
	{
		Fournisseur fournisseur = fournisseurRepo.findById(fournisseur_id).orElse(null);
		DetailProduit dp = dpRepo.findById(detailProduit_id).orElse(null);
		Categorie categorie = cRepo.findById(categorie_id).orElse(null);

		
		Produit produit= new Produit(nom, description, prix, codeBarre, dateExpiration,categorie, fournisseur, dp);
		
		pRepo.save(produit);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SuccesInsertion");
		mv.addObject("nom", nom);
		mv.addObject("description", description);
		mv.addObject("prix", prix);
		mv.addObject("codeBarre",codeBarre);
		mv.addObject("dateExpiration", dateExpiration);
		
		return mv;
	}
	

	//Get
	@GetMapping(value = "/showAllProduits")
	public ModelAndView getProduits(){
		List<Produit> produits= pRepo.findAll();
		ModelAndView mv= new ModelAndView();
		mv.setViewName("produits");
		mv.addObject("produits", produits);
		return mv;
	}
	
	//delete
	@GetMapping(value = "/deleteProduit")
	public String deleteProduit() {
		return "deleteProduit";
	}
	
	@PostMapping(value="/deleteProduit")
	public String deleteProduit(@RequestParam(value="id") Long id) {
	    pRepo.deleteById(id);
	    return "redirect:/showAllProduits";
	}
}
