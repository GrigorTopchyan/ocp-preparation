package path_class;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathOperations {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/joe/foo");
//        System.out.format("toString: %s%n", path.toString());
//        System.out.format("getFileName: %s%n", path.getFileName());
//        Path root = path.getName(0);
//        System.out.println(root);
//        System.out.format("getNameCount: %d%n", path.getNameCount());
//        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
//        System.out.format("getParent: %s%n", path.getParent());
//        System.out.format("getRoot: %s%n", path.getRoot());

//        Path p1 = Paths.get("home");
//        Path p3 = Paths.get("hoe/sally/bar");
//        System.out.println(p1.toAbsolutePath());

       // System.out.println(p3.getParent().getParent());
//        Path p1_to_p3 = p1.relativize(p3);
//        Path p3_to_p1 = p3.relativize(p1);
//        System.out.println(p1_to_p3);
//        System.out.println(p3_to_p1);

//
//        Path path3 = Paths.get("E:\\data");
//        Path path4 = Paths.get("E:\\user\\home");
//        Path relativePath = path3.relativize(path4);
//        System.out.println(relativePath);
//        System.out.println(path3.resolve(relativePath).normalize());
//        Path realPath = path3.toRealPath();
//        System.out.println(realPath);

        Path path1 = Paths.get("/user/.././root","../kodiacbear.txt");
        Path path2 = Paths.get("/lion");
        path.normalize().relativize(path2);
        System.out.println(path1);
    }
}
