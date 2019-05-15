package dk.kea.dat18i.team8.biotrio.demo.screenings;



import dk.kea.dat18i.team8.biotrio.demo.movies.Movie;

import java.time.LocalDate;
import java.time.LocalTime;

public class Screening {

    private int screening_id;
    private LocalDate screening_date;
    private LocalTime screening_starts;
    private Movie movie;

    public Screening(int screening_id, LocalDate screening_date, Movie movie) {
        this.screening_id = screening_id;
        this.screening_date = screening_date;
        this.movie = movie;
    }



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

    public LocalDate getScreening_date(){
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


    public Movie getMovie() { return movie;
    }

    public void setMovie(Movie movie) {

        this.movie= movie;

    }
}
