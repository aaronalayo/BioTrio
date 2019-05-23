package dk.kea.dat18i.team8.biotrio.demo.Seat;

import dk.kea.dat18i.team8.biotrio.demo.screenings.ScreeningRepository;
import dk.kea.dat18i.team8.biotrio.demo.theater.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.List;

@Controller
public class SeatController {

    @Autowired
    private SeatRepository  seatRepo;
    @Autowired
    private ScreeningRepository screeningRepository;


    @GetMapping(path="/api/seats",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Seat> seat(){
        System.out.println(seatRepo.checkSeats(screeningRepository.findScreening(3)));
        return seatRepo.checkSeats(screeningRepository.findScreening(12));

    }
    @GetMapping("/seats")
    public String movie(Model model){
<<<<<<< HEAD
        List<Seat> seatsList= seatRepo.checkSeats(screeningRepository.findScreening(12));
        Theater theater = screeningRepository.findScreening(12).getMovie().getTheater();
        int[] rows= new int[theater.getNumber_of_rows()];
        int[] seatsInRow= new int[theater.getSeats_per_row()];
        for (int i=0;i<theater.getNumber_of_rows();i++){
            rows[i]=i;
        }
        for (int j=0;j<theater.getSeats_per_row();j++){
            seatsInRow[j]=j;
        }
        model.addAttribute("rows",rows);
        model.addAttribute("seatsInRow",seatsInRow);
=======
        List<Seat> seatsList= seatRepo.checkSeats(screeningRepository.findScreening(3));
        Theater theater = screeningRepository.findScreening(3).getMovie().getTheater();
        //for()
>>>>>>> screening
        model.addAttribute("seats",seatsList);
        return "seats";
    }
}
