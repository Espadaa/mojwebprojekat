package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection conn = null;

    private String url = "jdbc:mysql://localhost:3306/prodavnica";
    private String user = "root";
    private String password = "";
    private static DBConnection instance = null;

    public DBConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        }
        conn = DriverManager.getConnection(url, user, password);
    }

    public static Connection getConn() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance.conn;
    }

}