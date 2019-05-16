package dk.kea.dat18i.team8.biotrio.demo.Seat;

import dk.kea.dat18i.team8.biotrio.demo.theater.Theater;

public class Seat {

    private int seat_no;
    private Theater theater;
    private int row;
    //private boolean seat_reserved;


    public  Seat() {}


    public int getSeat_id() {
        return getSeat_id();
    }

    public void setSeat_no(int seat_no) {
        this.seat_no = seat_no;
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

    //public boolean getSeat_reserved() {
      //  return seat_reserved;
    //}

   // public void setSeat_reserved(boolean seat_reserved) {
     //   this.seat_reserved = seat_reserved;
    //}



        @Override
        public String toString() {
            return "Seat{" +
                    "theater" + theater +
                    "row=" + row +
                    ", seat_id=" + seat_no+
                    //", seat_reserved=" + seat_reserved +
                    '}';
    }
}