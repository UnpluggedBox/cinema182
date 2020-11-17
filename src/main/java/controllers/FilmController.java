package controllers;

import app.Path;
import app.View;
import dao.FilmDao;
import model.Film;
import model.User;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FilmController {
    private static FilmDao dao = new FilmDao();

    public static Route serveViewFilmDetailPage = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();

        Integer filmid = Integer.parseInt(req.params("filmid"));
        model.put("film", dao.getFilm(filmid));
        model.put("filmList", dao.getAllFilms());
        return View.render(req, model, Path.Template.FILM_PAGE);
    };

    public static Route serveViewInsertFilmPage = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("fnameLogin", UserController.fnameLogin);
        model.put("film", new Film());
        return View.render(req, model, Path.Template.INSERT_FILM_PAGE);
    };

    public static Route handleAddFilm = (Request req, Response res) -> {
        String title = req.queryParams("title");
        String description = req.queryParams("description");
        String duration = req.queryParams("duration");
        String date = req.queryParams("releasedate");
        String filmimageloc = req.queryParams("filmimageloc");
        String trailerurl = req.queryParams("trailerurl");

        Date releasedate = java.sql.Date.valueOf(date);

        if(!title.isEmpty() && !description.isEmpty() && !duration.isEmpty() && !date.isEmpty() && !filmimageloc.isEmpty() && !trailerurl.isEmpty()) {
            dao.insertFilm(title, description, duration, releasedate, filmimageloc, trailerurl);
            res.redirect(Path.Web.INSERT_FILM_PAGE);
        }
        return null;
    };

    public static Route serveEditFilmPage = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();

        Integer filmid = Integer.parseInt(req.params("filmid"));
        model.put("film", dao.getFilm(filmid));

        return View.render(req, model, Path.Template.INSERT_FILM_PAGE); //pkai layout yg sama dgn add film
    };

    public static Route handleEditFilm = (Request req, Response res) -> {
        Integer filmid = Integer.parseInt(req.queryParams("filmid"));
        String title = req.queryParams("title");
        String description = req.queryParams("description");
        String duration = req.queryParams("duration");
        String date = req.queryParams("releasedate");
        String filmimageloc = req.queryParams("filmimageloc");
        String trailerurl = req.queryParams("trailerurl");
        Date releasedate = java.sql.Date.valueOf(date);


        dao.updateFilm(filmid, title, description, duration, releasedate, filmimageloc, trailerurl);

        res.redirect(Path.Web.HOME_PAGE_ADMIN);
        return null;
    };

    public static Route serveViewFilmDelete = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();
        return View.render(req, model, Path.Template.FILM_PAGE_ADMIN);
    };

    public static Route handleDeleteFilm = (Request req, Response res) -> {
        Integer filmid = Integer.parseInt(req.queryParams("filmid"));
        dao.deleteFilm(filmid);
        res.redirect(Path.Web.HOME_PAGE_ADMIN);
        return null;
    };

}
