package app;

import lombok.Getter;

public class Path {
    public static class Web {
        @Getter public static final String HOME_PAGE = "/";
        @Getter public static final String HOME_PAGE_USER = "/home/";
        @Getter public static final String HOME_PAGE_ADMIN = "/home_admin/";
        @Getter public static final String LOGIN_PAGE = "/login/";
        @Getter public static final String REGISTER_PAGE = "/register/";
        @Getter public static final String FILM_PAGE = "/film/:filmid/view/";
        @Getter public static final String FILM_PAGE_USER = "/film_details/:filmid/view/";
        @Getter public static final String FILM_PAGE_ADMIN = "/film_details_admin/:filmid/view/";
        @Getter public static final String FILM_PAGE_EDIT = "/film_details_admin/:filmid/edit/";
        @Getter public static final String FILM_PAGE_DELETE = "/film_details_admin/:filmid/delete/";
        @Getter public static final String INSERT_FILM_PAGE = "/insert_film/";
        @Getter public static final String BOOKING_PAGE = "/film_details/:filmid/book/";
    }

    public static class Template {
            public static final String HOME_PAGE = "/file/homepage/home.vm";
            public static final String HOME_PAGE_USER = "/file/user_home/user_home.vm";
            public static final String HOME_PAGE_ADMIN = "/file/admin_home/admin_home.vm";
            public static final String LOGIN_PAGE = "/file/login/login.vm";
            public static final String REGISTER_PAGE = "/file/register/register.vm";
            public static final String FILM_PAGE = "/file/films/filmdetail.vm";
            public static final String FILM_PAGE_USER = "/file/films_user/filmdetail_user.vm";
            public static final String FILM_PAGE_ADMIN = "/file/films_admin/filmdetail_admin.vm";
           // public static final String FILM_PAGE_EDIT = "/file/films_admin/film_edit.vm/";
            public static final String INSERT_FILM_PAGE = "/file/films_admin/film_insert.vm";
            public static final String BOOKING_PAGE = "/file/films_user/reservation.vm";
    }

}