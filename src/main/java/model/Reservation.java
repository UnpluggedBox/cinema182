/**
 *
 * Not used yet
 *
 **/

package model;

import lombok.Getter;

import java.util.Date;

public class Reservation {
    @Getter private Integer reservationid;
    @Getter private Integer userid;
    @Getter private Integer filmid;
    @Getter private Integer theatreid;
    @Getter private String filmtitle;
    @Getter private Date filmdate;
    @Getter private Integer seatid;
    @Getter private Integer person;

    public Reservation (){
        reservationid = userid = filmid = theatreid = seatid = person = 0;
        filmtitle = "";
        filmdate = new Date();
    }

    public Reservation(Integer reservationid, Integer userid, Integer filmid, Integer theatreid, String filmtitle, Date filmdate, Integer seatid, Integer person) {
        this.reservationid = reservationid;
        this.userid = userid;
        this.filmid = filmid;
        this.theatreid = theatreid;
        this.filmtitle = filmtitle;
        this.filmdate = filmdate;
        this.seatid = seatid;
        this.person = person;

    }
}
