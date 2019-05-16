<<<<<<< HEAD
package dk.kea.dat18i.team8.biotrio.demo.theater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class TheaterController {

    @Autowired
    private TheaterRepository theaterRepo;
    
    @GetMapping("/theaters")
    public String theater(Model model) {

        List<Theater> theaterList = theaterRepo.findAllTheaters();
        model.addAttribute( "theaters", theaterList);

        return "show-theaters";

    }

    @GetMapping("/addtheater")
    public String addTheater(Model model){
        model.addAttribute("theaterform", new Theater());
        return "add-theater";
    }

    @PostMapping("/savetheater")
//    @ResponseBody
    public String saveTheater(@ModelAttribute Theater theater){

        Theater theaterInserted = theaterRepo.insert(theater);

        return "redirect:/theaters";
    }

    @GetMapping("/deletetheater/{theater_id}")
    public String deleteTheater(@PathVariable(name = "theater_id") int theater_id){
        theaterRepo.delete(theater_id);
        return "redirect:/theaters";
    }

    @GetMapping("/edittheater/{theater_id}")
<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/theater/TheaterController.java
    public String editTheater(Model m, @PathVariable(name = "theater_id") int id){
=======
    public String editCar(Model m, @PathVariable(name = "theater_id") int id){
>>>>>>> theater:src/main/java/dk/kea/dat18i/team8/biotrio/demo/TheaterController.java
        Theater theaterToEdit = theaterRepo.findTheater(id);
        m.addAttribute("theaterform", theaterToEdit);
        return "edit-theater";
    }


    @PostMapping("/updatetheater")
<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/theater/TheaterController.java
    public String s(@ModelAttribute Theater theater){
=======
    public String saveEditTheater(@ModelAttribute Theater theater){
>>>>>>> theater:src/main/java/dk/kea/dat18i/team8/biotrio/demo/TheaterController.java
        theaterRepo.update(theater);
        return "redirect:/theaters";
    }
}
=======
package dk.kea.dat18i.team8.biotrio.demo.theater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class TheaterController {

    @Autowired
    private TheaterRepository theaterRepo;
    
    @GetMapping("/theaters")
    public String theater(Model model) {

        List<Theater> theaterList = theaterRepo.findAllTheaters();
        model.addAttribute( "theaters", theaterList);

        return "show-theaters";

    }

    @GetMapping("/addtheater")
    public String addTheater(Model model){
        model.addAttribute("theaterform", new Theater());
        return "add-theater";
    }

    @PostMapping("/savetheater")
//    @ResponseBody
    public String saveTheater(@ModelAttribute Theater theater){

        Theater theaterInserted = theaterRepo.insert(theater);

        return "redirect:/theaters";
    }

    @GetMapping("/deletetheater/{id}")
    public String deleteTheater(@PathVariable(name = "id") int id){
        theaterRepo.delete(id);
        return "redirect:/theaters";
    }

    @GetMapping("/edittheater/{theater_id}")
    public String editTheater(Model m, @PathVariable(name = "theater_id") int id){
        Theater theaterToEdit = theaterRepo.findTheater(id);
        m.addAttribute("theaterform", theaterToEdit);
        return "edit-theater";
    }

    @PostMapping("/updatetheater")
    public String s(@ModelAttribute Theater theater){
        theaterRepo.update(theater);
        return "redirect:/theaters";
    }

}
>>>>>>> screening
