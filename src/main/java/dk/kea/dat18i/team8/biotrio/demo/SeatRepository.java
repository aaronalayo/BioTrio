package dk.kea.dat18i.team8.biotrio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeatRepository {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private ScreeningRepository screeningRepo;
    @Autowired
    private BookingRepository bookingRepo;

    public List<Seat> checkSeats(Screening screening) {
        //checks the theater of the screening
        Theater theater = screening.getMovie().getTheater();
        List<Seat> theaterSeats = new ArrayList<>();
        for (int i=1;i<=theater.getNumber_of_rows();i++){
            for (int j=1;j<=theater.getSeats_per_row();j++){
                theaterSeats.add(new Seat(i,j));
            }
        }
        for (Seat theaterSeat : theaterSeats) {
            for (Seat bookedSeat:test(screening)) {
                if (theaterSeat.getRowNo() == bookedSeat.getRowNo() && theaterSeat.getSeatNo() == bookedSeat.getSeatNo()) {
                    theaterSeat.setIsBooked(true);
                }
            }

        }
        return theaterSeats;
    }
    public List<Seat> test (Screening screening) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT row_no,seat_no from booking where screening_id=" + screening.getScreening_id());
        List<Seat> bookedSeats=new ArrayList<>();
        while (rs.next()) {
            bookedSeats.add(new Seat(rs.getInt("row_no"), rs.getInt("seat_no")));
        }
        return bookedSeats;
    }



}

