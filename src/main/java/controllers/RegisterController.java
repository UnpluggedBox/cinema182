package controllers;

import app.Path;
import app.View;
import dao.UserDao;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class RegisterController {
    private static UserDao dao = new UserDao();

    public static Route serveViewRegisterPage = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("userList", dao.getAllUsers());
        return View.render(req, model, Path.Template.REGISTER_PAGE);
    };

    public static Route handleAddUser = (Request req, Response res) -> {
        String email = req.queryParams("email");
        String fname = req.queryParams("fname");
        String lname = req.queryParams("lname");
        String password = req.queryParams("password");
        // role automatis "User" untuk user yang register (ada di class UserDao line 25). account admin hanya rubin.535180123@stu.untar.ac.id

        if(email.contains("@") && email.contains(".") && !fname.isEmpty() && !lname.isEmpty() && !password.isEmpty()) {
            dao.insertUser(email, password, fname, lname);
            res.redirect(Path.Web.LOGIN_PAGE);
        }
        return null;
    };
}
