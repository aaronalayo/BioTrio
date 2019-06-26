package dk.kea.dat18i.team8.biotrio.demo.theater;
public class Theater {
    private int theater_id;
    private String theater_name;
    private String theater_format;
    private String theater_sound;
    private int number_of_rows;
    private int seats_per_row;

    //constructors
    public Theater() { }


    public Theater(int theater_id, String theater_name, String theater_format, String theater_sound, int number_of_rows, int seats_per_row) {
        this.theater_id = theater_id;
        this.theater_name = theater_name;
        this.theater_format = theater_format;
        this.theater_sound = theater_sound;
        this.number_of_rows = number_of_rows;
        this.seats_per_row = seats_per_row;
    }

    //setters and getters
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

    public String getTheater_format() {
        return theater_format;
    }

    public void setTheater_format(String theater_format) {
        this.theater_format = theater_format;
    }


    public String getTheater_sound() {
        return theater_sound;
    }

    public void setTheater_sound(String theater_sound) {
        this.theater_sound = theater_sound;
    }

    public int getNumber_of_rows() { return number_of_rows; }

    public void setNumber_of_rows(int number_of_rows) { this.number_of_rows = number_of_rows; }

    public int getSeats_per_row() { return seats_per_row; }

    public void setSeats_per_row(int seats_per_row) { this.seats_per_row = seats_per_row; }
}