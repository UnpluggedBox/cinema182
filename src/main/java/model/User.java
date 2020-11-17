package model;

import lombok.Getter;

public class User {
    @Getter private Integer userid;
    @Getter private String email;
    @Getter private String password;
    @Getter private String fname;
    @Getter private String lname;
    @Getter private String role;


    public User() {
        userid = 0;
        email = "";
        password = "";
        fname = "";
        lname = "";
        role = "";

    }

    public User(Integer userid, String email, String password, String fname, String lname, String role) {
        this.userid = userid;
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
    }

    public int getUserid() { return userid; }

    public String getEmail() { return email; }

    public String getPassword() {
        return password;
    }

    public String getFname() {
        return fname;
    }

    public String getRole() {
        return role;
    }

}