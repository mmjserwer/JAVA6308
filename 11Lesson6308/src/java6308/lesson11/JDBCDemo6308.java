package java6308.lesson11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo6308 {
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DBANME = "db/db6308.db3";
    private static final String URL = "jdbc:sqlite:" + DBANME;
    private static final String USER = "";
    private static final String PW = "";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        try (Connection con = DriverManager.getConnection(URL, USER, PW);
             Statement statement = con.createStatement();) {
            System.out.println("使用的数据库产品：" + con.getMetaData().getDatabaseProductName());
            System.out.println("版本号：" + con.getMetaData().getDatabaseProductVersion());
            System.out.println("数据库的URL：" + con.getMetaData().getURL());
        }
    }
}
