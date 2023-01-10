package project.truckio.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import project.truckio.model.Rezervacija;
import project.truckio.model.Roba;
import project.truckio.model.Vraboten;
import project.truckio.service.RezervacijaService;
import project.truckio.service.RobaService;
import project.truckio.service.RutaService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private final RutaService rutaService;
    private final RezervacijaService rezervacijaService;
    private final RobaService robaService;

    public DriverController(RutaService rutaService, RezervacijaService rezervacijaService, RobaService robaService) {
        this.rutaService = rutaService;
        this.rezervacijaService = rezervacijaService;
        this.robaService = robaService;
    }

    @GetMapping("/active-routes")
    public String getActiveRoutesPage(HttpServletRequest request, Model model){

        Vraboten vraboten = (Vraboten) request.getSession().getAttribute("vraboten");
        Integer vraboten_id = vraboten.getVraboten_id();

        model.addAttribute("ruti", this.rutaService.findAllActiveByVozac(vraboten_id));

        return "driverRoutes.html";
    }

    @GetMapping("/route-details/{id}")
    public String getActiveRouteDetailsPage(@PathVariable String id, Model model) {

        Integer rutaId = Integer.parseInt(id);
        Rezervacija rezervacija = this.rezervacijaService.findByRuta(rutaId).get(0);
        List<Roba> robaList = this.robaService.findRobaForReservation(rezervacija.getRezervacija_id());

        /*for (Rezervacija rezervacija : rezervacii) {
            Roba robaInReservation = (Roba) this.robaService.findRobaForReservation(rezervacija.getRezervacija_id()).get(0);
            robaList.add(robaInReservation);
        }*/

        /*for (Rezervacija rezervacija : rezervacii) {
            List<Roba> robaInReservation = this.robaService.findRobaForReservation(rezervacija.getRezervacija_id());
            for (Roba roba : robaInReservation) {
                robaList.add(roba);
            }
        }*/

        //System.out.println(this.robaService.findRobaForReservation(rezervacija.getRezervacija_id()));

        model.addAttribute("roba", robaList);
        model.addAttribute("ruta", this.rutaService.findById(rutaId));

        return "driverRouteDetails.html";
    }

}
