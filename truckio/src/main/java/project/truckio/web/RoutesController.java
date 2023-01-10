package project.truckio.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.truckio.model.*;
import project.truckio.service.KategorijaService;
import project.truckio.service.RezervacijaService;
import project.truckio.service.RobaService;
import project.truckio.service.RutaService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/routes")

public class RoutesController {

    private final RutaService rutaService;
    private final KategorijaService kategorijaService;
    private final RezervacijaService rezervacijaService;
    private final RobaService robaService;

    public RoutesController(RutaService rutaService, KategorijaService kategorijaService, RezervacijaService rezervacijaService, RobaService robaService) {
        this.rutaService = rutaService;
        this.kategorijaService = kategorijaService;
        this.rezervacijaService = rezervacijaService;
        this.robaService = robaService;
    }

    @GetMapping
    public String getAvailableRoutes(Model model){

        List<Ruta> ruti = this.rutaService.findAllAvailable();
        model.addAttribute("ruti", ruti);

        return "listRoutes.html";
    }

    @GetMapping("/details/{id}")
    public String getRouteDetails(@RequestParam(required = false) String error,
                                  @PathVariable String id, Model model){
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Kategorija> kategorii = this.kategorijaService.findAll();
        Ruta ruta = this.rutaService.findById(Integer.parseInt(id));

        // site rezervacii od ruta, site roba od rezervacija
        int vkupnoIskoristeno = 0;
        List<Rezervacija> rezervacii = rezervacijaService.findReservationsForRoute(Integer.valueOf(id));
        for(Rezervacija r : rezervacii) {
            List<Roba> robaList = robaService.findRobaForReservation(r.getRezervacija_id());
            for(Roba roba : robaList) {
                vkupnoIskoristeno += roba.getRoba_kolicina();
            }
        }
        model.addAttribute("preostanatKapacitet", ruta.getVozilo().getVozilo_kapacitet()-vkupnoIskoristeno);
        model.addAttribute("kategorii", kategorii);
        model.addAttribute("ruta", ruta);

        return "routeDetails.html";
    }



}