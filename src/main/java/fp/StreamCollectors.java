package main.java.fp;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class StreamCollectors {
    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        List<String> resultList = givenList.stream().collect(toList());
        Set<String> resultSet = givenList.stream().collect(toSet());
        Map<String, Integer> resultMap = givenList.stream()
                .collect(toMap(Function.identity(), String::length));
        DoubleSummaryStatistics resultStatistics = givenList.stream()
                .collect(summarizingDouble(String::length));
        Optional<String> resultMax = givenList.stream()
                .collect(maxBy(Comparator.naturalOrder()));

        Map<Integer, Set<String>> resultGroup = givenList.stream()
                .collect(groupingBy(String::length, toSet()));

        Map<Boolean, List<String>> resultPartition = givenList.stream()
                .collect(partitioningBy(s -> s.length() > 2));


    }
}
