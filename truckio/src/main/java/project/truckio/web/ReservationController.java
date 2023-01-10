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
@RequestMapping("/reservations")
public class ReservationController {

    private final KategorijaService kategorijaService;
    private final RezervacijaService rezervacijaService;
    private final RobaService robaService;
    private final RutaService rutaService;


    public ReservationController(KategorijaService kategorijaService, RezervacijaService rezervacijaService, RobaService robaService, RutaService rutaService) {
        this.kategorijaService = kategorijaService;
        this.rezervacijaService = rezervacijaService;
        this.robaService = robaService;
        this.rutaService = rutaService;
    }

    @PostMapping
    public String createReservation(HttpServletRequest request, Model model,
                                    @RequestParam String ruta_id,
                                    @RequestParam(value="kategorija[]", required = false) String[] kategorii,
                                    @RequestParam(value="kolicina[]", required = false) String[] kolicini) {

        if(kategorii == null) {
            return "redirect:/routes/details/" + ruta_id + "/?error=noCategorySelectedError";
        }

        // dodaj rezervacija
        Klient klient = (Klient) request.getSession().getAttribute("klient");

        Ruta ruta = rutaService.findById(Integer.valueOf(ruta_id));
        Vozilo vozilo = ruta.getVozilo();

        int vkupnoKolicini = 0;
        for(int i=0; i<kolicini.length; i++) {
            vkupnoKolicini+=Integer.parseInt(kolicini[i]);
        }

        // site rezervacii od ruta, site roba od rezervacija
        int vkupnoIskoristeno = 0;
        List<Rezervacija> rezervacii = rezervacijaService.findReservationsForRoute(Integer.valueOf(ruta_id));
        for(Rezervacija r : rezervacii) {
            List<Roba> robaList = robaService.findRobaForReservation(r.getRezervacija_id());
            for(Roba roba : robaList) {
                vkupnoIskoristeno += roba.getRoba_kolicina();
            }
        }

        // ako ima kapacitet dodadi i prenasoci na moi rezervacii
        if(vozilo.getVozilo_kapacitet() - vkupnoIskoristeno > vkupnoKolicini) {
            Rezervacija rezervacija = rezervacijaService.addRezervacija("За одобрување", klient.getKlient_id(), Integer.valueOf(ruta_id));
            // roba za rezervacijata
            for(int i=0; i<kategorii.length; i++) {
                robaService.addRoba(Integer.parseInt(kolicini[i]), rezervacija.getRezervacija_id(), Integer.parseInt(kategorii[i]));
            }
            return "/myReservations";
        }

        return "redirect:/routes/details/" + ruta_id + "/?error=capacityError";

    }

    @GetMapping
    public String getMyReservations(HttpServletRequest request, Model model){
        Klient klient = (Klient) request.getSession().getAttribute("klient");
        List<Rezervacija> rezervacii = this.rezervacijaService.findMyReservations(klient.getKlient_id());
        model.addAttribute("rezervacii", rezervacii);

        return "myReservations.html";
    }

    @GetMapping("/details/{rezervacija_id}")
    public String getReservationDetails(@PathVariable String rezervacija_id, HttpServletRequest request, Model model){
        Klient klient = (Klient) request.getSession().getAttribute("klient");
        Rezervacija rezervacija = rezervacijaService.findById(Integer.valueOf(rezervacija_id));
        List<Roba> robaList = robaService.findRobaForReservation(Integer.valueOf(rezervacija_id));

        model.addAttribute("rezervacija", rezervacija);
        model.addAttribute("robaList", robaList);

        return "reservationDetails.html";
    }
}
