package dk.kea.dat18i.team8.biotrio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepo;

    @GetMapping("/moviesview")
    @ResponseBody
    public Movie showMovie(){
        Movie movie = movieRepo.showMovie(1);
        return movie;
    }

    @GetMapping("/movies")
    public String movie(Model model){
      List<Movie> movieList= movieRepo.showallMovies();
      model.addAttribute("movies",movieList);
      return "show-movies";
    }
    @GetMapping("/addmovie")
    public String addMovie(Model model){
        model.addAttribute("movieform", new Movie());
        return "add-movie";
    }

    @PostMapping("/savemovie")
    @ResponseBody
    public String saveMovie(@ModelAttribute Movie movie){
        Movie movieAdded = movieRepo.insert(movie);
        return "Data is saved."+ movieAdded;
    }

    @GetMapping("/deletemovie/{id}")
    public String deleteMovie (@PathVariable(name="id") int id){
        movieRepo.delete(id);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String editMovie (Model m, @PathVariable(name="id") int id){
        Movie movieToEdit= movieRepo.showMovie(id);
        m.addAttribute("moviefrom",movieToEdit);
        return "edit-car";
    }

    @PostMapping("/updateMovie")
    public String saveEditMovie(@ModelAttribute Movie movie){
        movieRepo.edit(movie);
        return "redirect:/movies";
    }

}
