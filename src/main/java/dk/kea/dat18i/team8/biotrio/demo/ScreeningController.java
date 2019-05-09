package dk.kea.dat18i.team8.biotrio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class ScreeningController {

    @Autowired
    private ScreeningRepository screeningRepo;

    @GetMapping("/screenings")
    public String screening(Model model) {

        List<Screening> screeningList = screeningRepo.findAllScreenings();
        model.addAttribute( "screenings", screeningList );

        return "show-screenings";

    }

}
