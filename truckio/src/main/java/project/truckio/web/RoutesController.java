package project.truckio.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.truckio.model.Kategorija;
import project.truckio.model.Ruta;
import project.truckio.service.KategorijaService;
import project.truckio.service.RutaService;

import java.util.List;

@Controller
@RequestMapping("/routes")

public class RoutesController {

    private final RutaService rutaService;
    private final KategorijaService kategorijaService;

    public RoutesController(RutaService rutaService, KategorijaService kategorijaService) {
        this.rutaService = rutaService;
        this.kategorijaService = kategorijaService;
    }

    @GetMapping
    public String getAvailableRoutes(Model model){

        List<Ruta> ruti = this.rutaService.findAllAvailable();
        model.addAttribute("ruti", ruti);

        return "listRoutes.html";
    }

    @GetMapping("/details/{id}")
    public String getRouteDetails(@PathVariable String id, Model model){
        List<Kategorija> kategorii = this.kategorijaService.findAll();
        Ruta ruta = this.rutaService.findById(Integer.parseInt(id));
        model.addAttribute("kategorii", kategorii);
        model.addAttribute("ruta", ruta);

        return "routeDetails.html";
    }


}