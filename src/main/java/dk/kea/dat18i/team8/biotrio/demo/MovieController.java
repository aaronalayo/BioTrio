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

    @GetMapping("/movies")
    public String movie(Model model){
      List<Movie> movieList= movieRepo.showallMovies();
      model.addAttribute("movie",movieList);
      return "show-movies";
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
    public String editCar (Model m, @PathVariable(name="id") int id){
        Movie movieToEdit= movieRepo.showMovie(id);
        m.addAttribute("moviefrom",movieToEdit);
        return "edit-car";
    }

    @PostMapping("/updatecar")
    public String saveEditCar(@ModelAttribute Movie movie){
        movieRepo.edit(movie);
        return "redirect:/movies";
    }

}
