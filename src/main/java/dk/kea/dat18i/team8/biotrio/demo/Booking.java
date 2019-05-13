package dk.kea.dat18i.team8.biotrio.demo;

public class Booking {

    private int booking_id;
    private String phoneNo; // shall be String according to StackOverflow
    private Seat seat;
    private Screening screeningBooked;

    public Booking (){
    }


    public Booking(int booking_id, String phoneNo, Seat seat, Screening screeningBooked){
        this.booking_id = booking_id;
        this.phoneNo = phoneNo;
        this.seat = seat;
        this.screeningBooked = screeningBooked;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int id) {
        this.booking_id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Screening getScreeningBooked() {
        return screeningBooked;
    }

    public void setScreeningBooked(Screening screeningBooked) {
        this.screeningBooked = screeningBooked;
    }


    @Override

    public String toString() {


        return "Booking{" +

                "booking_id=" + booking_id +
                ", phone number=" + phoneNo + '|' +
                ", seat=" + seat + '|' +
                ", Screening details=" + screeningBooked +
                '}';
    }
}

