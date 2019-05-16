package dk.kea.dat18i.team8.biotrio.demo.screenings;


public class ScreeningForm {


    private String showing;
    private int movie_id;


    public ScreeningForm(){

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

    public ScreeningForm(String showing, int movie_id) {
        this.showing = showing;
        this.movie_id = movie_id;
    }
}
