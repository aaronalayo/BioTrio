package dk.kea.dat18i.team8.biotrio.demo.Seat;

import dk.kea.dat18i.team8.biotrio.demo.screenings.Screening;
import dk.kea.dat18i.team8.biotrio.demo.screenings.ScreeningRepository;
import dk.kea.dat18i.team8.biotrio.demo.theater.Theater;
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

    /**finds booked seats for a specific screening
     *
     * @param screening parameter of type Screening that represents the screening
     *                  for which booked seats are sought
     * @return {@link List} of {@link Seat} that are booked for the screening
     */
     public List<Seat> findBookedSeats (Screening screening) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT row_no,seat_no from booking where screening_id=" + screening.getScreening_id());
        List<Seat> bookedSeats=new ArrayList<>();
        while (rs.next()) {
            bookedSeats.add(new Seat(rs.getInt("row_no"), rs.getInt("seat_no")));
        }
        return bookedSeats;
    }

    /**
     * checks the availability of the seats for a specific screening
     *
     * @param screening parameter of type Screening that represents the screening
     *      *         for which seats availability is set
     * @return
     */
    public List<Seat> checkSeats(Screening screening) {
        //checks the theater of the screening
        Theater theater = screening.getTheater();

        //adds all the seats that the theater has to a list of seats,by default all set to isbooked=false
        List<Seat> theaterSeats = new ArrayList<>();
         for (int i=1;i<=theater.getNumber_of_rows();i++){
            for (int j=1;j<=theater.getSeats_per_row();j++){
               theaterSeats.add(new Seat(i,j));
            }
        }
        /*goes through all theater seats and checks if it matches to a booked seat,
        if yes sets isbooked to true
         */
        for (Seat theaterSeat : theaterSeats) {
            for (Seat bookedSeat:findBookedSeats(screening)) {
                if (theaterSeat.getRowNo() == bookedSeat.getRowNo() && theaterSeat.getSeatNo() == bookedSeat.getSeatNo()) {
                    theaterSeat.setIsBooked(true);
                }
            }
        }
        //returns the updated list with available and not available seats for the screening
        return theaterSeats;
    }



}
