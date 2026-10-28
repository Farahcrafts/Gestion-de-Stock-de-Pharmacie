package ma.ensaf.springbootjpa.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Kiy-jbed login.html mn templates
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Bienvenue sur la page sécurisée !"); // Message mtloub f home.html[cite: 57]
        return "home"; // Kiy-jbed home.html mn templates
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin"; // Kiy-jbed admin.html
    }
}