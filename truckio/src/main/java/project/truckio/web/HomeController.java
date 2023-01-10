package project.truckio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.truckio.model.Kompanija;
import project.truckio.model.Vraboten;
import project.truckio.model.passwordencrypt.CryptWithMD5;
import project.truckio.service.AdministratorService;
import project.truckio.service.KompanijaService;
import project.truckio.service.VrabotenService;

import java.util.List;

@Controller
public class HomeController {
    private final VrabotenService vrabotenService;

    private final KompanijaService kompanijaService;

    public HomeController(VrabotenService vrabotenService, KompanijaService kompanijaService) {
        this.vrabotenService = vrabotenService;
        this.kompanijaService = kompanijaService;
    }

    @GetMapping({"/", "/home"})
    public String showHomePage(@RequestParam(required = false) String error, Model model) {

        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Kompanija> kompanii = kompanijaService.listAll();
        model.addAttribute("kompanii", kompanii);
        return "home.html";

    }


}
