package ma.ensaf.springbootjpa.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.ensaf.springbootjpa.repository.TagRepository;

@Controller
@RequestMapping("/tags")
public class TagViewController {
    
    @Autowired
    private TagRepository repo;
    
    @GetMapping
    public String liste(Model model) {
        model.addAttribute("tags", repo.findAll());
        return "tags";
    }
}