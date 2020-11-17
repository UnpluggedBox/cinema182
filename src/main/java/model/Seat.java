/**
 *
 * Not used yet
 *
 **/

package model;

import lombok.Getter;

public class Seat {
    @Getter private Integer seatid;
    @Getter private String row;
    @Getter private String seat;


    public Seat() {
        seatid = 0;
        row = "";
        seat = "";
    }

    public Seat(Integer seatid, String row, String seat) {
        this.seatid  = seatid;
        this.row = row;
        this.seat = seat;
    }

}
