package fp;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class StreamReduce {
    public static void main(String[] args) {
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        empty.reduce(op).ifPresent(System.out::println);
        oneElement.reduce(op).ifPresent(System.out::println);
        threeElements.reduce(op).ifPresent(System.out::println);

        Stream<String> strs = Stream.of("str1","str2","str3");
        System.out.println(strs.reduce(0,(lengths,str) -> lengths + str.length(), Integer::sum));
    }
}
