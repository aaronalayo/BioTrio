package dk.kea.dat18i.team8.biotrio.demo.screenings;


public class ScreeningForm {


    private String showing;
    private int movie_id;
    private int theater_id;

    public ScreeningForm(String showing, int movie_id, int theater_id) {
        this.showing = showing;
        this.movie_id = movie_id;
        this.theater_id = theater_id;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public ScreeningForm(){

    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public ScreeningForm(){




    @Override
    public String toString() {
        return "ScreeningForm{" + "showing='" + showing + '\'' + ", movie_id=" + movie_id + '}';
    }