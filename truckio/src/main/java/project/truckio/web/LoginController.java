package project.truckio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.truckio.model.Klient;
import project.truckio.model.exceptions.InvalidUserCredentialsException;
import project.truckio.service.KlientService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final KlientService klientService;

    public LoginController(KlientService klientService) {
        this.klientService = klientService;
    }

    @GetMapping
    public String getLoginPage(Model model) {
        return "login.html";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        Klient klient = null;
        try{
            klient = this.klientService.login(request.getParameter("email"), request.getParameter("password"));
            request.getSession().setAttribute("klient", klient);
            return "redirect:/home";
        } catch (InvalidUserCredentialsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login.html";
        }
    }
}
