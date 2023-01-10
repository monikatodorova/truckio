package project.truckio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.truckio.model.*;
import project.truckio.service.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class AdministratorController {

    private final RutaService rutaService;
    private final GradService gradService;
    private final VoziloService voziloService;
    private final DispecerService dispecerService;
    private final RezervacijaService rezervacijaService;
    private final FakturaService fakturaService;


    public AdministratorController(RutaService rutaService, GradService gradService, VoziloService voziloService, DispecerService dispecerService, RezervacijaService rezervacijaService, AdministratorService administratorService, FakturaService fakturaService) {
        this.rutaService = rutaService;
        this.gradService = gradService;
        this.voziloService = voziloService;
        this.dispecerService = dispecerService;
        this.rezervacijaService = rezervacijaService;
        this.fakturaService = fakturaService;
    }

    @GetMapping({"/companyRoutes"})
    public String getCompanyRoutes(HttpServletRequest request, Model model){

        Kompanija kompanija = (Kompanija) request.getSession().getAttribute("kompanija");
        List<Ruta> ruti = this.rutaService.findAllByCompany(kompanija.getKompanija_id());
        model.addAttribute("ruti", ruti);

        return "listCompanyRoutes.html";
    }

    // ADD NEW ROUTE
    @GetMapping({"/addRoute"})
    public String getAddRoutePage(HttpServletRequest request, Model model){

        Kompanija kompanija = (Kompanija) request.getSession().getAttribute("kompanija");
        List<Vozilo> vozila = this.voziloService.findAllByCompany(kompanija.getKompanija_id());
        List<Dispecer> dispeceri = this.dispecerService.findAllByCompany(kompanija.getKompanija_id());
        List<Grad> gradovi = this.gradService.findAll();

        model.addAttribute("gradovi", gradovi);
        model.addAttribute("vozila", vozila);
        model.addAttribute("dispeceri", dispeceri);

        return "addRoute.html";
    }

    @PostMapping({"/addRoute"})
    public String addRuta(@RequestParam Integer zapocnuva_vo,
                           @RequestParam Integer zavrsuva_vo,
                           @RequestParam String datum_trgnuvanje,
                           @RequestParam String datum_pristignuvanje,
                           @RequestParam Integer dispecer,
                           @RequestParam Integer vozilo_id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate trgnuva = LocalDate.parse(datum_trgnuvanje, formatter);
        LocalDate pristignuva = LocalDate.parse(datum_pristignuvanje, formatter);

        Vozilo vozilo = voziloService.findById(vozilo_id).get();
        this.rutaService.addRuta(trgnuva, pristignuva, zapocnuva_vo, zavrsuva_vo, vozilo_id, dispecer, vozilo.getVozac().getVozac_id());
        return "redirect:/companyRoutes";
    }


    // RESERVATION TO CONFIRM
    @GetMapping({"/reservationsToConfirm"})
    public String getReservationsToConfirmPage(HttpServletRequest request, Model model) {

        Kompanija kompanija = (Kompanija) request.getSession().getAttribute("kompanija");
        List<Rezervacija> rezervacii = rezervacijaService.finAllRezervaciiByCompany(kompanija.getKompanija_id());

        model.addAttribute("rezervacii", rezervacii);

        return "reservationsToConfirm.html";
    }

    @PostMapping({"/setActive"})
    public String setActive(HttpServletRequest request,
                            @RequestParam Integer rezervacija_id,
                           @RequestParam Integer iznos) {
        Rezervacija rezervacija = rezervacijaService.findById(rezervacija_id);
        rezervacija.setRezervacija_status("Активна");

        Vraboten vraboten = (Vraboten) request.getSession().getAttribute("vraboten");
        fakturaService.addFaktura(iznos, rezervacija_id, vraboten.getVraboten_id());

        return "redirect:/reservationsToConfirm";
    }

}
