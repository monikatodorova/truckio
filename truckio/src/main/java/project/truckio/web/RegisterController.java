package project.truckio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.truckio.model.exceptions.InvalidArgumentException;
import project.truckio.model.exceptions.PasswordsDoNotMatch;
import project.truckio.service.KlientService;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final KlientService klientService;

    public RegisterController(KlientService klientService) {
        this.klientService = klientService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register.html";
    }

    @PostMapping
    public String register(@RequestParam String ime,
                           @RequestParam String prezime,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String email,
                           @RequestParam String telefon,
                           Model model) {

        if(!email.contains("@") && !email.contains("@")) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", "emailError");
            return "register.html";
        }

        if(telefon.length()!=9 && telefon.startsWith("07")) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", "telefonError");
            return "register.html";
        }

        try {
            this.klientService.register(ime, prezime, password, repeatedPassword, email, telefon);
            return "redirect:/login";
        } catch (PasswordsDoNotMatch | InvalidArgumentException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

}