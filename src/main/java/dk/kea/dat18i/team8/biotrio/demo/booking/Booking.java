package dk.kea.dat18i.team8.biotrio.demo.booking;


import dk.kea.dat18i.team8.biotrio.demo.theater.Seat;
import dk.kea.dat18i.team8.biotrio.demo.screenings.Screening;

public class Booking {

    private int booking_id;
    private String phone_no; // shall be String according to StackOverflow
    private int seat_id;
    private Screening screening;

    public Booking (){
    }


    public Booking(int booking_id, String phone_no, int seat_id, Screening screening){
        this.booking_id = booking_id;
        this.phone_no = phone_no;
        this.seat_id = seat_id;
        this.screening = screening;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int id) {
        this.booking_id = id;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    @Override

    public String toString() {


        return "Booking{" +

                "booking_id=" + booking_id +
                ", phone number=" + phone_no + '|' +
                ", seat_id=" + seat_id + '|' +
                ", Screening details=" + screening +
                '}';
    }
}

