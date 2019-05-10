package dk.kea.dat18i.team8.biotrio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepo;

    @GetMapping("/bookings")
    public String booking(Model model){
        List<Booking> bookingList= bookingRepo.findAllBookings();
        model.addAttribute("booking",bookingList);
        return "show-bookings";
    }

    @PostMapping("/savebookinge")
    @ResponseBody
    public String saveBooking(@ModelAttribute Booking booking){
        Booking bookingAdded = bookingRepo.insertBooking(booking);
        return "Data is saved."+ bookingAdded;
    }

    @GetMapping("/deletebooking/{booking_id}")
    public String deleteBooking (@PathVariable(name="booking_id") int booking_id){
        bookingRepo.deleteBooking(booking_id);
        return "redirect:/bookings";
    }

    @GetMapping("/edit/{booking_id}")
    public String editBooking (Model m, @PathVariable(name="booking_id") int booking_id){
        Booking bookingToEdit= bookingRepo.findBooking(booking_id);
        m.addAttribute("booking",bookingToEdit);
        return "edit-booking";
    }

}
