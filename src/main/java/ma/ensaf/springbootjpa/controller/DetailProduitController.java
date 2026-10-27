package ma.ensaf.springbootjpa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ensaf.springbootjpa.model.DetailProduit;
import ma.ensaf.springbootjpa.repository.DetailProduitRepository;

@RestController
@RequestMapping("/api/details")
public class DetailProduitController {
	
	@Autowired
	private DetailProduitRepository dRepo ;
	
	@GetMapping
	public List<DetailProduit> showAllDetails(){
		return dRepo.findAll();
	}
	
}
