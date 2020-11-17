package dao;

import app.BaseDao;
import model.Seat;


import org.sql2o.Connection;

import java.util.List;

public class SeatDao extends BaseDao {
    public List<Seat> getAllSeat() {
        String sql = "SELECT * FROM Seats";
        try (Connection con = db.open()) {
            return con.createQuery(sql).executeAndFetch(Seat.class);
        }
    }

    public Seat getSeat(Integer seatid) {
        String sql = "SELECT * FROM Seats WHERE seatid = :seatid";
        try (Connection con = db.open()) {
            return con.createQuery(sql).addParameter("seatid", seatid).executeAndFetchFirst(Seat.class);
        }
    }


    public void insertSeat(String row, String seat) {
        String sql = "INSERT INTO Seats(row, seat) VALUES (:row, :seat)";
        try (Connection con = db.open()) {
            con.createQuery(sql).addParameter("row", row)
                    .addParameter("seat", seat)
                    .executeUpdate();
        }
    }

    public void updateSeat(Integer seatid, String studioname) {
        String sql = "UPDATE Seats SET seatid = :seatid, " +
                "row = :row, seat = :seat " +
                "WHERE seatid = :seatid";
        try(Connection con = db.open()) {
            con.createQuery(sql).addParameter("seatid", seatid)
                    .addParameter("studioname", studioname)
                    .executeUpdate();
        }
    }

    public void deleteSeat(Integer seatid) {
        String sql = "DELETE FROM Seats WHERE seatid = :seatid";
        try (Connection con = db.open()) {
            con.createQuery(sql).addParameter("seatid", seatid)
                    .executeUpdate();
        }
    }
}
