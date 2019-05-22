package dk.kea.dat18i.team8.biotrio.demo.screenings;

import dk.kea.dat18i.team8.biotrio.demo.movies.Movie;
import dk.kea.dat18i.team8.biotrio.demo.movies.MovieRepository;
import dk.kea.dat18i.team8.biotrio.demo.theater.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
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

    public Screening findScreening(int screening_id) {

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening WHERE screening_id = " + screening_id );
        Screening screening = new Screening();
        while (rs.next()) {

            screening.setScreening_id( rs.getInt( "screening_id" ) );
            screening.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            screening.setMovie( movieRepo.showMovie( rs.getInt( "movie_id" ) ));
            screening.setTheater( theaterRepo.findTheater( rs.getInt( "theater_id" ) ));

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
            screening.setMovie(movieRepo.showMovie(rs.getInt("movie_id")));
            screening.setTheater( theaterRepo.findTheater(rs.getInt( "theater_id" )) );


            screeningList.add( screening );


        }
        return screeningList;

    }


    public Screening insertScreening(Screening screening) {


        PreparedStatementCreator psc = new PreparedStatementCreator() {


            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {



                PreparedStatement ps = connection.prepareStatement( "INSERT INTO biotrio.screening (showing, movie_id, theater_id)VALUES (?,?,?)");

                ps.setTimestamp( 1,Timestamp.valueOf(screening.getShowing()));
                ps.setInt( 2, screening.getMovie().getId());
                ps.setInt( 3,screening.getTheater().getTheater_id() );

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


                PreparedStatement ps = connection.prepareStatement("UPDATE biotrio.screening SET showing = ?, movie_id = ?, theater_id = ? WHERE screening_id =  " + screening.getScreening_id(), new String[]{"screening_id"});

                ps.setTimestamp( 1, Timestamp.valueOf( screening.getShowing() ) );
                ps.setInt( 2,(screening.getMovie().getId()) );
                ps.setInt( 3,(screening.getTheater().getTheater_id()) );



                return ps;
            }

    };

        jdbc.update(psc);


        return screening;
    }


    public List<Screening> findScreeningsWithMovie(int movie_id){


       SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening WHERE movie_id = " + movie_id);

        List<Screening> screeningList = new ArrayList<>();

        while (rs.next()) {
            Screening screening = new Screening();


            screening.setScreening_id( rs.getInt( "screening_id" ) );
            screening.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            //screening.setMovie(movieRepo.showMovie(rs.getInt("movie_id")));
            screening.setTheater( theaterRepo.findTheater( rs.getInt( "theater_id" ) ) );

            screeningList.add( screening );

            // String sql = "SELECT * FROM screening WHERE movie_id =" + movie_id;


            //List<Screening> screeningList = jdbc.query(sql, new BeanPropertyRowMapper<>(Screening.class));

        }

        return screeningList;


    }

    public List<Screening> findScreeningsByDate(String showing) {


//       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
//       LocalDateTime localDateTime = LocalDateTime.from(showing);
//
//        Timestamp date = Timestamp.valueOf(showing);

        System.out.println(showing);
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        String date = DATE_FORMAT.format(showing);


        System.out.println(date);


        Screening screeningDate = new Screening();
        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening where DATE(showing) = DATE ('"+date+"')");

        List<Screening> screeningByDate = new ArrayList<>();

        while (rs.next()) {



            screeningDate.setScreening_id( rs.getInt( "screening_id" ) );
            screeningDate.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            screeningDate.setMovie(movieRepo.showMovie(rs.getInt("movie_id")));
            screeningDate.setTheater( theaterRepo.findTheater( rs.getInt( "theater_id" ) ) );

            screeningByDate.add( screeningDate );

            System.out.println(screeningDate);
        }
        return screeningByDate;

    }


}
