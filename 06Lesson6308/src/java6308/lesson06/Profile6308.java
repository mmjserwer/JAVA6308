package java6308.lesson06;

import java.io.*;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;

public class Profile6308 {
    public static void main(String[] args) throws IOException {
        Properties tm = new Properties();
        InputStream stream = Profile6308.class.getResourceAsStream("myProFile6308.properties");
        tm.load(stream);
        Set<Object> set = tm.keySet();
        for (Object key : set) {
            Object o = tm.get(key);
            System.out.println(key + "=" + o);
        }

    }
}
