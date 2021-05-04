import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class NIO2FileTree6308 {

  private static int countFile=0;
  public static void main(String[] args) throws IOException {
    Path path = Paths.get(".");
    int len = path.getNameCount();
    HashMap<Path, Integer> dirCounts = new HashMap<>();
    FileVisitor<Path> visitor = new FileVisitor<Path>() {
      @Override
      public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("错误：" + exc.getMessage());
        return FileVisitResult.TERMINATE;
      }

      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.printf(getFormat(dir) + "%s\n", "", dir.toRealPath());
        dirCounts.put(dir,0);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.printf(getFormat(dir) + "%s，文件数=%d\n", "", dir.toRealPath(), dirCounts.get(dir));
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        dirCounts.compute(file.getParent(), (k,v)->v+1);
        System.out.println(String.format(getFormat(file) + "%s", "", file.getFileName()));
        return FileVisitResult.CONTINUE;
      }

      private String getFormat(Path path) {
        int n = (path.getNameCount() - len) * 3;
        return n <= 0 ? "%s" : "%" + n + "s";
      }
    };
    Files.walkFileTree(path, visitor);

    dirCounts.forEach((k,v)->countFile=countFile+v);
    System.out.println("子目录数："+dirCounts.size()+"，文件总数："+countFile);
  }
}
