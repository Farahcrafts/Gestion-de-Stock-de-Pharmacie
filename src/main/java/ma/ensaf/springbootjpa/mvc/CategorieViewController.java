package ma.ensaf.springbootjpa.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.ensaf.springbootjpa.repository.CategorieRepository;

@Controller
@RequestMapping("/categories")
public class CategorieViewController {
    
    @Autowired
    private CategorieRepository repo;
    
    @GetMapping
    public String liste(Model model) {
        model.addAttribute("categories", repo.findAll());
        return "categories";
    }
}