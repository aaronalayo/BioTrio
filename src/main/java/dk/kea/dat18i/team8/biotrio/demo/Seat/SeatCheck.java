package dk.kea.dat18i.team8.biotrio.demo.Seat;


import java.util.List;

public class SeatCheck {

    private List<Seat> seats;
    private List<String> checkedSeats;


    public SeatCheck(){

    }
    public SeatCheck(List<Seat> seats, List<String> checkedSeats) {
        this.seats = seats;
        this.checkedSeats = checkedSeats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }



    public List<String> getCheckedSeats() {
        return checkedSeats;
    }

    public void setCheckedSeats(List<String> checkedSeats) {

        this.checkedSeats = checkedSeats;
    }


}
