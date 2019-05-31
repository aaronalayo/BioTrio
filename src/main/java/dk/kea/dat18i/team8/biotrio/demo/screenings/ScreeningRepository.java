package dk.kea.dat18i.team8.biotrio.demo.screenings;

import dk.kea.dat18i.team8.biotrio.demo.movies.MovieRepository;
import dk.kea.dat18i.team8.biotrio.demo.theater.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.PreparedStatementCreator;


import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


@Repository
public class ScreeningRepository {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    private TheaterRepository theaterRepo;

    /**
     * finds a screening from the database
     *
     * @param screening_id parameter with integer value that represents the id
     *                     of the screening to be found
     * @return updated {@link Screening} object
     */
    public Screening findScreening(int screening_id) {

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening WHERE screening_id = " + screening_id );
        Screening screening = new Screening();
        while (rs.next()) {
            screening.setScreening_id( rs.getInt( "screening_id" ) );
            screening.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            screening.setMovie( movieRepo.showMovie( rs.getInt( "movie_id" ) ) );
            screening.setTheater( theaterRepo.findTheater( rs.getInt( "theater_id" ) ) );

        }
        return screening;
    }

    /**
     * finds all screenings from the database
     *
     * @return updated {@link List} of all {@link Screening} objects
     */
    public List<Screening> findAllScreenings() {

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening" );

        List<Screening> screeningList = new ArrayList<>();

        while (rs.next()) {
            Screening screening = new Screening();

            screening.setScreening_id( rs.getInt( "screening_id" ) );
            screening.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            screening.setMovie( movieRepo.showMovie( rs.getInt( "movie_id" ) ) );
            screening.setTheater( theaterRepo.findTheater( rs.getInt( "theater_id" ) ) );

            screeningList.add( screening );
        }
        return screeningList;

    }

    /**
     *inserts screening record into the database
     *
     * @param screening contains the screening details to be added
     * @return updated screening that also has a generated id
     */
    public Screening insertScreening(Screening screening) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement( "INSERT INTO screening (showing, movie_id, theater_id)VALUES (?,?,?)" );

                ps.setTimestamp( 1, Timestamp.valueOf( screening.getShowing() ) );
                ps.setInt( 2, screening.getMovie().getId() );
                ps.setInt( 3, screening.getTheater().getTheater_id() );

                    return ps;
            }
    };
        jdbc.update( psc );
        return screening;
    }

    /**
     * deletes a screening from the database
     *
     * @param screening_id a parameter with integer value that represents the id
     *                     of the screening to be deleted
     */
    public void deleteScreening(int screening_id) {

        jdbc.execute( "DELETE FROM screening WHERE screening_id = " + screening_id );
    }

    //This method is used to update a selected screening in the database.
    //It returns the edited screening
    public Screening update(Screening screening) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("UPDATE screening SET showing = ?, movie_id = ?, theater_id = ? WHERE screening_id =  " + screening.getScreening_id(), new String[]{"screening_id"});

                ps.setTimestamp( 1, Timestamp.valueOf( screening.getShowing() ) );
                ps.setInt( 2, (screening.getMovie().getId()) );
                ps.setInt( 3, (screening.getTheater().getTheater_id()) );

                return ps;
            }
        };

        jdbc.update( psc );
        return screening;
    }

    //This method is used to find the screenings related to a selected movie.
    //It returns a the list of screenings for that movie in all the theaters.
    public List<Screening> findScreeningsWithMovie(int movie_id) {

    /**
     * finds screenings for a specific movie
     *
     * @param movie_id parameter with integer value that contains the id
     *                 of the movie which screenings should be found
     * @return {@link List} of {@link Screening} only for one selected movie
     */
    public List<Screening> findScreeningsWithMovie(int movie_id){

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening WHERE movie_id = " + movie_id);

        List<Screening> screeningList = new ArrayList<>();

        while (rs.next()) {
            Screening screening = new Screening();

            screening.setScreening_id( rs.getInt( "screening_id" ) );
            screening.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            screening.setTheater( theaterRepo.findTheater( rs.getInt( "theater_id" ) ) );

            screeningList.add( screening );

        }
        return screeningList;
    }

    /**
     * finds all screenings at a specific date
     *
     * @param showing parameter with String value that contains a date
     * @return {@link List} of {@link Screening} that has that specific date
     */
    public List<Screening> findScreeningsByDate(String showing) {

        //new variable is created that takes the parsed into LocalDateTime showing's value
        LocalDateTime dateTime = LocalDate.parse(showing).atStartOfDay();

        LocalDateTime dateTime = LocalDate.parse( showing ).atStartOfDay();

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening where DATE(showing) = DATE ('" + dateTime + "' )" );
        List<Screening> screeningByDate = new ArrayList<>();

        while (rs.next()) {
            Screening screeningDate = new Screening();

            screeningDate.setScreening_id( rs.getInt( "screening_id" ) );
            screeningDate.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            screeningDate.setMovie( movieRepo.showMovie( rs.getInt( "movie_id" ) ) );
            screeningDate.setTheater( theaterRepo.findTheater( rs.getInt( "theater_id" ) ) );

            screeningByDate.add( screeningDate );
        }
        return screeningByDate;
    }


}
