package concurrency.parallel_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by grigort on 7/22/2019.
 */
public class App {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<Integer>();
        for(int i=0; i<4000; i++) data.add(i);

//        WhaleDataCalculator calculator = new WhaleDataCalculator();
//        long start = System.currentTimeMillis();
//        calculator.processAllData(data);
//        long  end = System.currentTimeMillis();
//
//        System.out.println("Task completed in : " + (end - start)/1000 + " seconds");
//
//
//
//        start = System.currentTimeMillis();
//        calculator.processAllDataParralle(data);
//        end = System.currentTimeMillis();
//
//        System.out.println("Parallel Task completed in : " + (end - start)/1000 + " seconds");

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer,List<String>> map = ohMy.collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(map);

    }
}
