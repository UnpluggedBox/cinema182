package controllers;

import app.Path;
import app.View;
import dao.FilmDao;
import dao.UserDao;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private static UserDao dao = new UserDao();
    private static FilmDao filmDao = new FilmDao();
    public static String fnameLogin;
    private static String roleLogin;
    private static int currentId;
/*

 */

    public static Route serveViewHomePageUser = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("userList", dao.getAllUsers());
        model.put("filmList", filmDao.getAllFilms());
        model.put("fnameLogin", fnameLogin);
        model.put("roleLogin", roleLogin);
        return View.render(req, model, Path.Template.HOME_PAGE_USER);
    };

    public static Route serveViewHomePageAdmin = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("userList", dao.getAllUsers());
        model.put("filmList", filmDao.getAllFilms());
        model.put("fnameLogin", fnameLogin);
        model.put("roleLogin", roleLogin);
        return View.render(req, model, Path.Template.HOME_PAGE_ADMIN);
    };

    public static Route serveViewLinkHomePageUser = (Request req, Response res) -> {
        String email = req.queryParams("email");
        String password = req.queryParams("password");

        for(int x = 0; x < dao.getAllUsers().size(); x++)
        {
            if(dao.getAllUsers().get(x).getEmail().equals(email) && dao.getAllUsers().get(x).getPassword().equals(password) && dao.getAllUsers().get(x).getRole().equals("User"))
            {
                currentId = dao.getAllUsers().get(x).getUserid();
                fnameLogin = "Hello, " + dao.getAllUsers().get(x).getFname();
                roleLogin = dao.getAllUsers().get(x).getRole();

                res.redirect(Path.Web.HOME_PAGE_USER);
                break;
            } else if (dao.getAllUsers().get(x).getEmail().equals(email) && dao.getAllUsers().get(x).getPassword().equals(password) && dao.getAllUsers().get(x).getRole().equals("Admin")) {

                currentId = dao.getAllUsers().get(x).getUserid();
                fnameLogin = "Hello, " + dao.getAllUsers().get(x).getFname();
                roleLogin = dao.getAllUsers().get(x).getRole();

                res.redirect(Path.Web.HOME_PAGE_ADMIN);
                break;
            } if (dao.getAllUsers().size() - 1 == x) {
                    System.out.println("User not found");
                    res.redirect(Path.Web.LOGIN_PAGE);
            }
        }

        return null;
    };

    public static Route serveViewFilmDetailPageUser = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();

        Integer filmid = Integer.parseInt(req.params("filmid"));
        model.put("film", filmDao.getFilm(filmid));
        model.put("filmList", filmDao.getAllFilms());
        model.put("fnameLogin", fnameLogin);
        model.put("currentId", currentId);
        return View.render(req, model, Path.Template.FILM_PAGE_USER);
    };

    public static Route serveViewFilmDetailPageAdmin = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();

        Integer filmid = Integer.parseInt(req.params("filmid"));
        model.put("film", filmDao.getFilm(filmid));
        model.put("filmList", filmDao.getAllFilms());
        model.put("fnameLogin", fnameLogin);
        return View.render(req, model, Path.Template.FILM_PAGE_ADMIN);
    };
}