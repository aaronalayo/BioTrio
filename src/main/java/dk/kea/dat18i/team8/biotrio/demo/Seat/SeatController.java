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
        return seatRepo.checkSeats(screeningRepository.findScreening(3));

    }

}
