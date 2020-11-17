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

public class LoginController {
    private static UserDao dao = new UserDao();
    private static FilmDao filmDao = new FilmDao();
    private static String fnameLogin;
    private static String roleLogin;
    private static int currentId;

    public static Route serveViewLoginPage = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("userList", dao.getAllUsers());
        model.put("fnameLogin", fnameLogin);
        model.put("roleLogin", roleLogin);
        return View.render(req, model, Path.Template.LOGIN_PAGE);
    };

}
