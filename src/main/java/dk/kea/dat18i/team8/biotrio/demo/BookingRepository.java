package dk.kea.dat18i.team8.biotrio.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {

    @Autowired

    private JbdcTemplate jbdc;


    //find a booking/bookings by phone number
    //display all bookings
    //insert new booking


    public void deleteBooking(int booking_id) {

        jdbc.update("DELETE FROM biotrio WHERE booking_id = "+booking_id);
}
