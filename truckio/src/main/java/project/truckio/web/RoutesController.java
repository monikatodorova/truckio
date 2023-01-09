package project.truckio.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.truckio.model.Ruta;
import project.truckio.service.RutaService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/routes")
public class RoutesController {

    private final RutaService rutaService;

    public RoutesController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    @GetMapping
    public String getAvailableRoutes(Model model){
        System.out.println("GET in RoutesClientController");

        List<Ruta> ruti = this.rutaService.findAll();
        model.addAttribute("ruti", ruti);

        return "listRoutes.html";
    }

    @GetMapping("/details/{id}")
    public String getRouteDetails(@PathVariable String id, Model model){
        System.out.println("POST in /routes/details/{id}");

        //selected route_id
        System.out.println("Route_Id: " + id);

        Ruta ruta = this.rutaService.findById(Integer.parseInt(id));
        model.addAttribute("Ruta", ruta);

        return "routeDetails.html";
    }


}
