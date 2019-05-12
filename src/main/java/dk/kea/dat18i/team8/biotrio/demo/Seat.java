package dk.kea.dat18i.team8.biotrio.demo;

public class Seat {

    private int seat_id;
    private Theater theater;
    private int row;
    private boolean isBooked;



    public  Seat() {}


    public int getSeat_id() {
        return getSeat_id();
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }



        @Override
        public String toString() {
            return "Seat{" +
                    "theater" + theater +
                    "row=" + row +
                    ", seat_id=" + seat_id +
                    ", isBooked=" + isBooked +
                    '}';
    }
}