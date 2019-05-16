package dk.kea.dat18i.team8.biotrio.demo.screenings;

import dk.kea.dat18i.team8.biotrio.demo.movies.Movie;
import dk.kea.dat18i.team8.biotrio.demo.movies.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.PreparedStatementCreator;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;


@Repository
public class ScreeningRepository {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private MovieRepository movieRepo;


    public Screening findScreening(int screening_id) {

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening WHERE screening_id = " + screening_id );
        Screening screening = new Screening();
        while (rs.next()) {

            screening.setScreening_id( rs.getInt( "screening_id" ) );
            screening.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
//            screening.setScreening_date( rs.getDate( "screening_date" ).toLocalDate() );
//            screening.setScreening_starts( rs.getTime( "screening_starts" ).toLocalTime() );

        }
        return screening;
    }


    public List<Screening> findAllScreenings() {

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening" );

        List<Screening> screeningList = new ArrayList<>();

        while (rs.next()) {
            Screening screening = new Screening();


            screening.setScreening_id( rs.getInt( "screening_id" ) );
            screening.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
//            screening.setScreening_date( rs.getDate( "screening_date" ).toLocalDate());
//            screening.setScreening_starts( rs.getTime( "screening_starts" ).toLocalTime() );
            screening.setMovie(movieRepo.showMovie(rs.getInt("movie_id")));


            screeningList.add( screening );


        }
        return screeningList;

    }


    public Screening insertScreening(Screening screening) {


        PreparedStatementCreator psc = new PreparedStatementCreator() {


            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {



                PreparedStatement ps = connection.prepareStatement( "INSERT INTO biotrio.screening (screening_date, screening_starts, movie_id)VALUES (?,?,?)");

                //Calendar gmt = Calendar.getInstance( TimeZone.getTimeZone("GMT"));
                ps.setTimestamp( 1,Timestamp.valueOf(screening.getShowing()));
//                ps.setDate( 1, java.sql.Date.valueOf( screening.getScreening_date()));
//                ps.setTime( 2, java.sql.Time.valueOf( screening.getScreening_starts()));
                ps.setInt( 3, screening.getMovie().getId());



                return ps;
            }
        };


        jdbc.update( psc );


        return screening;
    }



    public void deleteScreening(int screening_id) {

        jdbc.execute( "DELETE FROM screening WHERE screening_id = " + screening_id );
    }


    public Screening update(Screening screening) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {


                PreparedStatement ps = connection.prepareStatement("UPDATE biotrio.screening SET screening_date= ?, screening_starts = ? WHERE screening_id=  " + screening.getScreening_id(), new String[]{"screening_id"});

                //Calendar gmt = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
                ps.setTimestamp( 1, Timestamp.valueOf( screening.getShowing() ) );
//                ps.setDate(1,java.sql.Date.valueOf(screening.getScreening_date()));
//                ps.setTime(2,java.sql.Time.valueOf(screening.getScreening_starts()));

                return ps;
            }

    };

        jdbc.update(psc);


        return screening;
    }

//    public List<Movie> findScreeningMovie() {
//
//        List<Movie> movieList = new ArrayList<>();
//        SqlRowSet rs = jdbc.queryForRowSet( "SELECT screening.screening_id, movie.title FROM screening JOIN movie ON screening.movie_id = movie.movie_id");
//
//               Movie movie = new Movie();
//
//
//                while (rs.next()) {
//
//
//                    movie.setTitle(rs.getString( "title" ));
//        }
//
//        movieList.add( movie);
//
//        return movieList;
//    }

}
