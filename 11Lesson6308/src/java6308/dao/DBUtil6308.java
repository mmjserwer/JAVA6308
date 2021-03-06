package java6308.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class DBUtil6308 {
    private static final String DRIVER;
    private static final String URL;
    private static final String USER;
    private static final String PW;
    private static final Properties prop;

    static {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("config/database6308.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER = prop.getProperty("driver");
        URL = prop.getProperty("url");
        USER = prop.getProperty("user");
        PW = prop.getProperty("pw");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PW);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public static void close(Connection conn) {
        Objects.requireNonNull(conn);
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        Objects.requireNonNull(stmt);
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(PreparedStatement pStmt) {
        Objects.requireNonNull(pStmt);

        try {
            pStmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void close(ResultSet rs) {
        Objects.requireNonNull(rs);
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
