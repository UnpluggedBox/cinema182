package dao;

import app.BaseDao;
import model.Reservation;
import org.sql2o.Connection;

import java.util.Date;
import java.util.List;

public class ReservationDao extends BaseDao {
    public List<Reservation> getAllReservation() {
        String sql = "SELECT * FROM Reservations";
        try (Connection con = db.open()) {
            return con.createQuery(sql).executeAndFetch(Reservation.class);
        }
    }

    public Reservation getReservation(Integer reservationid) {
        String sql = "SELECT * FROM Reservations WHERE reservationid = :reservationid";
        try (Connection con = db.open()) {
            return con.createQuery(sql).addParameter("reservationid", reservationid).executeAndFetchFirst(Reservation.class);
        }
    }


    public void insertReservation(Integer userid, Integer filmid, Integer theatreid, String filmtitle, Date filmdate, Integer seatid, Integer person) {
        String sql = "INSERT INTO Reservations(userid, filmid, theatreid, filmtitle, filmdate, seatid, person) VALUES (:userid, :filmid, :theatreid, :filmtitle, :filmdate, :seatid, :person)";
        try (Connection con = db.open()) {
            con.createQuery(sql).addParameter("userid", userid)
                    .addParameter("filmid", filmid)
                    .addParameter("theatreid", theatreid)
                    .addParameter("filmtitle", filmtitle)
                    .addParameter("filmdate", filmdate)
                    .addParameter("seatid", seatid)
                    .addParameter("person", person)
                    .executeUpdate();
        }
    }

    public void updateReservation(Integer reservationid, Integer userid, Integer filmid, Integer theatreid, String filmtitle, Date filmdate, Integer seatid, Integer person) {
        String sql = "UPDATE Reservations SET reservationid = :reservationid, " +
                "filmid = :filmid, theatreid = :theatreid, filmtitle = :filmtitle, filmdate = :filmdate, seatid = :seatid, person = :person " +
                "WHERE reservationid = :reservationid";
        try(Connection con = db.open()) {
            con.createQuery(sql).addParameter("reservationid", reservationid)
                    .addParameter("userid", userid)
                    .addParameter("filmid", filmid)
                    .addParameter("theatreid", theatreid)
                    .addParameter("filmtitle", filmtitle)
                    .addParameter("filmdate", filmdate)
                    .addParameter("seatid", seatid)
                    .addParameter("person", person)
                    .executeUpdate();
        }
    }

    public void deleteReservation(Integer reservationid) {
        String sql = "DELETE FROM Reservations WHERE reservationid = :reservationid";
        try (Connection con = db.open()) {
            con.createQuery(sql).addParameter("reservationid", reservationid)
                    .executeUpdate();
        }
    }
}
