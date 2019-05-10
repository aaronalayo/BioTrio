package dk.kea.dat18i.team8.biotrio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbc;


    public Booking findBooking(int booking_id) {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking WHERE booking_id = " + booking_id);

        Booking booking = new Booking();

        while (rs.next()) {

            booking.setBooking_id(rs.getInt("booking_id"));
            booking.setPhoneNo(rs.getString("phoneNo"));
            booking.setSeat_id(rs.getInt("seat_id"));

        }
        return booking;
    }


    public List<Booking> findAllBookings() {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking");

        List<Booking> bookingList = new ArrayList<>();

        while (rs.next()) {
            Booking booking = new Booking();
            booking.setBooking_id(rs.getInt("booking_id"));
            booking.setPhoneNo(rs.getString("phoneNo"));
            booking.setSeat_id(rs.getInt("seat_id"));
            //booking.setScreeningBooked(rs.getScreening("screeningBooked"));


        }
        return bookingList;

    }


    public Booking insertBooking(Booking booking) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("INSERT INTO biotrio.booking  (booking_id, phoneNo, seat_id)  VALUES  (?,?,1)", new String[]{"booking_id"});


                return ps;
            }
        };


        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        booking.setBooking_id(id.getKey().intValue());
        return booking;
    }

    public void deleteBooking(int booking_id) {

        jdbc.execute("DELETE FROM booking WHERE booking_id = " + booking_id);
    }

}