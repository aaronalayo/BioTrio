package dk.kea.dat18i.team8.biotrio.demo.Seat;


public class Seat {

    private int rowNo;
    private int seatPerRow;
    private boolean seat_reserved;


    public  Seat() {}

    public int getRowNo(){return this.rowNo;}

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public void getSeatPerRow(int seatPerRow) {
        this.seatPerRow = seatPerRow;
    }

    public boolean getSeat_reserved() {
       return seat_reserved;
    }

    public void setSeat_reserved(boolean seat_reserved) {
        this.seat_reserved = seat_reserved;
    }

        @Override
        public String toString() {
            return "Seat{" +
                    "row number=" + rowNo +
                    ", seat per row=" + seatPerRow+
                    ", seat_reserved=" + seat_reserved +
                    '}';
    }
}