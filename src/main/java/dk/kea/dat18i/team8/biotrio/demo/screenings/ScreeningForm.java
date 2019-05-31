package dk.kea.dat18i.team8.biotrio.demo.screenings;

/*This class allows to use the attribute LocalDateTime showing and
use it as a String and then send it in the Timestamp format to the database.
Also to use movie_id and theater_id */


public class ScreeningForm {

    private String showing;
    private int movie_id;
    private int theater_id;

    //constructors
    public ScreeningForm() {

    }
    public ScreeningForm(String showing, int movie_id, int theater_id) {
        this.showing = showing;
        this.movie_id = movie_id;
        this.theater_id = theater_id;
    }

    //setters and getters
    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }


    public String getShowing() {
        return showing;
    }


    public void setShowing(String showing) {
        this.showing = showing;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    @Override
    public String toString() {
        return "ScreeningForm{" +
                "showing='" + showing + '\'' +
                ", movie_id=" + movie_id +
                ", theater_id=" + theater_id +
                '}';
    }
}

