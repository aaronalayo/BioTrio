package dk.kea.dat18i.team8.biotrio.demo.Seat;

import dk.kea.dat18i.team8.biotrio.demo.booking.Booking;
import dk.kea.dat18i.team8.biotrio.demo.booking.BookingRepository;
import dk.kea.dat18i.team8.biotrio.demo.screenings.Screening;
import dk.kea.dat18i.team8.biotrio.demo.screenings.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeatRepository {
    @Autowired
    private ScreeningRepository screeningRepo;
    @Autowired
    private BookingRepository bookingRepo;

    //public List<Seat> getSeatStatus(int screening_id){
      //  Screening screening = screeningRepo.findScreening(screening_id);
        //List<Booking> screeningBookings=bookingRepo.findBookingForScreening();
        //List<Seat> theaterSeats = new ArrayList<>();
        //for(int i=0;i<screening.)
    //}
}
