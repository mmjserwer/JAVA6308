package java6308.lesson11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleDML6308 {
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DBANME = "db/db6308.db3";
    private static final String URL = "jdbc:sqlite:" + DBANME;
    private static final String USER = "";
    private static final String PW = "";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        create6308();

       /* for(int i=0;i<10;i++){
            insert6308();
        }*/

//        update6308();

//        delete6308();

    }
    private static void execute6308(String sql) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        try (Connection con = DriverManager.getConnection(URL, USER, PW);
             Statement statement = con.createStatement();) {
            statement.executeUpdate(sql);
        }
    }

    private static void update6308() throws SQLException, ClassNotFoundException {
        String c = "update xslist set lx1=id+1,lx2=lx1+id ";
        execute6308(c);
    }

    private static void delete6308() throws SQLException, ClassNotFoundException {
        String b = "delete from xslist where lx1%3==0";
        execute6308(b);
    }

    private static void insert6308() throws SQLException, ClassNotFoundException {
        String a = "insert into xslist(sno,sname) values('211906308','陈思杰')";
        execute6308(a);
    }

    private static void create6308() throws SQLException, ClassNotFoundException {
        String sql = "create table xslist(\n" +
                "id integer primary key autoincrement not null,\n" +
                "sno text not null,\n" +
                "sname text,\n" +
                "lx1 integer,\n" +
                "lx2 integer\n" +
                ");";
        execute6308(sql);
    }
}
