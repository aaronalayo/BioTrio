package dk.kea.dat18i.team8.biotrio.demo;

import java.util.ArrayList;
import java.util.List;

public class ScreeningForm {


    String screening_date_form;
    String screening_starts_form;
    int movie_id;

    public ScreeningForm(){

    }


    public ScreeningForm(String screening_date_form, String screening_starts_form)
    {
        this.screening_date_form = screening_date_form;
        this.screening_starts_form = screening_starts_form;
    }

    public String getScreening_date_form() {

        return screening_date_form;
    }

    public void setScreening_date_form(String screening_date) {

        this.screening_date_form =  screening_date_form;
    }

    public String getScreening_starts_form() {
        return screening_starts_form;
    }

    public void setScreening_starts_form(String screening_starts_form) {
        this.screening_starts_form = screening_starts_form;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }


    @Override
    public String toString() {
        return "ScreeningForm{" + "screening_date_form='" +
                screening_date_form + '\'' + ", screening_starts_form='" +
                screening_starts_form + '\'' + ", movie_id=" + movie_id + '}';
    }
}
