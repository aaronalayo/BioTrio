package dk.kea.dat18i.team8.biotrio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbc;




    public List<Booking> findAllBookings(){

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM booking" );

        List<Booking> bookingList = new ArrayList<>();

        while (rs.next()) {
            Booking booking = new Booking();
            booking.setBooking_id(rs.getInt(  "booking_id"));
            booking.setPhoneNo(rs.getString("booking_phoneNo"));
            booking.setSeat_id( rs.getInt( "seat_id" ));
            //booking.setScreening (rs.getScreening( "screening" ));

            bookingList.add(booking);




        }
        return bookingList;

    }

<<<<<<< HEAD
=======
        jdbc.update("DELETE FROM biotrio WHERE booking_id = " + booking_id);
    }
>>>>>>> screenoingcrudfinish
}
