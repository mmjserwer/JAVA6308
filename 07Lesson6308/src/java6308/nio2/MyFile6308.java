package java6308.nio2;

public class MyFile6308 implements Comparable<MyFile6308>{
    String name;
    String size;
    String modifiedTime;
    String type;

    public MyFile6308() {
    }

    public MyFile6308(String name, String size, String modifiedTime, String type) {
        this.name = name;
        this.size = size;
        this.modifiedTime = modifiedTime;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public int compareTo(MyFile6308 o) {
        int sort1=o.type.compareTo(this.type);
        int sort2=sort1==0? o.name.compareTo(this.name):sort1;
        return sort2;
    }
}
