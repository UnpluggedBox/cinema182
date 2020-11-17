import app.Path;
import controllers.*;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        staticFiles.location("/file");
        notFound("<html><body><h1>Uh oh! You must have typed the Wrong URL. Check again!</h1></body></html>");

        get(Path.Web.HOME_PAGE, HomeController.serveViewHomePage);
        get(Path.Web.HOME_PAGE_USER, UserController.serveViewHomePageUser);
        get(Path.Web.HOME_PAGE_ADMIN, UserController.serveViewHomePageAdmin);

        get(Path.Web.LOGIN_PAGE, LoginController.serveViewLoginPage);
        post(Path.Web.HOME_PAGE_USER, UserController.serveViewLinkHomePageUser);

        get(Path.Web.FILM_PAGE, FilmController.serveViewFilmDetailPage);
        get(Path.Web.FILM_PAGE_USER, UserController.serveViewFilmDetailPageUser);
        get(Path.Web.FILM_PAGE_ADMIN, UserController.serveViewFilmDetailPageAdmin);


        get(Path.Web.REGISTER_PAGE, RegisterController.serveViewRegisterPage);
        post(Path.Web.REGISTER_PAGE, RegisterController.handleAddUser);

        get(Path.Web.INSERT_FILM_PAGE, FilmController.serveViewInsertFilmPage);
        post(Path.Web.INSERT_FILM_PAGE, FilmController.handleAddFilm);

        get(Path.Web.FILM_PAGE_EDIT, FilmController.serveEditFilmPage);
        post(Path.Web.FILM_PAGE_EDIT, FilmController.handleEditFilm);

        get(Path.Web.FILM_PAGE_DELETE, FilmController.serveViewFilmDelete);
        post(Path.Web.FILM_PAGE_DELETE, FilmController.handleDeleteFilm);
    }
}
