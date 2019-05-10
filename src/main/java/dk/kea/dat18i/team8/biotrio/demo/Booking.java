package dk.kea.dat18i.team8.biotrio.demo;

public class Booking {

    private int booking_id;
    private String phoneNo; // shall be String according to StackOverflow
    private int seat_id; // we can consider to implement Seat object and List class/library here
    private Screening screeningBooked;

    public Booking (){
    }


    public Booking(int booking_id, String phoneNo, int seat_id, Screening screeningBooked){
        this.booking_id = booking_id;
        this.phoneNo = phoneNo;
        this.seat_id = seat_id;
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

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
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
                ", seat_id=" + seat_id + '|' +
                ", Screening details=" + screeningBooked +
                '}';
    }
}

