package dk.kea.dat18i.team8.biotrio.demo.theater;

import dk.kea.dat18i.team8.biotrio.demo.theater.Theater;

public class Seat {

    private int seat_id;
    private Theater theater;
    private int row;
    private boolean seat_reserved;


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

    public boolean seat_reserved() {
        return seat_reserved;
    }

    public void setSeat_reserved(boolean seat_reserved) {
        this.seat_reserved = seat_reserved;
    }



        @Override
        public String toString() {
            return "Seat{" +
                    "theater" + theater +
                    "row=" + row +
                    ", seat_id=" + seat_id +
                    ", seat_reserved=" + seat_reserved +
                    '}';
    }
}