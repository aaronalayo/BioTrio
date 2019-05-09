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
public class ScreeningRepository {

    @Autowired
    private JdbcTemplate jdbc;





    public List<Screening> findAllScreenings(){

        SqlRowSet rs = jdbc.queryForRowSet( "SELECT * FROM screening" );

        List<Screening> screeningList = new ArrayList<>();

        while (rs.next()) {
            Screening screening = new Screening();
            screening.setScreening_id(rs.getInt(  "screening_id"));
            screening.setScreening_date( rs.getDate("screening_date").toLocalDate());
            screening.setScreening_starts( rs.getTime( "screening_starts" ).toLocalTime() );

            screeningList.add( screening );




        }
        return screeningList;

    }

}
