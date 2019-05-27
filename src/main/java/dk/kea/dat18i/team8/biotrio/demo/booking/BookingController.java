
package dk.kea.dat18i.team8.biotrio.demo.booking;

import dk.kea.dat18i.team8.biotrio.demo.Seat.Seat;
import dk.kea.dat18i.team8.biotrio.demo.Seat.SeatCheck;
import dk.kea.dat18i.team8.biotrio.demo.Seat.SeatRepository;
import dk.kea.dat18i.team8.biotrio.demo.screenings.Screening;
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


    @GetMapping("/edit/{booking_id}")
    public String editBooking(Model m, @PathVariable(name = "booking_id") int booking_id) {



        Booking bookingToEdit = bookingRepo.findBooking(booking_id);
        Seat seat = new Seat();
        seat.setRowNo( seat.getRowNo() );
        seat.setSeatNo( seat.getSeatNo() );
        bookingToEdit.setSeat( seat );
        bookingToEdit.setPhone_no( bookingToEdit.getPhone_no() );
        Screening screening =new Screening(  );
        bookingToEdit.setScreening(screeningRepo.findScreening( screening.getScreening_id()));

        m.addAttribute("bookingform", bookingToEdit);

        return "edit-booking";
    }

//    @PostMapping("/updatebooking")
//    public String saveBooking(@ModelAttribute Booking booking,  @ModelAttribute Seat seat, @ModelAttribute Screening screening) {
//
//
//
//        booking.setPhone_no( booking.getPhone_no() );
//        seat.setRowNo( seat.getRowNo() );
//        seat.setSeatNo( seat.getSeatNo() );
//        booking.setSeat( seat );
//        booking.setScreening( screeningRepo.findScreening( screening.getScreening_id() ));
//
//        bookingRepo.updateBooking(booking);
//        return "redirect:/bookings";
//    }


    @GetMapping("/deletebooking/{booking_id}")
    public String deleteBooking(@PathVariable(name = "booking_id") int booking_id) {
        bookingRepo.deleteBooking(booking_id);
        return "redirect:/bookings";
    }



    @GetMapping("/bookings-phone")
    public String getBookingsPhone() {


        return "/bookings-phone";
    }
    @PostMapping("/find-booking")
    public String findBookingsByPhone(@RequestParam (value = "search", required = false) String search, Model model) {

        List<Booking> bookingsByPhone = bookingRepo.findBookingsbyPhoneNo(search);
        model.addAttribute("search", bookingsByPhone);

        return "/bookings-phone";
    }

    @GetMapping("/seatsforscreening/{screening_id}")
    public String seatsForScreening(Model model,@PathVariable(name="screening_id") int screening_id){

        SeatCheck seatCheck = new SeatCheck(  );
        seatCheck.setSeats( seatRepo.checkSeats(screeningRepo.findScreening(screening_id)));
        seatCheck.setCheckedSeats( new ArrayList<>());

        model.addAttribute( "screening_id",screeningRepo.findScreening( screening_id ).getScreening_id() );
        model.addAttribute("seatsCheck",seatCheck);
        return "seats";
    }


    @PostMapping("/saveseats/{screening_id}")
    public String addSeats(@ModelAttribute SeatCheck seatCheck, Model model,
                           @RequestParam String phonenumber,
                           @PathVariable(name = "screening_id") int screening_id){

        List<Seat> seats=new ArrayList<>();

        for(String checkedSeat:seatCheck.getCheckedSeats()){
            Seat seat=new Seat();
            String[] seatPlace=checkedSeat.split(  "-");
            seat.setRowNo( Integer.valueOf( seatPlace[0] ) );
            seat.setSeatNo( Integer.valueOf( seatPlace[1] ) );
            seats.add(seat);
        }
        List<Booking> bookingList=new ArrayList<>();

        for (Seat seat:seats){
            Booking booking=new Booking();
            booking.setScreening(screeningRepo.findScreening(screening_id));
            booking.setPhone_no(phonenumber);
            booking.setSeat(seat);
            System.out.println(booking);
            bookingRepo.insertBooking(booking);
            bookingList.add(booking);
            model.addAttribute("booking",booking);
        }
        model.addAttribute("bookingList",bookingList);
        return "booking-details";
    }

}
