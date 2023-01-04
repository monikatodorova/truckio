package project.truckio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.truckio.model.Kompanija;
import project.truckio.service.KompanijaService;

import java.util.List;

@Controller
public class HomeController {

    private final KompanijaService kompanijaService;

    public HomeController(KompanijaService kompanijaService) {
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
