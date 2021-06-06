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
    public static void main(String[] args) {
        /*Student6308 stu = new Student6308("211906308", "csj");
        add6308(stu);
        update6308(1, stu);
        delete6308(3);
        findAll6308();
        findStudent6308("211906308");
        testAdd6308();
        testFind6308();*/
    }

    public static Student6308 findStudent6308(String sno) {
        Student6308 stu = new Student6308();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select * from xslist where sno=?";
        try {
            con = getConnnection();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, sno);
            rs = pstm.executeQuery();
            if (pstm.executeUpdate() > 0) {
                while (rs.next()) {
                    stu.setSno(rs.getString("sno"));
                    stu.setLx2(rs.getInt("lx2"));
                    stu.setSname(rs.getString("sname"));
                    stu.setLx1(rs.getInt("lx1"));
                    stu.setId(rs.getInt("id"));
                }
                return stu;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(rs);
            close(pstm);
            close(con);
        }
        return null;
    }

    public static List<Student6308> findAll6308() {
        Connection con = null;
        PreparedStatement sta = null;
        ResultSet rs = null;
        List<Student6308> list = null;
        String sql = "select * from xslist";
        try {
            con = getConnnection();
            sta = con.prepareStatement(sql);
            rs = sta.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Student6308 stu = new Student6308();
                stu.setSno(rs.getString("sno"));
                stu.setLx2(rs.getInt("lx2"));
                stu.setSname(rs.getString("sname"));
                stu.setLx1(rs.getInt("lx1"));
                stu.setId(rs.getInt("id"));
                list.add(stu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                close(rs);

            }
            close(sta);
            close(con);
        }
        if (list.size() > 0)
            return list;
        return null;
    }

    public static int delete6308(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        String sql = "delete from xslist where id=?";
        int i=-1;
        try {
            con = DBUtil6308.getConnnection();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            i=pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(pstm);
            close(con);
        }
        return i;
    }

    public static int update6308(int id, Student6308 newStudent) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "update xslist set sno=?,sname=? ,lx1=? ,lx2=? where id=?";
        int i=-1;
        try {
            con = getConnnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, newStudent.getSno());
            pstmt.setString(2, newStudent.getSname());
            pstmt.setInt(3, newStudent.getLx1());
            pstmt.setInt(4, newStudent.getLx2());
            pstmt.setInt(5, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(pstmt);
            close(con);
        }
        return i;
    }

    public static int add6308(Student6308 student6308) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "insert into xslist(sno,sname,lx1,lx2) values(?,?,?,?)";
        int i=-1;
        try {
            con = getConnnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, student6308.getSno());
            pstmt.setString(2, student6308.getSname());
            pstmt.setInt(3,student6308.getLx1());
            pstmt.setInt(4,student6308.getLx2());
            if(pstmt.executeUpdate()==1){
                ResultSet rs = pstmt.executeQuery();//
                if(rs.next()){
                    i=rs.getInt(1);
                    student6308.setId(i);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(pstmt);
            close(con);
        }
        return i;
    }

    public static void testFind6308() {
        Student6308 student = new Student6308();
        student.setSno("add123");
        student.setSname("数据访问");
        student.setLx1(70);
        student.setLx2(90);
        int id = new Student6308Dao().add6308(student);
        System.out.println("id+" + id);
    }

    public static void testAdd6308() {
        List<Student6308> list = null;
        list = new Student6308Dao().findAll6308();
        for (Student6308 student : list) {
            System.out.println(student);
        }
    }

}
