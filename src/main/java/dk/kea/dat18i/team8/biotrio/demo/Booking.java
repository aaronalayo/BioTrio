package dk.kea.dat18i.team8.biotrio.demo;



public class Booking {

    private int booking_id;
    private String phone_no; // shall be String according to StackOverflow
    private Seat seat;
    private Screening screening;

    public Booking (){
    }


    public Booking(int booking_id, String phone_no, Seat seat, Screening screening){
        this.booking_id = booking_id;
        this.phone_no = phone_no;
        this.seat = seat;
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

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
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
                ", seat=" + seat + '|' +
                ", Screening details=" + screening +
                '}';
    }
}

