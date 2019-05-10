package dk.kea.dat18i.team8.biotrio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.List;



@Controller
public class ScreeningController {

    @Autowired
    private ScreeningRepository screeningRepo;

    @GetMapping("/screeningview")
    @ResponseBody
    public Screening showScreening() {


        Screening screening = screeningRepo.findScreening(1);

        return screening;

    }

    @GetMapping("/screenings")
    public String screening(Model model) {

        List<Screening> screeningList = screeningRepo.findAllScreenings();
        model.addAttribute("screenings", screeningList);

        return "show-screenings";

    }


    @GetMapping("/addscreening")
    public String addScreening(Model model) {

        ScreeningForm newScreening = new ScreeningForm();
        model.addAttribute("screening", newScreening);


        return "add-screening";
    }

    @PostMapping("/savescreening")
    public String saveScreening( @RequestParam("screening-date") String screeningDate, @RequestParam("screening-start") String screeningStart){
        Screening newScreening = new Screening();

        //DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("YYYY-mm-dd");
        //DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");

        newScreening.setScreening_date(LocalDate.parse(screeningDate));

        System.out.println(screeningDate);
        newScreening.setScreening_starts(LocalTime.parse(screeningStart));


        screeningRepo.insertScreening(newScreening);
        System.out.println(newScreening);
        return "redirect:/screenings";
    }

    @RequestMapping(value = "/screenings/delete/{screening_id}")
    public String removeScreening(@PathVariable int screening_id) {

        screeningRepo.deleteScreening(screening_id);

        return "redirect:/screenings";
    }


    @GetMapping("/screenings/edit/{screening_id}")
    public String editCar(Model m, @PathVariable(name = "screening_id") int screening_id){
        Screening screeningToEdit = screeningRepo.findScreening(screening_id);
        m.addAttribute("screening", screeningToEdit);

        return "edit-screening";
    }



    @PostMapping("/updatescreening")
    public String saveEditScreening(@ModelAttribute Screening screening){


        screeningRepo.update(screening);

        return "redirect:/screenings";
    }

}
