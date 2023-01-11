package project.truckio.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.truckio.model.Rezervacija;
import project.truckio.model.Roba;
import project.truckio.model.Vraboten;
import project.truckio.service.RezervacijaService;
import project.truckio.service.RobaService;
import project.truckio.service.RutaService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/dispatcher")
public class DispatcherController {

    private final RutaService rutaService;
    private final RezervacijaService rezervacijaService;
    private final RobaService robaService;

    public DispatcherController(RutaService rutaService, RezervacijaService rezervacijaService, RobaService robaService) {
        this.rutaService = rutaService;
        this.rezervacijaService = rezervacijaService;
        this.robaService = robaService;
    }

    @GetMapping("/activeRoutes")
    public String getActiveRoutesPage(HttpServletRequest request, Model model){

        String role = (String) request.getSession().getAttribute("role");
        if(!role.equals("dispecer")) {
            return "redirect:/notAuthorized";
        }

        Vraboten vraboten = (Vraboten) request.getSession().getAttribute("vraboten");
        Integer vraboten_id = vraboten.getVraboten_id();

        model.addAttribute("ruti", this.rutaService.findAllActiveByDispecer(vraboten_id));

        return "dispatcherRoutes.html";
    }

    @GetMapping("/details/{id}")
    public String getRouteDetailsPage(HttpServletRequest request, @PathVariable String id, Model model){

        String role = (String) request.getSession().getAttribute("role");
        if(!role.equals("dispecer")) {
            return "redirect:/notAuthorized";
        }

        Rezervacija rezervacija = this.rezervacijaService.findByRuta(Integer.parseInt(id)).get(0);
        List<Roba> robaList = robaService.findRobaForReservation(Integer.valueOf(rezervacija.getRezervacija_id()));

        model.addAttribute("rezervacija", rezervacija);
        model.addAttribute("robaList", robaList);

        return "dispatcherReservationDetails.html";
    }

    @PostMapping("/finishedReservation")
    public String setFinishedReservation(HttpServletRequest request, @RequestParam String rezervacija_id){

        String role = (String) request.getSession().getAttribute("role");
        if(!role.equals("dispecer")) {
            return "redirect:/notAuthorized";
        }

        Rezervacija rezervacija = this.rezervacijaService.findById(Integer.parseInt(rezervacija_id));
        rezervacijaService.updateStatus(rezervacija, "Завршена");
        return "redirect:/dispatcher/activeRoutes";

    }

}