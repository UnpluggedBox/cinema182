package controllers;

import app.Path;
import app.View;
import dao.FilmDao;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class HomeController {
    private static FilmDao dao = new FilmDao();

    public static Route serveViewHomePage = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("filmList", dao.getAllFilms());
        return View.render(req, model, Path.Template.HOME_PAGE);
    };


}
