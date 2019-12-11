package io.path_class;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathOperations {
    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("/home/joe/foo");
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

//        Path path1 = Paths.get("/user/.././root", "../kodiacbear.txt");
//        Path path2 = Paths.get("/lion");
//        path1.normalize().relativize(path2);
//        System.out.println(path1);

//        Path path = ____________________;
//        if(Files.isDirectory(path))
//            System.out.println(Files.deleteIfExists(path) ? "Success": "Try Again");


//        Path path = Paths.get("sloth.schedule");
//        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
//        if (attributes.size() > 0 && attributes.creationTime().toMillis() > 0) {
//          //  attributes.setTimes(null, null, null);
//        }
//
//        Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
//        System.out.println(path.subpath(1,3).getName(1).toAbsolutePath());


//        Path path = Paths.get("/animals");
//        boolean myBoolean = Files.walk(path)
//                .filter(p -> Files.isDirectory(p) && !path.equals(p)) // w1
//                .findFirst().isPresent(); // w2
//        System.out.println(myBoolean ? "No Sub-directory": "Has Sub-directory");

//        Path path = Paths.get("C:\\Users\\grigort\\Projects\\java\\ocp-preparation");
//        System.out.println(path.toAbsolutePath());
//        if (Files.isSameFile(path, Paths.get("C:\\Users\\grigort\\Projects\\java\\ocp-preparation"))) {
//            Path path1 = path.resolve("info");
//            System.out.println(path1);
//            Files.createDirectory(path1);
//        }
//
//        Files.lines(path);
//        Files.readAllLines(path);

//        Path path = Paths.get("animals");
//        Files.createDirectory(path);
//        System.out.println(path.toAbsolutePath());
//
//        Files.move(Paths.get("dummy.txt"),path, StandardCopyOption.ATOMIC_MOVE, LinkOption.NOFOLLOW_LINKS);

//        Path path1 = Paths.get("./dummy.txt").normalize(); // k1
//        Path path2 = Paths.get("./dummy.txt").normalize(); // k1
//        Path path3 = Paths.get("animal/dummy.txt");
//
//        System.out.println(path1.toAbsolutePath());
//        System.out.println(path2.toAbsolutePath());
//        Files.copy(path2,path3,StandardCopyOption.COPY_ATTRIBUTES); //k2
//        System.out.println(Files.isSameFile(path1, path2)); //k3

//        Path path = Paths.get("/monkeys");
//        Files.find(path, 0, (p,a) -> a.isSymbolicLink()).map(p -> p.toString()) // y1
//                .collect(Collectors.toList()) // y2
//                .stream() // y3
//                .filter(x -> x.toString().endsWith(".txt")) // y4
//                .forEach(System.out::println);


//        Path path = Paths.get("/squid/food-schedule.csv");
//        Files.lines(path) // r1
//                .flatMap(p -> Stream.of(p.split(","))) // r2
//                .map(s -> s.toUpperCase()) // r3
//                .forEach(System.out::println);

        System.out.println(Paths.get("..").toRealPath().getParent());
//        Files.walk(Paths.get("..").toRealPath().getParent()) // u1
//                .map(p -> p.toAbsolutePath().toString()) // u2
//                .filter(s -> s.endsWith(".java")) // u3
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        System.out.println(Paths.get("aaa").toRealPath());

    }
}
