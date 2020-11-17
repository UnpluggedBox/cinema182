package dao;

import app.BaseDao;
import model.User;
import org.sql2o.Connection;

import java.util.List;

public class UserDao extends BaseDao {
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        try (Connection con = db.open()) {
            return con.createQuery(sql).executeAndFetch(User.class);
        }
    }

    public User getUser(Integer userid) {
        String sql = "SELECT * FROM users WHERE userid = :userid";
        try (Connection con = db.open()) {
            return con.createQuery(sql).addParameter("userid", userid).executeAndFetchFirst(User.class);
        }
    }

    public void insertUser(String email, String password, String fname, String lname) {
        String role = "User";

        String sql = "INSERT INTO users(email, password, fname, lname, role) VALUES (:email, :password, :fname, :lname, :role)";
        try (Connection con = db.open()) {
            con.createQuery(sql).addParameter("email", email)
                    .addParameter("password", password)
                    .addParameter("fname", fname)
                    .addParameter("lname", lname)
                    .addParameter("role", role)
                    .executeUpdate();
        }
    }

    public void updateUser(Integer userid, String email, String password, String fname, String lname, String role) {
        String sql = "UPDATE users SET email = :email, " +
                "password = :password, fname = :fname, lname = :lname, role = :role " +
                "WHERE userid = :userid";
        try(Connection con = db.open()) {
            con.createQuery(sql).addParameter("userid", userid)
                    .addParameter("email", email)
                    .addParameter("password", password)
                    .addParameter("fname", fname)
                    .addParameter("lname", lname)
                    .addParameter("role", role)
                    .executeUpdate();
        }
    }

    public void deleteUser(Integer userid) {
        String sql = "DELETE FROM users WHERE userid = :userid";
        try (Connection con = db.open()) {
            con.createQuery(sql).addParameter("userid", userid)
                    .executeUpdate();
        }
    }
}
