package dk.kea.dat18i.team8.biotrio.demo.movies;

import dk.kea.dat18i.team8.biotrio.demo.theater.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void setMovie(Movie movie,SqlRowSet rs){
        movie.setId(rs.getInt("movie_id"));
        movie.setTitle(rs.getString("title"));
        movie.setDirector(rs.getString("director"));
        movie.setPlot(rs.getString("plot"));
        movie.setDuration(rs.getInt("duration"));
        movie.setGenre(rs.getString("genre"));
        movie.setFormat(rs.getString("movie_format"));

    }

    public Movie showMovie(int id){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie WHERE movie_id = "+id);
        Movie movie = new Movie();
        while (rs.next()){
            setMovie(movie,rs);
        }
        return movie;
    }

    public List<Movie> showAllMovies(){
        SqlRowSet rs =jdbc.queryForRowSet("SELECT * FROM movie");
        List<Movie> movieList = new ArrayList<>();
        while (rs.next()){
            Movie movie = new Movie();
            setMovie(movie,rs);
            movieList.add(movie);
        }
        return movieList;
    }

    public Movie insert(Movie movie){
        PreparedStatementCreator psc =new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement
                        ("INSERT INTO movie(title,director,plot,genre,duration,format) VALUES(?,?,?,?,?,?)");
                ps.setString(1,movie.getTitle());
                ps.setString(2,movie.getDirector());
                ps.setString(3,movie.getPlot());
                ps.setString(4,movie.getGenre());
                ps.setInt(5,movie.getDuration());
                ps.setString(6,movie.getFormat());

                return ps;
            }
        };
        jdbc.update(psc);
        return movie;
    }

    public Movie update(Movie movie) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {


                PreparedStatement ps = connection.prepareStatement("UPDATE biotrio.movie " +
                        "SET title= ?, director = ?,plot=?,genre=?,duration=?,movie_format=? " +
                        "WHERE movie_id=  " + movie.getId());
                ps.setString(1,movie.getTitle());
                ps.setString(2,movie.getDirector());
                ps.setString(3,movie.getPlot());
                ps.setString(4,movie.getGenre());
                ps.setInt(5,movie.getDuration());
                ps.setString(6,movie.getFormat());

                return ps;
            }
        };

        jdbc.update(psc);
        return movie;
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM movie WHERE movie_id = "+id);
    }
}

