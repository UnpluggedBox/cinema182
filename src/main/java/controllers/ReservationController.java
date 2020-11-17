/**
 *
 * Not used yet
 *
 **/

package controllers;

import app.Path;
import app.View;
import dao.*;

import spark.Request;
import spark.Response;
import spark.Route;
import java.util.HashMap;
import java.util.Map;


public class ReservationController {
    private static ReservationDao reservationDao = new ReservationDao();
    private static FilmDao filmDao = new FilmDao();
    private static UserDao userDao = new UserDao();
    private static TheatreDao theatreDao = new TheatreDao();
    private static SeatDao seatDao = new SeatDao();

    public static Route serveViewReservationPage = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();

        Integer filmid = Integer.parseInt(req.params("filmid"));
        // Integer userid = Integer.parseInt(req.params("userid"));
       // model.put("userList", userDao.getUser(userid));
        model.put("theatreList", theatreDao.getAllTheatre());
        model.put("reservationList", reservationDao.getAllReservation());
        model.put("film", filmDao.getFilm(filmid));
        return View.render(req, model, Path.Template.FILM_PAGE);
    };
}
