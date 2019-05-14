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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


import java.util.List;



@Controller
public class ScreeningController {

    @Autowired
    private ScreeningRepository screeningRepo;
    @Autowired
    private MovieRepository movieRepo;

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

       ScreeningForm screeningForm = new ScreeningForm();
       List<Movie> movieList = movieRepo.showallMovies();
        model.addAttribute(  "movielist", movieList );

        model.addAttribute( "screeningForm", screeningForm);
        return "add-screening";
    }

    @PostMapping("/savescreening")
    public String saveScreening(@RequestParam("screening-date") String screeningDate, @ModelAttribute ScreeningForm screeningData,
                                @RequestParam("movie-id") int movieId){


        Screening newScreening = new Screening();

        newScreening.setScreening_date(LocalDate.parse(screeningDate));

        System.out.println(screeningDate);

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy MM dd");

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm");

        //newScreening.setScreening_date( LocalDate.parse(screeningData.getScreening_date_form(),dtf1));

        newScreening.setScreening_starts( LocalTime.parse(screeningData.getScreening_starts_form(),dtf2));


        System.out.println(movieId);
        newScreening.setMovie(movieRepo.showMovie( movieId ));

        screeningRepo.insertScreening(newScreening);

        return "redirect:/screenings";
    }

    @RequestMapping(value = "/screenings/delete/{screening_id}")
    public String removeScreening(@PathVariable int screening_id) {

        screeningRepo.deleteScreening(screening_id);

        return "redirect:/screenings";
    }


    @GetMapping("/screenings/edit/{screening_id}")
    public String editScreening(Model m, @PathVariable(name = "screening_id") int screening_id){

        Screening screeningToEdit = screeningRepo.findScreening(screening_id);
        m.addAttribute("screening", screeningToEdit);

        return "edit-screening";
    }



    @PostMapping("/updatescreening")
    public String saveEditScreening( @RequestParam("screening-date") String screeningDate, @RequestParam("screening-start") String screeningStart){

        Screening upScreening = new Screening();
        upScreening.setScreening_date(LocalDate.parse(screeningDate));
        upScreening.setScreening_starts(LocalTime.parse(screeningStart));

        screeningRepo.update(upScreening);

        return "redirect:/screenings";
    }

}
