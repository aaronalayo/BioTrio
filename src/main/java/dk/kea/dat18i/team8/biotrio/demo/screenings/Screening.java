package dk.kea.dat18i.team8.biotrio.demo.screenings;

import dk.kea.dat18i.team8.biotrio.demo.movies.Movie;
import dk.kea.dat18i.team8.biotrio.demo.theater.Theater;

import java.time.LocalDateTime;

public class Screening {

    private int screening_id;
    private LocalDateTime showing;
    private Movie movie;
    private Theater theater;



    public Screening(int screening_id, LocalDateTime showing, Movie movie, Theater theater) {
        this.screening_id = screening_id;
        this.showing = showing;
        this.movie = movie;
        this.theater = theater;
    }




    public Screening (){
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

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public String toString() {
        return "Screening{" + "screening_id=" + screening_id + ", showing=" + showing + ", movie=" + movie + ", theater=" + theater + '}';
    }
}
