package project.truckio.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotAuthorizedController {
    @GetMapping({"/notAuthorized"})
    public String showPage(@RequestParam(required = false) String error, Model model) {

        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        return "notAuthorized.html";
    }
}
