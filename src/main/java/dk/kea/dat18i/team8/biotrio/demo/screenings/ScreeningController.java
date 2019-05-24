package dk.kea.dat18i.team8.biotrio.demo.screenings;
<<<<<<< HEAD

=======
>>>>>>> screening

import dk.kea.dat18i.team8.biotrio.demo.movies.Movie;
import dk.kea.dat18i.team8.biotrio.demo.movies.MovieRepository;
import dk.kea.dat18i.team8.biotrio.demo.theater.Theater;
import dk.kea.dat18i.team8.biotrio.demo.theater.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import java.util.ArrayList;
import java.util.List;



@Controller
public class ScreeningController {

    @Autowired
    private ScreeningRepository screeningRepo;
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    private TheaterRepository theaterRepo;


    @GetMapping("/screeningview")
    @ResponseBody
    public Screening showScreening() {


        Screening screening = screeningRepo.findScreening(1);

        return screening;

    }

    @GetMapping("/screenings")
    public String screening(Model model) {


        List<Screening> screeningList = screeningRepo.findAllScreenings();
        model.addAttribute("screeninglist", screeningList);


        return "screening/show-screenings";

    }


    @GetMapping("/addscreening")
    public String addScreening(Model model) {

        ScreeningForm screeningForm = new ScreeningForm();
        List<Movie> movieList = movieRepo.showAllMovies();
        List<Theater> theaterList= theaterRepo.findAllTheaters();
        model.addAttribute(  "movielist", movieList );
        model.addAttribute( "theaterlist", theaterList );

        model.addAttribute( "screeningForm", screeningForm);

        return "screening/add-screening";
    }

    @PostMapping("/savescreening")
    public String saveScreening(@ModelAttribute ScreeningForm screeningData){
        Screening newScreening = new Screening();
<<<<<<< HEAD


          DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "yyyy MM dd HH:mm" );
          newScreening.setShowing( LocalDateTime.parse(screeningData.getShowing(),dtf ));
=======
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "yyyy MM dd HH:mm" );
>>>>>>> screening

        newScreening.setMovie( movieRepo.showMovie( screeningData.getMovie_id() ) );
        newScreening.setTheater( theaterRepo.findTheater( screeningData.getTheater_id() ) );
        screeningRepo.insertScreening(newScreening);

        return "redirect:/screenings";
    }

    @RequestMapping(value = "screenings/delete/{screening_id}")
    public String removeScreening(@PathVariable int screening_id) {

        screeningRepo.deleteScreening(screening_id);

        return "redirect:/screenings";
    }


    @GetMapping("/screenings/edit/{screening_id}")
    public String editScreening(Model model, @PathVariable(name = "screening_id") int screening_id){

        Screening screeningToEdit = screeningRepo.findScreening(screening_id);
        model.addAttribute("screening", screeningToEdit);
        ScreeningForm screeningForm2 = new ScreeningForm(  );

        List<Movie> movieList2 = movieRepo.showAllMovies();
        List<Theater> theaterList2 = theaterRepo.findAllTheaters();

        model.addAttribute(  "movielist2", movieList2 );
        model.addAttribute( "theaterlist2", theaterList2 );
        model.addAttribute( "screeningForm2", screeningForm2);

        return "screening/edit-screening";
    }

    @PostMapping("/updatescreening")
    public String saveEditScreening( @ModelAttribute Screening upScreening, @ModelAttribute ScreeningForm screeningData){


        upScreening.setShowing( upScreening.getShowing() );
        upScreening.setMovie( movieRepo.showMovie( screeningData.getMovie_id() ));
        upScreening.setTheater( theaterRepo.findTheater( screeningData.getTheater_id() ) );

        screeningRepo.update(upScreening);

        return "redirect:/screenings";
    }
    @GetMapping("/screeningbymovie/{movie_id}")
    public String screeningByMovie(Model model, @PathVariable(name = "movie_id") int movie_id){

<<<<<<< HEAD
=======

>>>>>>> screening
        List<Screening> screeningsForMovies= screeningRepo.findScreeningsWithMovie( movie_id );


        model.addAttribute( "screeningsForMovies", screeningsForMovies);

        return "movies-screenings";

    }
<<<<<<< HEAD




    @GetMapping("/screenings-date")
    public String getScreeningsDate(){
        return "/screenings-date";
    }

    @PostMapping("/screenings-search")
    public String showScreeningsByDate(@RequestParam (value = "search", required = false) String search, Model model) {

        if(!search.isEmpty()) {

            List<Screening> screeningSearch = screeningRepo.findScreeningsByDate( search );
            model.addAttribute( "search", screeningSearch );
        }else
            return "/screenings-date";



        return "/screenings-date";
    }
}

}

