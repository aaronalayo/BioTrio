
package dk.kea.dat18i.team8.biotrio.demo.booking;

import dk.kea.dat18i.team8.biotrio.demo.Seat.Seat;
import dk.kea.dat18i.team8.biotrio.demo.Seat.SeatCheck;
import dk.kea.dat18i.team8.biotrio.demo.Seat.SeatRepository;
import dk.kea.dat18i.team8.biotrio.demo.screenings.Screening;
import dk.kea.dat18i.team8.biotrio.demo.screenings.ScreeningForm;
import dk.kea.dat18i.team8.biotrio.demo.screenings.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.util.ArrayList;
import java.util.List;

@Controller
public class BookingController{

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private ScreeningRepository screeningRepo;

    @Autowired
    private SeatRepository seatRepo;


    @GetMapping("/bookings")
    public String booking(Model model) {
        List<Booking> bookingList = bookingRepo.findAllBookings();
        model.addAttribute("bookinglist", bookingList);
        return "show-bookings";
    }

    @GetMapping("/addbooking")
    public String addBooking(Model model) {

        List<Screening> screeningList= screeningRepo.findAllScreenings();
        model.addAttribute( "screening", screeningList);
        model.addAttribute("bookingform", new Booking());
        return "add-booking";
    }

    @PostMapping("/savebooking")
    //@ResponseBody
    public String saveBooking(@ModelAttribute Booking booking) {
        Booking bookingAdded = bookingRepo.insertBooking(booking);
        //return "Data is saved."+ bookingAdded;
        return "redirect:/bookings";
    }


    @GetMapping("/deletebooking/{booking_id}")
    public String deleteBooking(@PathVariable(name = "booking_id") int booking_id) {
        bookingRepo.deleteBooking(booking_id);
        return "redirect:/bookings";
    }


    @GetMapping("/edit/{booking_id}")
    public String editBooking(Model m, @PathVariable(name = "booking_id") int booking_id) {
        Booking bookingToEdit = bookingRepo.findBooking(booking_id);
        m.addAttribute("bookingform", bookingToEdit);
        return "edit-booking";
    }

    @PostMapping("/updatebooking")
    public String saveEditBooking(@ModelAttribute Booking booking) {
        bookingRepo.updateBooking(booking);
        return "redirect:/bookings";
    }

    @GetMapping("/bookings-phone")
    public String getBookingsPhone() {
        return "/bookings-phone";
    }


    @PostMapping("/find-booking")
    public String findBookingsByPhone(@RequestParam String search, @ModelAttribute ScreeningForm screeningForm) {

        bookingRepo.findBookingsbyPhoneNo(search);

        return "/bookings-phone";
    }

    @GetMapping("/seatsforscreening/{screening_id}")
    public String seatsForScreening(Model model,@PathVariable(name="screening_id") int screening_id){

        SeatCheck seatCheck=new SeatCheck(  );
        seatCheck.setSeats( seatRepo.checkSeats(screeningRepo.findScreening(screening_id)));
        seatCheck.setCheckedSeats( new ArrayList<>());

        model.addAttribute( "screening",screeningRepo.findScreening( screening_id ) );
        model.addAttribute("seatsCheck",seatCheck);
        return "seats";
    }


    @PostMapping("/saveseat")
    public String addSeats(@ModelAttribute SeatCheck seatCheck){

        List<Seat> seats=new ArrayList<>(  );

        for(String checkedSeat:seatCheck.getCheckedSeats()){
            Seat seat=new Seat(  );
            String[] seatPlace=checkedSeat.split(  "-");
            seat.setRowNo( Integer.valueOf( seatPlace[0] ) );
            seat.setSeatNo( Integer.valueOf( seatPlace[1] ) );
            seats.add(seat);
        }
        System.out.println(seats);


        return "checked-seats";
    }




//    @RequestMapping(value = "/processSeatForm", method=RequestMethod.POST)
//    public String processForm(@ModelAttribute(value="seats") SeatCheck seatCheck) {
//        // Get value of checked item.
//
//        List<String> selectedSeats = seatCheck.getCheckedSeats();
//
//        return "checked-seats";
//    }
}
