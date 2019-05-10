package dk.kea.dat18i.team8.biotrio.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



@Repository
public class TheaterRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Theater> findAllTheaters(){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM theater");
        List<Theater> theaterList = new ArrayList<>();
        while(rs.next()) {
            Theater theater = new Theater();
            theater.setTheater_id(rs.getInt("theater_id"));
            theater.setTheater_name(rs.getString("theater_name"));
            theater.setNumber_of_seats(rs.getInt("number_of_seats"));
            theater.setTheater_format(rs.getString("theater_format"));

            theaterList.add(theater);
        }
            return theaterList;



    }

    public Theater insert(Theater theater) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO theater VALUES(null , ?,?,?)", new String[]{"theater_id"});
                ps.setString(1, theater.getTheater_name());
                ps.setInt(2, theater.getNumber_of_seats());
                ps.setString(3, theater.getTheater_format());
                return ps;
            }
        };


        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        theater.setTheater_id(id.getKey().intValue());
        return theater;
    }

    public void delete(int id) {

        jdbc.update("DELETE FROM theater WHERE theater_id = " + id);
    }

    public void edit(Theater theater){

        jdbc.update("UPDATE theater SET" +
                "theater_name= '" + theater.getTheater_name() + "', " +
                "number_of_seats= '" + theater.getNumber_of_seats() + "', " +
                "theater_format= '"  + theater.getTheater_format()  + "', " +
                "WHERE theater_id=" + theater.getTheater_id());

    }
    public Theater findTheater(int theater_id) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM theater WHERE theater_id = " + theater_id);
        Theater theater = new Theater();
        while (rs.next()) {
            theater.setTheater_id(rs.getInt("theater_id"));
            theater.setTheater_name(rs.getString("theater_name"));
            theater.setNumber_of_seats(rs.getInt("number_of_seats"));
            theater.setTheater_format(rs.getString("theater_format"));
        }
        return theater;
    }
    }

