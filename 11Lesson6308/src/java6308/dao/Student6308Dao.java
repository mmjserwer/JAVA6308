package java6308.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java6308.dao.DBUtil6308.close;
import static java6308.dao.DBUtil6308.getConnnection;

public class Student6308Dao {
    public static void main(String[] args) throws SQLException {
        Student6308 stu=new Student6308("211906308","csj");
        add6308(stu);
        update6308(1,stu);
        delete(3);
        findAll6308();
        findStudent6308("211906308");
        testAdd6308();
        testFind6308();
    }

    private static Student6308 findStudent6308(String sno) throws SQLException {
        Student6308 stu = new Student6308();
        Connection con = getConnnection();
        String sql = "select * from xslist where sno=?";
        PreparedStatement pstm = null;
        pstm = con.prepareStatement(sql);
        pstm.setString(1, sno);
        ResultSet rs=pstm.executeQuery();
        if (pstm.executeUpdate() > 0) {
            while(rs.next()){
                stu.setSno(rs.getString("sno"));
                stu.setLx2(rs.getInt("lx2"));
                stu.setSname(rs.getString("sname"));
                stu.setLx1(rs.getInt("lx1"));
                stu.setId(rs.getInt("id"));
            }
            return stu;
        }
        return null;
    }

    private static List<Student6308> findAll6308() throws SQLException {
        Connection con = getConnnection();
        String sql = "select * from xslist";
        PreparedStatement sta = null;
        sta = con.prepareStatement(sql);
        ResultSet rs = sta.executeQuery();
        List<Student6308> list = new ArrayList<>();
        while (rs.next()) {
            Student6308 stu = new Student6308();
            stu.setSno(rs.getString("sno"));
            stu.setLx2(rs.getInt("lx2"));
            stu.setSname(rs.getString("sname"));
            stu.setLx1(rs.getInt("lx1"));
            stu.setId(rs.getInt("id"));
            list.add(stu);
        }
        close(rs);
        close(sta);
        close(con);
        if (list.size() > 0)
            return list;
        return null;
    }

    private static int delete(int id) throws SQLException {
        Connection con = getConnnection();
        String sql = "delete from xslist where id=?";
        PreparedStatement pstm = null;
        pstm = con.prepareStatement(sql);
        pstm.setInt(1, id);

        if (pstm.executeUpdate() > 0) {
            close(pstm);
            close(con);
            return 1;
        }
        close(pstm);
        close(con);
        return -1;
    }

    private static int update6308(int id, Student6308 newStudent) throws SQLException {
        Connection con = getConnnection();
        String sql = "update xslist set sno=?,sname=? ,lx1=? ,lx2=? where id=?";
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, newStudent.getSno());
        pstmt.setString(2, newStudent.getSname());
        pstmt.setInt(3, newStudent.getLx1());
        pstmt.setInt(4, newStudent.getLx2());
        pstmt.setInt(5, id);
        close(pstmt);
        close(con);
        if (pstmt.executeUpdate() > 0)
            return 1;
        return -1;


    }

    private static int add6308(Student6308 student6308) throws SQLException {
        Connection con = getConnnection();
        String sql = "insert into xslist values(?,?)";
        PreparedStatement pstmt = null;
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, student6308.getSno());
        pstmt.setString(2, student6308.getSname());
        close(pstmt);
        close(con);
        if (student6308 != null)
            return student6308.getId();
        return -1;
    }

    private static void testFind6308() throws SQLException {
        Student6308 student = new Student6308();
        student.setSno("add123");
        student.setSname("数据访问");
        student.setLx1(70);
        student.setLx2(90);
        int id = new Student6308Dao().add6308(student);
        System.out.println("id+" + id);
    }

    private static void testAdd6308() {
        List<Student6308> list = null;
        try {
            list = new Student6308Dao().findAll6308();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Student6308 student : list) {
            System.out.println(student);
        }
    }

}
