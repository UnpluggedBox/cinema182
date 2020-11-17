package dao;

import app.BaseDao;
import model.Film;
import org.sql2o.Connection;

import java.util.Date;
import java.util.List;

public class FilmDao extends BaseDao {
    public List<Film> getAllFilms() {
        String sql = "SELECT * FROM Films";
        try (Connection con = db.open()) {
            return con.createQuery(sql).executeAndFetch(Film.class);
        }
    }

    public Film getFilm(Integer filmid) {
        String sql = "SELECT * FROM Films WHERE filmid = :filmid";
        try (Connection con = db.open()) {
            return con.createQuery(sql).addParameter("filmid", filmid).executeAndFetchFirst(Film.class);
        }
    }


    public void insertFilm(String title, String description, String duration, Date releasedate, String filmimageloc, String trailerurl) {
        String sql = "INSERT INTO Films(title, description, duration, releasedate, filmimageloc, trailerurl) VALUES (:title, :description, :duration, :releasedate, :filmimageloc, :trailerurl)";
        try (Connection con = db.open()) {
            con.createQuery(sql).addParameter("title", title)
                    .addParameter("description", description)
                    .addParameter("duration", duration)
                    .addParameter("releasedate", releasedate)
                    .addParameter("filmimageloc", filmimageloc)
                    .addParameter("trailerurl", trailerurl)
                    .executeUpdate();
        }
    }

    public void updateFilm(Integer filmid, String title, String description, String duration, Date releasedate, String filmimageloc, String trailerurl) {
        String sql = "UPDATE Films SET title = :title, " +
                "description = :description, duration = :duration, releasedate = :releasedate, filmimageloc = :filmimageloc, trailerurl = :trailerurl " +
                "WHERE filmid = :filmid";
        try(Connection con = db.open()) {
            con.createQuery(sql).addParameter("filmid", filmid)
                    .addParameter("title", title)
                    .addParameter("description", description)
                    .addParameter("duration", duration)
                    .addParameter("releasedate", releasedate)
                    .addParameter("filmimageloc", filmimageloc)
                    .addParameter("trailerurl", trailerurl)
                    .executeUpdate();
        }
    }

    public void deleteFilm(Integer filmid) {
        String sql = "DELETE FROM Films WHERE filmid = :filmid";
        try (Connection con = db.open()) {
            con.createQuery(sql).addParameter("filmid", filmid)
                    .executeUpdate();
        }
    }
}
