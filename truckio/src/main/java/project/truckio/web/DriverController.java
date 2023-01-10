package project.truckio.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.truckio.service.RutaService;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private final RutaService rutaService;

    public DriverController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    @GetMapping("/active-routes")
    public String getActiveRoutes(Model model){

        //pagja
        System.out.println(rutaService.findActiveRoutesForVozac(7));

        return null;
    }

}
