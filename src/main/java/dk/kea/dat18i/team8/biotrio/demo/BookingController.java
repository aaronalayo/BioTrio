package dk.kea.dat18i.team8.biotrio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public class BookingController {

    @Autowired

    private BookingRepository bookingRepo;

    //  @GetMapping("\mybooking")


    //  @GetMapping("\addbooking")


    //  @PostMapping("\savebooking")

    @GetMapping("/deletebooking/{booking_id}")

    public String deleteBooking(@PathVariable(name = "booking_id") int booking_id) {

        bookingRepo.deleteBooking(booking_id);

        return "redirect:/mybooking";


        @ResponseBody

        public Booking showBooking(){

            //Booking booking = bookingRepo.findBooking(booking_id: 1);

            return booking;

        }
    }
}
