package dk.kea.dat18i.team8.biotrio.demo.booking;

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
            booking.setSeat_id(rs.getInt("seat"));
            booking.setPhone_no(rs.getString("phone_no"));
           // screening.getScreening.getScreening_id(rs.getInt("screening_id"));

        }
        return booking;
    }


    public List<Booking> findAllBookings() {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking");

        List<Booking> bookingList = new ArrayList<>();

        while (rs.next()) {
            Booking booking = new Booking();
            booking.setBooking_id(rs.getInt("booking_id"));
            booking.setSeat_id(rs.getInt("seat"));
            booking.setPhone_no(rs.getString("phone_no"));
            //booking.setScreening().setScreening_id();

            bookingList.add(booking);

        }
        return bookingList;

    }


    public Booking insertBooking(Booking booking) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("INSERT INTO booking VALUES (null, ?, ?, ?)  VALUES  (null,?,?,?)", new String[]{"booking_id"});

                ps.setInt(1, booking.getBooking_id());
                ps.setInt(2, booking.getSeat_id());
                ps.setString(3, booking.getPhone_no());
                ps.setInt(4, booking.getScreening().getScreening_id());

                return ps;
            }
        };


        KeyHolder booking_id = new GeneratedKeyHolder();
        jdbc.update(psc, booking_id);
        booking.setBooking_id(booking_id.getKey().intValue());
        return booking;
    }

    public void deleteBooking(int booking_id) {

        jdbc.update("DELETE FROM booking WHERE booking_id = " + booking_id);
    }

    public void updateBooking(Booking booking) {

        jdbc.update("UPDATE bookings SET " +
                "booking_id='" + booking.getBooking_id() + "', " +
                "seat_id='" + booking.getSeat_id() + "', " +
                "phone_no'" + booking.getPhone_no() + "', " +
                "screening_id='" + booking.getScreening() + "' " +
                "WHERE booking_id=" + booking.getBooking_id());
    }

}