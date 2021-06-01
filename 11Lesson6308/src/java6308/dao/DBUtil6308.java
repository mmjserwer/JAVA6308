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
    private static Properties prop;

    static {
        try {
            prop.load(new FileInputStream("congig/database6308.properties"));
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

    public static Connection getConnnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PW);
    }

    public static void close(Connection conn) {
        if (Objects.requireNonNull(conn) != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt) {
        if (Objects.requireNonNull(stmt) != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement pStmt) {
        if (Objects.requireNonNull(pStmt) != null) {
            try {
                pStmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs) {
        if (Objects.requireNonNull(rs) != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
