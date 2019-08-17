package path_class;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathOperations {
    public static void main(String[] args) {
        Path path = Paths.get("/home/joe/foo");
        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        Path p1 = Paths.get("home");
        Path p3 = Paths.get("home/sally/bar");
        Path p1_to_p3 = p1.relativize(p3);
        Path p3_to_p1 = p3.relativize(p1);
        System.out.println(p1_to_p3);
        System.out.println(p3_to_p1);
    }
}
