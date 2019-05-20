package dk.kea.dat18i.team8.biotrio.demo.theater;
public class Theater {
    private int theater_id;
    private String theater_name;
    private int number_of_seats;
    private String theater_format;

    public Theater() { }

    public Theater(int theater_id, String theater_name, int number_of_seats, String theater_format) {
        this.theater_id = theater_id;
        this.theater_name = theater_name;
        this.number_of_seats = number_of_seats;
        this.theater_format = theater_format;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public String getTheater_format() {
        return theater_format;
    }

    public void setTheater_format(String theater_format) {
        this.theater_format = theater_format;
    }
}