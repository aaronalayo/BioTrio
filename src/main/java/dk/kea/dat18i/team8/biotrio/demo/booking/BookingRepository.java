
package dk.kea.dat18i.team8.biotrio.demo.booking;


import dk.kea.dat18i.team8.biotrio.demo.Seat.Seat;
import dk.kea.dat18i.team8.biotrio.demo.Seat.SeatRepository;
import dk.kea.dat18i.team8.biotrio.demo.screenings.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.PreparedStatementCreator;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private SeatRepository seatRepo;
    @Autowired
    private ScreeningRepository screeningRepo;



    public Booking findBooking(int booking_id) {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking WHERE booking_id = " + booking_id);

        Booking booking = new Booking();

        while (rs.next()) {

            Seat seat=new Seat();

            seat.setRowNo( seat.getRowNo() );
            seat.setSeatNo( seat.getSeatNo() );

            booking.setSeat( seat );

            booking.setBooking_id(rs.getInt("booking_id"));
            booking.getSeat().setRowNo(rs.getInt("row_no"));
            booking.getSeat().setSeatNo(rs.getInt("seat_no"));
            booking.setPhone_no(rs.getString("phone_no"));
            booking.setScreening(screeningRepo.findScreening(rs.getInt("screening_id")));

        }
        return booking;
    }


    public List<Booking> findAllBookings() {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking");

        List<Booking> bookingList = new ArrayList<>();

        while (rs.next()) {
            Booking booking = new Booking();
            Seat seat=new Seat();

            seat.setRowNo( seat.getRowNo() );
            seat.setSeatNo( seat.getSeatNo() );

            booking.setSeat( seat );

            booking.setBooking_id(rs.getInt("booking_id"));
            booking.getSeat().setRowNo(rs.getInt("row_no"));
            booking.getSeat().setSeatNo(rs.getInt("seat_no"));
            booking.setPhone_no(rs.getString("phone_no"));
            booking.setScreening(screeningRepo.findScreening(rs.getInt("screening_id")));
            bookingList.add(booking);

        }
        return bookingList;

    }


    public Booking insertBooking(Booking booking) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("INSERT INTO booking VALUES (null,?,?,?,?)", new String[]{"booking_id"});

                ps.setInt(1, booking.getSeat().getRowNo());
                ps.setInt(2, booking.getSeat().getSeatNo());
                ps.setString(3, booking.getPhone_no());
                ps.setInt(4, booking.getScreening().getScreening_id());

                return ps;
            }
        };
        jdbc.update(psc);
        return booking;
    }

    public void deleteBooking(int booking_id) {

        jdbc.update("DELETE FROM booking WHERE booking_id = " + booking_id);
    }

    public void updateBooking(Booking booking) {

        jdbc.update("UPDATE bookings SET " +
                "booking_id='" + booking.getBooking_id() + "', " +
                "seat_row='" + booking.getSeat().getRowNo() + "', "+
                "seat_no='" + booking.getSeat().getSeatNo() + "', " +
                "phone_no'" + booking.getPhone_no() + "', " +
                "screening_id='" + booking.getScreening().getScreening_id() + "' " +
                "WHERE booking_id=" + booking.getBooking_id());
    }

    public List <Booking> findBookingsbyPhoneNo(String phone_no){

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM booking WHERE phone_no = " + phone_no);


        List<Booking> findBookinByPhone = new ArrayList<>();

        while (rs.next()) {
            Booking booking = new Booking();
            Seat seat=new Seat();
            seat.setRowNo( seat.getRowNo() );
            seat.setSeatNo( seat.getSeatNo() );
            booking.setSeat( seat );
            booking.setBooking_id(rs.getInt("booking_id"));
            booking.getSeat().setRowNo(rs.getInt("row_no"));
            booking.getSeat().setSeatNo(rs.getInt("seat_no"));
            booking.setPhone_no(rs.getString("phone_no"));
            booking.setScreening(screeningRepo.findScreening(rs.getInt("screening_id")));
            findBookinByPhone.add(booking);
        }

        return findBookinByPhone;

    }
    public void cancelBooking(int screening_id) {

        jdbc.update("DELETE FROM booking WHERE screening_id = " + screening_id);
    }

}


