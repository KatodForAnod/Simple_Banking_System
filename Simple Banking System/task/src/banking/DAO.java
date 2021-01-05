package banking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements Database {
    private static final String URL = "jdbc:postgresql://localhost:4444/2ndLab";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345678";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try {
            String sql;
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM card");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String numberOfCard = rs.getString("number");
                String password = rs.getString("pin");
                Integer balance = rs.getInt("balance");
                users.add(new User(password, numberOfCard));
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return users;
    }

    @Override
    public boolean addUser(User user) {
        try {
            String sql;
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stmt = connection.createStatement();

            sql = String.format("INSERT INTO card VALUES('%d', '%s', '%s','%d')"
                    , user.getId(), user.getNumberFfCard(), user.getPassword(), (int) user.getBalance());

            stmt.executeUpdate(sql);

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
