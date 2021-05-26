package java6308.lesson11;

import java.sql.*;
import java.util.Scanner;

public class Select6308 {
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DBANME = "db/db6308.db3";
    private static final String URL = "jdbc:sqlite:" + DBANME;
    private static final String USER = "";
    private static final String PW = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要查找的名字中包含的任何信息：");
        String name1 = sc.nextLine();
        System.out.print("请输入id范围：");
        int id1 = sc.nextInt();
        PreparedStatement presta = null;
        Connection con = null;
        try {
            Class.forName(DRIVER);
            String sql = "SELECT id,sno,sname from xslist where sname like ? and id <?";
            con = DriverManager.getConnection(URL, USER, PW);
            presta = con.prepareStatement(sql);
            presta.setString(1, "%" + name1 + "%");
            presta.setInt(2, id1);
            final ResultSet set = presta.executeQuery();
            while (set.next()) {
                System.out.println(set.getString("id") + "," + set.getString("sno") + "," + set.getString("sname"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(presta!=null){
                try{
                    presta.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try{
                    con.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }


    }
}
