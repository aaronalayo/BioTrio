package dk.kea.dat18i.team8.biotrio.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Movie showMovie(int id){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie WHERE id = "+id);
        Movie movie = new Movie();
        while (rs.next()){
            movie.setId(rs.getInt("movie_id"));
            movie.setTitle(rs.getString("title"));
            movie.setDirector(rs.getString("director"));
            movie.setDuration(rs.getInt("duration"));
            movie.setGenre(rs.getString("genre"));
            movie.setFormat(rs.getString("movie_format"));
            movie.setStartDate(rs.getDate("start_date").toLocalDate());
            movie.setEndDate(rs.getDate("end_date").toLocalDate());
            movie.setTheater_id(rs.getInt("theater_id"));
        }
        return movie;
    }

    public List<Movie> showallMovies(){
        SqlRowSet rs =jdbc.queryForRowSet("SELECT * FROM movie");
        List<Movie> movieList = new ArrayList<>();
        while (rs.next()){
            Movie movie = new Movie();
            movie.setId(rs.getInt("movie_id"));
            movie.setTitle(rs.getString("title"));
            movie.setDirector(rs.getString("director"));
            movie.setDuration(rs.getInt("duration"));
            movie.setGenre(rs.getString("genre"));
            movie.setFormat(rs.getString("movie_format"));
            movie.setStartDate(rs.getDate("start_date").toLocalDate());
            movie.setEndDate(rs.getDate("end_date").toLocalDate());
            movie.setTheater_id(rs.getInt("theater_id"));
            movieList.add(movie);
        }
        return movieList;
    }

    public Movie insert(Movie movie){
        PreparedStatementCreator psc =new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO movie VALUES(null,?,?,?,?,?,?,?,?)", new String[]{"movie_id"});
                ps.setString(1,movie.getTitle());
                ps.setString(2,movie.getDirector());
                ps.setString(3,movie.getGenre());
                ps.setInt(4,movie.getDuration());
                ps.setString(5,movie.getFormat());
                ps.setDate(6,java.sql.Date.valueOf(movie.getStartDate()));
                ps.setDate(7,java.sql.Date.valueOf(movie.getEndDate()));
                ps.setInt(8,movie.getTheater_id());
                return ps;
            }
        };
        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        movie.setId(id.getKey().intValue());
        return movie;
    }

    public void edit(Movie movie){
        jdbc.update("update movie set" +
                "title='"+movie.getTitle()+"',"+
                "director='"+movie.getDirector() +"',"+
                "genre='"+movie.getGenre()+"',"+
                "duration='"+movie.getDuration()+"',"+
                "movie_format='"+movie.getFormat()+"',"+
                "theater_id='"+movie.getTheater_id()+"',"+
                "WHERE movie_id="+movie.getId());
    }
    public void delete(int id) {
        jdbc.update("DELETE FROM movie WHERE id = "+id);
    }
}
