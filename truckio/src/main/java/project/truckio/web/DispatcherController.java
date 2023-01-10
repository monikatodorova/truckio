package project.truckio.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.truckio.model.Rezervacija;
import project.truckio.model.Vraboten;
import project.truckio.service.RezervacijaService;
import project.truckio.service.RutaService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dispatcher")
public class DispatcherController {

    private final RutaService rutaService;
    private final RezervacijaService rezervacijaService;

    public DispatcherController(RutaService rutaService, RezervacijaService rezervacijaService) {
        this.rutaService = rutaService;
        this.rezervacijaService = rezervacijaService;
    }

    @GetMapping("/routes")
    public String getActiveRoutesPage(HttpServletRequest request, Model model){

        Vraboten vraboten = (Vraboten) request.getSession().getAttribute("vraboten");
        Integer vraboten_id = vraboten.getVraboten_id();

        //System.out.println(vraboten_id);
        //System.out.println("Role: " + request.getSession().getAttribute("role"));

        model.addAttribute("ruti", this.rutaService.findAllActiveByDispecer(vraboten_id));

        return "dispatcherRoutes.html";
    }

    @GetMapping("/details/{id}")
    public String getRouteDetailsPage(@PathVariable String id, Model model){

        System.out.println("ID: " + id);

        Rezervacija rezervacija = this.rezervacijaService.findByRuta(Integer.parseInt(id)).get(0);
        //System.out.println(rezervacija);

        model.addAttribute("rezervacija", rezervacija);

        return "dispatcherReservStat.html";
    }

    @PostMapping("/finishedReservation")
    public String setFinishedReservation(@RequestParam String rezervacija_id){

        Rezervacija rezervacija = this.rezervacijaService.findById(Integer.parseInt(rezervacija_id));
        String status = "Откажана";

        rezervacija.setRezervacija_status(status);
        return "dispatcherRoutes.html";

    }




}
