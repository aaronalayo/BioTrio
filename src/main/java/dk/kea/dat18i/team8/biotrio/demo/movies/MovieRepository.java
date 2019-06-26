package dk.kea.dat18i.team8.biotrio.demo.movies;

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


    //method to avoid repetition, sets a movie
    public void setMovie(Movie movie, SqlRowSet rs) {
        movie.setId(rs.getInt("movie_id"));
        movie.setTitle(rs.getString("title"));
        movie.setDirector(rs.getString("director"));
        movie.setDuration(rs.getInt("duration"));
        movie.setGenre(rs.getString("genre"));
        movie.setPlot(rs.getString("plot"));
        movie.setFormat(rs.getString("format"));
        movie.setSound(rs.getString("sound"));
        movie.setImage(rs.getString("image"));
    }


    /**
     * finds a movie from the database
     *
     * @param id parameter with integer value that represents
     *           the id of the movie to be found
     * @return updated {@link Movie} object
     */
    public Movie showMovie(int id) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie WHERE movie_id = " + id);
        Movie movie = new Movie();
        while (rs.next()) {
            setMovie(movie, rs);
        }
        return movie;
    }

    /**
     * finds all movies from the database
     *
     * @return updated {@link List} of all {@link Movie} objects
     */
    public List<Movie> showAllMovies() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie");
        List<Movie> movieList = new ArrayList<>();
        while (rs.next()) {
            Movie movie = new Movie();
            setMovie(movie, rs);
            movieList.add(movie);
        }
        return movieList;
    }

    /**
     *inserts movie record into the database
     *
     * @param movie contains the movie details to be added
     * @return updated movie that also has a generated id
     */
    public Movie insert(Movie movie){
        PreparedStatementCreator psc =new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement
                        ("INSERT INTO movie(title,genre,duration,director,plot,format, sound,image) VALUES(?,?,?,?,?,?,?,?)");
                ps.setString(1,movie.getTitle());
                ps.setString(2,movie.getGenre());
                ps.setInt(3,movie.getDuration());
                ps.setString(4,movie.getDirector());
                ps.setString(5,movie.getPlot());
                ps.setString(6,movie.getFormat());
                ps.setString(7, movie.getSound());
                ps.setString(8,movie.getImage());

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

                PreparedStatement ps = connection.prepareStatement("UPDATE movie " +
                        "SET title= ?,genre = ?, duration=?, director=?, plot=?, format=?, sound = ?, image=? " +
                        "WHERE movie_id=  " + movie.getId());
                ps.setString(1,movie.getTitle());
                ps.setString(2,movie.getGenre());
                ps.setInt(3,movie.getDuration());
                ps.setString(4,movie.getDirector());
                ps.setString(5,movie.getPlot());
                ps.setString(6,movie.getFormat());
                ps.setString(7,movie.getSound());
                ps.setString(8,movie.getImage());

                return ps;
            }
        };

        jdbc.update(psc);
        return movie;
    }

    /**
     * deletes a movie from the database
     *
     * @param id a parameter with integer value that represents the id
     *           of the movie to be found and deleted
     */
    public void delete(int id) {
        jdbc.update("DELETE FROM movie WHERE movie_id = " + id);
    }
}