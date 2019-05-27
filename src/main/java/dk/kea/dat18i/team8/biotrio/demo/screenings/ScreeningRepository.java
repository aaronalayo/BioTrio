package dk.kea.dat18i.team8.biotrio.demo.screenings;

<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
import dk.kea.dat18i.team8.biotrio.demo.Movie;
import dk.kea.dat18i.team8.biotrio.demo.MovieRepository;
import dk.kea.dat18i.team8.biotrio.demo.TheaterRepository;
=======
import dk.kea.dat18i.team8.biotrio.demo.movies.MovieRepository;
import dk.kea.dat18i.team8.biotrio.demo.theater.TheaterRepository;
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
import org.springframework.web.bind.annotation.ModelAttribute;
=======

>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java


import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;



<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
=======

>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java
@Repository
public class ScreeningRepository {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    private TheaterRepository theaterRepo;

    public Screening findScreening(int screening_id) {

<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM screening WHERE screening_id = " + screening_id);
        Screening screening = new Screening();
        while (rs.next()) {

            screening.setScreening_id(rs.getInt("screening_id"));
            screening.setShowing(rs.getTimestamp("showing").toLocalDateTime());
            screening.setMovie(movieRepo.showMovie(rs.getInt("movie_id")));
            screening.setTheater(theaterRepo.findTheater(rs.getInt("theater_id")));
=======
        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening WHERE screening_id = " + screening_id );
        Screening screening = new Screening();
        while (rs.next()) {

            screening.setScreening_id( rs.getInt( "screening_id" ) );
            screening.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            screening.setMovie( movieRepo.showMovie( rs.getInt( "movie_id" ) ));
            screening.setTheater( theaterRepo.findTheater( rs.getInt( "theater_id" ) ));
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java

        }
        return screening;
    }


    public List<Screening> findAllScreenings() {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM screening");

        List<Screening> screeningList = new ArrayList<>();

        while (rs.next()) {
            Screening screening = new Screening();


<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
            screening.setScreening_id(rs.getInt("screening_id"));
            screening.setShowing(rs.getTimestamp("showing").toLocalDateTime());
            screening.setMovie(movieRepo.showMovie(rs.getInt("movie_id")));
            screening.setTheater(theaterRepo.findTheater(rs.getInt("theater_id")));


            screeningList.add(screening);
=======
            screening.setScreening_id( rs.getInt( "screening_id" ) );
            screening.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            screening.setMovie(movieRepo.showMovie(rs.getInt("movie_id")));
            screening.setTheater( theaterRepo.findTheater(rs.getInt( "theater_id" )) );


            screeningList.add( screening );
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java


        }
        return screeningList;

    }


    public Screening insertScreening(Screening screening) {


        PreparedStatementCreator psc = new PreparedStatementCreator() {


            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {


                PreparedStatement ps = connection.prepareStatement("INSERT INTO biotrio.screening (showing, movie_id, theater_id)VALUES (?,?,?)");

<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
                ps.setTimestamp(1, Timestamp.valueOf(screening.getShowing()));
                ps.setInt(2, screening.getMovie().getId());
                ps.setInt(3, screening.getTheater().getTheater_id());
=======
                PreparedStatement ps = connection.prepareStatement( "INSERT INTO screening (showing, movie_id, theater_id)VALUES (?,?,?)");

                ps.setTimestamp( 1,Timestamp.valueOf(screening.getShowing()));
                ps.setInt( 2, screening.getMovie().getId());
                ps.setInt( 3,screening.getTheater().getTheater_id() );
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java

                return ps;
            }
        };

<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
        jdbc.update(psc);
=======
        jdbc.update( psc );
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java


        return screening;
    }

    public void deleteScreening(int screening_id) {

        jdbc.execute("DELETE FROM screening WHERE screening_id = " + screening_id);
    }


    public Screening update(Screening screening) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {


<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
                PreparedStatement ps = connection.prepareStatement("UPDATE biotrio.screening SET showing = ?, movie_id = ?, theater_id = ? WHERE screening_id =  " + screening.getScreening_id(), new String[]{"screening_id"});
=======
                PreparedStatement ps = connection.prepareStatement("UPDATE screening SET showing = ?, movie_id = ?, theater_id = ? WHERE screening_id =  " + screening.getScreening_id(), new String[]{"screening_id"});

                ps.setTimestamp( 1, Timestamp.valueOf( screening.getShowing() ) );
                ps.setInt( 2,(screening.getMovie().getId()) );
                ps.setInt( 3,(screening.getTheater().getTheater_id()) );
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java

                ps.setTimestamp(1, Timestamp.valueOf(screening.getShowing()));
                ps.setInt(2, (screening.getMovie().getId()));
                ps.setInt(3, (screening.getTheater().getTheater_id()));


                return ps;
            }

        };

        jdbc.update(psc);


        return screening;
    }


<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
    public List<Screening> findScreeningsWithMovie(int movie_id) {


        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM screening WHERE movie_id = " + movie_id);
=======
    public List<Screening> findScreeningsWithMovie(int movie_id){


       SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening WHERE movie_id = " + movie_id);
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java

        List<Screening> screeningList = new ArrayList<>();

        while (rs.next()) {
            Screening screening = new Screening();


<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
            screening.setScreening_id(rs.getInt("screening_id"));
            screening.setShowing(rs.getTimestamp("showing").toLocalDateTime());
            //screening.setMovie(movieRepo.showMovie(rs.getInt("movie_id")));
            screening.setTheater(theaterRepo.findTheater(rs.getInt("theater_id")));

            screeningList.add(screening);

            // String sql = "SELECT * FROM screening WHERE movie_id =" + movie_id;


            //List<Screening> screeningList = jdbc.query(sql, new BeanPropertyRowMapper<>(Screening.class));
=======
            screening.setScreening_id( rs.getInt( "screening_id" ) );
            screening.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            screening.setTheater( theaterRepo.findTheater( rs.getInt( "theater_id" ) ) );

            screeningList.add( screening );
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java

        }

        return screeningList;
<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
    }
    public List<Screening> findScreeningsByDate(String showing) {



        LocalDateTime dateTime = LocalDate.parse(showing).atStartOfDay();
        System.out.println(dateTime);
=======


    }

    public List<Screening> findScreeningsByDate(String showing) {

        LocalDateTime dateTime = LocalDate.parse(showing).atStartOfDay();
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening where DATE(showing) = DATE ('"+dateTime+"' )");
        List<Screening> screeningByDate = new ArrayList<>();

<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
        while (rs.next()) {

            Screening screeningDate = new Screening();

=======
            while(rs.next()){
            Screening screeningDate = new Screening();


>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java
            screeningDate.setScreening_id( rs.getInt( "screening_id" ) );
            screeningDate.setShowing( rs.getTimestamp( "showing" ).toLocalDateTime() );
            screeningDate.setMovie(movieRepo.showMovie(rs.getInt("movie_id")));
            screeningDate.setTheater( theaterRepo.findTheater( rs.getInt( "theater_id" ) ) );

            screeningByDate.add( screeningDate );


        }
<<<<<<< HEAD:src/main/java/dk/kea/dat18i/team8/biotrio/demo/ScreeningRepository.java
        return screeningByDate;

    }
}
=======

        return screeningByDate;

    }

}
>>>>>>> master:src/main/java/dk/kea/dat18i/team8/biotrio/demo/screenings/ScreeningRepository.java
