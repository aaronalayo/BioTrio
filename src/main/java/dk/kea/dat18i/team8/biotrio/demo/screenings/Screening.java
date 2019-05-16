package dk.kea.dat18i.team8.biotrio.demo.screenings;

import dk.kea.dat18i.team8.biotrio.demo.movies.Movie;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Screening {

    private int screening_id;
    private LocalDateTime showing;
    private Movie movie;

    public Screening(int screening_id, LocalDateTime showing, Movie movie) {
        this.screening_id = screening_id;
        this.showing = showing;
        this.movie = movie;
    }



//    public Screening(int screening_id, LocalDate screening_date, Movie movie) {
//        this.screening_id = screening_id;
//        this.screening_date = screening_date;
//        this.movie = movie;
//    }

    public Screening (){
    }

    public Screening(int screening_id, LocalDate screening_date, LocalTime screening_starts, Movie movie) {
        this.screening_id = screening_id;
        this.screening_date = screening_date;
        this.screening_starts = screening_starts;
        this.movie = movie;
    }

    public int getScreening_id() {

        return screening_id;
    }

    public void setScreening_id(int screening_id) {

        this.screening_id = screening_id;
    }


    public Movie getMovie() { return movie;
    }

    public void setMovie(Movie movie) {

        this.movie= movie;

    }

    public LocalDateTime getShowing() {
        return showing;
    }

    public void setShowing(LocalDateTime showing) {
        this.showing = showing;
    }


}
