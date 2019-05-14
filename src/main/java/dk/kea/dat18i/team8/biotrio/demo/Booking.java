package dk.kea.dat18i.team8.biotrio.demo;



public class Booking {

    private int booking_id;
    private String phone_no; // shall be String according to StackOverflow
    private int seat_id;
    private int screening_id;

    public Booking (){
    }


    public Booking(int booking_id, String phone_no, int seat_id, int screening_id){
        this.booking_id = booking_id;
        this.phone_no = phone_no;
        this.seat_id = seat_id;
        this.screening_id = screening_id;
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

    public int getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(int screening_id) {
        this.screening_id = screening_id;
    }


    @Override

    public String toString() {


        return "Booking{" +

                "booking_id=" + booking_id +
                ", phone number=" + phone_no + '|' +
                ", seat_id=" + seat_id + '|' +
                ", Screening details=" + screening_id +
                '}';
    }
}

