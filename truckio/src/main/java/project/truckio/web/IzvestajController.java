package project.truckio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.truckio.model.*;
import project.truckio.service.IzvestajService;
import project.truckio.service.KompaniiKlientiService;
import project.truckio.service.KompaniiRutiService;
import project.truckio.service.RelacijaRezervaciiService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IzvestajController {

    private final IzvestajService izvestajService;
    private final KompaniiKlientiService kompaniiKlientiService;
    private final RelacijaRezervaciiService relacijaRezervaciiService;
    private final KompaniiRutiService kompaniiRutiService;

    public IzvestajController(IzvestajService izvestajService, KompaniiKlientiService kompaniiKlientiService, RelacijaRezervaciiService relacijaRezervaciiService, KompaniiRutiService kompaniiRutiService) {
        this.izvestajService = izvestajService;
        this.kompaniiKlientiService = kompaniiKlientiService;
        this.relacijaRezervaciiService = relacijaRezervaciiService;
        this.kompaniiRutiService = kompaniiRutiService;
    }

    @GetMapping({"/izvestaj"})
    public String showHomePage(HttpServletRequest request, @RequestParam(required = false) String error, Model model) {

        String role = (String) request.getSession().getAttribute("role");
        if(!role.equals("administrator")) {
            return "redirect:/notAuthorized";
        }

        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        Kompanija kompanija = (Kompanija) request.getSession().getAttribute("kompanija");

        // generalen izvestaj
        Izvestaj generalenIzvestaj = izvestajService.findById(kompanija.getKompanija_id());
        model.addAttribute("generalenIzvestaj", generalenIzvestaj);

        // kompanii-klienti izvestaj
        List<KompaniiKlienti> kompaniiKlientiIzvestaj = kompaniiKlientiService.findByCompanyId(kompanija.getKompanija_id());
        model.addAttribute("kompaniiKlientiIzvestaj", kompaniiKlientiIzvestaj);

        // relacija-rezervacii izvestaj
        List<RelacijaRezervacii> relacijaRezervaciiIzvestaj = relacijaRezervaciiService.findByCompanyId(kompanija.getKompanija_id());
        model.addAttribute("relacijaRezervaciiIzvestaj", relacijaRezervaciiIzvestaj);

        // relacija-ruti izvestaj
        List<KompaniiRuti> kompaniiRutiIzvestaj = kompaniiRutiService.findByCompanyId(kompanija.getKompanija_id());
        model.addAttribute("kompaniiRutiIzvestaj", kompaniiRutiIzvestaj);

        return "izvestaj.html";
    }

}
