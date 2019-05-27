package dk.kea.dat18i.team8.biotrio.demo.movies;


import dk.kea.dat18i.team8.biotrio.demo.Theater;
import dk.kea.dat18i.team8.biotrio.demo.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    private TheaterRepository theaterRepo;

    @GetMapping("/moviesview")
    @ResponseBody
    public Movie showMovie(){
        Movie movie = movieRepo.showMovie(1);
        return movie;
    }

    @GetMapping("/movies")
    public String movie(Model model){
        List<Movie> movieList= movieRepo.showAllMovies();
        model.addAttribute("movies",movieList);
        return "show-movies";
    }
    @GetMapping("/addmovie")
    public String addMovie(Model model){
        model.addAttribute("movieform", new Movie());

<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/MovieController.java
    @GetMapping("/moviesuser")
    public String moviesUser(Model model){
        List<Movie> movieList= movieRepo.showAllMovies();
        model.addAttribute("movies",movieList);
        return "show-moviesuser";

    }


    @GetMapping("/addmovie")
    public String addMovie(Model model){
        List<Theater> theaterList= theaterRepo.findAllTheaters();
        model.addAttribute( "theaters", theaterList);
        model.addAttribute("movieform", new Movie());

=======
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/movies/MovieController.java
        return "add-movie";
    }

    @PostMapping("/savemovie")
    //@ResponseBody
    public String saveMovie(@ModelAttribute Movie movie){
        //movie.setTheater_id(theaterRepo.findTheater(movie.getTheater_id()));
        movieRepo.insert(movie);
        return "redirect:/movies";
    }

    @GetMapping("/deletemovie/{movie_id}")
    public String deleteMovie (@PathVariable(name="movie_id") int id){
        movieRepo.delete(id);
        return "redirect:/movies";
    }

    @GetMapping("/editmovie/{movie_id}")
    public String editMovie (Model m, @PathVariable(name="movie_id") int id){
<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/MovieController.java
        List<Theater> theaterList= theaterRepo.findAllTheaters();
        m.addAttribute( "theaters", theaterList);
=======
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/movies/MovieController.java
        Movie movieToEdit= movieRepo.showMovie(id);
        m.addAttribute("movie",movieToEdit);
        return "edit-movie";
    }

    @PostMapping("/updateMovie")
    public String saveEditMovie(@ModelAttribute Movie movie){
        movieRepo.update(movie);
        return "redirect:/movies";
    }

}

