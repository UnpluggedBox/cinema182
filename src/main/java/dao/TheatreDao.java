package dao;

import app.BaseDao;
import model.Theatre;

import org.sql2o.Connection;

import java.util.List;

public class TheatreDao extends BaseDao {
    public List<Theatre> getAllTheatre() {
        String sql = "SELECT * FROM Theatres";
        try (Connection con = db.open()) {
            return con.createQuery(sql).executeAndFetch(Theatre.class);
        }
    }

    public Theatre getTheatre(Integer theatreid) {
        String sql = "SELECT * FROM Theatres WHERE theatreid = :theatreid";
        try (Connection con = db.open()) {
            return con.createQuery(sql).addParameter("theatreid", theatreid).executeAndFetchFirst(Theatre.class);
        }
    }


    public void insertTheatre(String studioname) {
        String sql = "INSERT INTO Theatres(studioname) VALUES (:studioname)";
        try (Connection con = db.open()) {
            con.createQuery(sql).addParameter("studioname", studioname)
                    .executeUpdate();
        }
    }

    public void updateTheatre(Integer theatreid, String studioname) {
        String sql = "UPDATE Theatres SET theatreid = :theatreid, " +
                "studioname = :studioname " +
                "WHERE theatreid = :theatreid";
        try(Connection con = db.open()) {
            con.createQuery(sql).addParameter("theatreid", theatreid)
                    .addParameter("studioname", studioname)
                    .executeUpdate();
        }
    }

    public void deleteTheatre(Integer theatreid) {
        String sql = "DELETE FROM Theatres WHERE theatreid = :theatreid";
        try (Connection con = db.open()) {
            con.createQuery(sql).addParameter("theatreid", theatreid)
                    .executeUpdate();
        }
    }
}
