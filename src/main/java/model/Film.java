package model;

import lombok.Getter;

import java.util.Date;

public class Film {
    @Getter private Integer filmid;
    @Getter private String title;
    @Getter private String description;
    @Getter private String duration;
    @Getter private Date releasedate;
    @Getter private String filmimageloc;
    @Getter private String trailerurl;

    public Film() {
        filmid = 0;
        title = "";
        description = "";
        duration = "";
        releasedate = new Date();
        filmimageloc = "";
        trailerurl = "";

    }

    public Film(Integer filmid, String title, String description, String duration, Date releasedate, String filmimageloc, String trailerurl) {
        this.filmid = filmid;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.releasedate = releasedate;
        this.filmimageloc = filmimageloc;
        this.trailerurl = trailerurl;
    }

}