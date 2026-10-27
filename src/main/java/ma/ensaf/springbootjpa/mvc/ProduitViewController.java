package ma.ensaf.springbootjpa.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.ensaf.springbootjpa.repository.ProduitRepository;

@Controller
@RequestMapping("/produits")
public class ProduitViewController {
    
    @Autowired
    private ProduitRepository repo;
    
    @GetMapping
    @Transactional // Prévient la LazyInitializationException pour les catégories, fournisseurs et tags
    public String liste(Model model) {
        model.addAttribute("produits", repo.findAll());
        return "produits";
    }
}