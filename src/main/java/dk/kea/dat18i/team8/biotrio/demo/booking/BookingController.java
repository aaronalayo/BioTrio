package dk.kea.dat18i.team8.biotrio.demo.booking;

import dk.kea.dat18i.team8.biotrio.demo.Seat.Seat;
import dk.kea.dat18i.team8.biotrio.demo.Seat.SeatCheck;
import dk.kea.dat18i.team8.biotrio.demo.Seat.SeatRepository;
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

    //displays all bookings
    @GetMapping("/bookings")
    public String booking(Model model) {
        List<Booking> bookingList = bookingRepo.findAllBookings();
        model.addAttribute("bookinglist", bookingList);
        return "show-bookings";
    }

    //deletes a booking by its id
    @GetMapping("/deletebooking/{booking_id}")
    public String deleteBooking(@PathVariable(name = "booking_id") int booking_id) {
        bookingRepo.deleteBooking(booking_id);
        return "redirect:/bookings";
    }

    /**
     * for employee
     * displays a list of bookings for a specific phone number
     * displays a message if there are no bookings for this number
     */
    @GetMapping("/bookings-phone")
    public String getBookingsPhone() {
        return "/bookings-phone";
    }
    @PostMapping("/find-booking")
    public String findBookingsByPhone(@RequestParam (value = "search", required = false) String search, Model model) {
        if(!search.isEmpty()) {
            List<Booking> bookingsByPhone = bookingRepo.findBookingsbyPhoneNo(search);
            model.addAttribute("search", bookingsByPhone);
        }
        return "/bookings-phone";
    }

    /**
     * for customer
     * displays a list of bookings for a specific phone number
     * displays a message if there are no bookings for this number
     */
    @GetMapping("/find-bookinguser")
    public String getBookingsPhoneUser() {

        return "/find-bookinguser";
    }
    @PostMapping("/bookings-user")
    public String findBookingsByPhoneUser(@RequestParam (value = "search", required = false) String search, Model model) {

        if(!search.isEmpty()) {
            List<Booking> bookingsByPhone = bookingRepo.findBookingsbyPhoneNo(search);
            model.addAttribute("search", bookingsByPhone);
        }
        return "/find-bookinguser";
    }

    //displays theater seats for a specific screening
    @GetMapping("/seatsforscreening/{screening_id}")
    public String seatsForScreening(Model model,@PathVariable(name="screening_id") int screening_id){

        SeatCheck seatCheck = new SeatCheck(  );

        //sets a list with theater seats for the screening and their availability
        seatCheck.setSeats( seatRepo.checkSeats(screeningRepo.findScreening(screening_id)));
        //sets an arrayList of seats as Strings
        seatCheck.setCheckedSeats( new ArrayList<>());

        model.addAttribute( "screening_id",screeningRepo.findScreening( screening_id ).getScreening_id() );
        model.addAttribute("seatsCheck",seatCheck);
        return "seats";
    }

    //save booking and displays its details
    @PostMapping("/saveseats/{screening_id}")
    public String addSeats(@ModelAttribute SeatCheck seatCheck, Model model,
                           @RequestParam String phonenumber,
                           @PathVariable(name = "screening_id") int screening_id){

        List<Seat> seats=new ArrayList<>();

        /*
        * goes through the list of checked(selected from customer) seats, passed from the html form as list of Strings
        * and adds them to a new list of seats as objects
        * */
        for(String checkedSeat:seatCheck.getCheckedSeats()){
            Seat seat=new Seat();
            String[] seatPlace=checkedSeat.split(  "-");
            seat.setRowNo( Integer.valueOf( seatPlace[0] ) );
            seat.setSeatNo( Integer.valueOf( seatPlace[1] ) );
            seats.add(seat);
        }
        List<Booking> bookingList=new ArrayList<>();

        //goes through the checked seats and create a new booking(ticket) for each of them
        for (Seat seat:seats){
            Booking booking=new Booking();
            booking.setScreening(screeningRepo.findScreening(screening_id));
            booking.setPhone_no(phonenumber);
            booking.setSeat(seat);
            bookingRepo.insertBooking(booking);
            bookingList.add(booking);
            model.addAttribute("booking",booking);
        }
        model.addAttribute("bookingList",bookingList);
        return "booking-details";
    }

    //cancel a booking and redirects to the view with all movies
    @GetMapping("/cancelbooking/{screening_id}")
    public String cancelBooking(@PathVariable(name = "screening_id") int screening_id) {
        bookingRepo.cancelBooking(screening_id);

        return "redirect:/moviesuser";
    }

}