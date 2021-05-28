package java6308.dao;

public class Student6308 {
    private String sname;
    private int id;
    private int lx1;
    private int lx2;
    private String sno;

    public Student6308() {
    }

    public Student6308( String sno,String sname ) {
        this.sno = sno;
        this.sname = sname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLx1() {
        return lx1;
    }

    public void setLx1(int lx1) {
        this.lx1 = lx1;
    }

    public int getLx2() {
        return lx2;
    }

    public void setLx2(int lx2) {
        this.lx2 = lx2;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "Student6308{" +
                "sname='" + sname + '\'' +
                ", id=" + id +
                ", lx1=" + lx1 +
                ", lx2=" + lx2 +
                ", sno='" + sno + '\'' +
                '}';
    }
}
