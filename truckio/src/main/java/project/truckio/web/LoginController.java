package project.truckio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.truckio.model.*;
import project.truckio.model.exceptions.InvalidUserCredentialsException;
import project.truckio.model.exceptions.InvalidUsernameOrPasswordException;
import project.truckio.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final KlientService klientService;
    private final VrabotenService vrabotenService;
    private final AdministratorService administratorService;
    private final DispecerService dispecerService;
    private final VozacService vozacService;

    public LoginController(KlientService klientService, VrabotenService vrabotenService, AdministratorService administratorService, DispecerService dispecerService, VozacService vozacService) {
        this.klientService = klientService;
        this.vrabotenService = vrabotenService;
        this.administratorService = administratorService;
        this.dispecerService = dispecerService;
        this.vozacService = vozacService;
    }

    @GetMapping
    public String getLoginClientPage(Model model) {
        return "login.html";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        Klient klient = null;
        Vraboten vraboten = null;
        Optional<Administrator> administrator = null;
        Optional<Dispecer> dispecer = null;
        Optional<Vozac> vozac = null;
        request.getSession().setAttribute("role", "none");

        try{
            if(request.getParameter("role").equals("client")) {
                klient = this.klientService.login(request.getParameter("email"), request.getParameter("password"));
                request.getSession().setAttribute("klient", klient);
                request.getSession().setAttribute("role", "klient");
                return "redirect:/routes";
            }

            vraboten = this.vrabotenService.login(request.getParameter("email"), request.getParameter("password"));
            request.getSession().setAttribute("vraboten", vraboten);
            request.getSession().setAttribute("kompanija", vraboten.getKompanija());

            // save employee role in session
            administrator = this.administratorService.findRole(vraboten.getVraboten_id());
            dispecer = this.dispecerService.findRole(vraboten.getVraboten_id());
            vozac = this.vozacService.findRole(vraboten.getVraboten_id());

            if(!administrator.isEmpty()) {
                request.getSession().setAttribute("role", "administrator");
                return "redirect:/companyRoutes";
            } else if(!dispecer.isEmpty()) {
                request.getSession().setAttribute("role", "dispecer");
            } else if(!vozac.isEmpty()) {
                request.getSession().setAttribute("role", "vozac");
            }

            return "redirect:/home";

        } catch (InvalidUsernameOrPasswordException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login.html";
        }
    }
}
