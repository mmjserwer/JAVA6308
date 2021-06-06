package java6308.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static java6308.dao.DBUtil6308.close;
import static java6308.dao.DBUtil6308.getConnnection;

public class Dao6308 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        delete(i);
    }

    private static void delete(int id1) {
        Connection con = null;
        String sql = "delete from xslist where id = ?";
        PreparedStatement pstmt = null;
        try {
            con = getConnnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id1);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }
    }
}
