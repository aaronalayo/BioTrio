package dk.kea.dat18i.team8.biotrio.demo;

public class ScreeningForm {

    private String screening_date_form;
    private String screening_starts_form;

    public ScreeningForm(){

    }

    public ScreeningForm(String screening_date_form, String screening_starts_form) {
        this.screening_date_form = screening_date_form;
        this.screening_starts_form= screening_starts_form;
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
}
