package project.truckio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.truckio.model.Kategorija;
import project.truckio.model.Klient;
import project.truckio.model.Rezervacija;
import project.truckio.model.Ruta;
import project.truckio.service.KategorijaService;
import project.truckio.service.RezervacijaService;
import project.truckio.service.RobaService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final KategorijaService kategorijaService;
    private final RezervacijaService rezervacijaService;
    private final RobaService robaService;


    public ReservationController(KategorijaService kategorijaService, RezervacijaService rezervacijaService, RobaService robaService) {
        this.kategorijaService = kategorijaService;
        this.rezervacijaService = rezervacijaService;
        this.robaService = robaService;
    }

    @PostMapping
    public String createReservation(HttpServletRequest request, Model model,
                                    @RequestParam String ruta_id,
                                    @RequestParam(value="kategorija[]") String[] kategorii,
                                    @RequestParam(value="kolicina[]") String[] kolicini) {

        // dodaj rezervacija
        Klient klient = (Klient) request.getSession().getAttribute("klient");
        Rezervacija rezervacija = rezervacijaService.addRezervacija("За одобрување", klient.getKlient_id(), Integer.valueOf(ruta_id));

        // roba za rezervacijata
        for(int i=0; i<kategorii.length; i++) {
            robaService.addRoba(Integer.parseInt(kolicini[i]), rezervacija.getRezervacija_id(), Integer.parseInt(kategorii[i]));
        }

        return "home.html";
    }

    @GetMapping
    public String getMyReservations(HttpServletRequest request, Model model){
        Klient klient = (Klient) request.getSession().getAttribute("klient");
        List<Rezervacija> rezervacii = this.rezervacijaService.findMyReservations(klient.getKlient_id());
        model.addAttribute("rezervacii", rezervacii);

        return "myReservations.html";
    }
}
