package dk.kea.dat18i.team8.biotrio.demo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Screening {

    int screening_id;
    LocalDate screening_date;
    LocalTime screening_starts;
    int movied_id;

    public Screening (){
    }

    public Screening(int screening_id, LocalDate screening_date, LocalTime screening_starts, int movie_id) {
        this.screening_id = screening_id;
        this.screening_date = screening_date;
        this.screening_starts = screening_starts;
        this.movied_id = movied_id;
    }

    public int getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(int screening_id) {
        this.screening_id = screening_id;
    }

    public LocalDate getScreening_date() {
        return screening_date;
    }

    public void setScreening_date(LocalDate screening_date) {
        this.screening_date = screening_date;
    }

    public LocalTime getScreening_starts() {
        return screening_starts;
    }

    public void setScreening_starts(LocalTime screening_starts) {
        this.screening_starts = screening_starts;
    }

    public int getMovied_id() {
        return movied_id;
    }

    public void setMovied_id(int movied_id) {
        this.movied_id = movied_id;
    }
}
