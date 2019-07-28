package concurrency.fork_join;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        AtomicLong result = new AtomicLong(0);
        MyRecursiveAction task = new MyRecursiveAction(0,1000_000,result);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(task);
        System.out.println(result);

        MyRecursiveTask recursiveTask = new MyRecursiveTask(0,1000_000);
        recursiveTask.fork();
        System.out.println(recursiveTask.join());

       long result1 =  LongStream.range(0,1000_000)
                .parallel()
                .filter(i -> i%3 == 0)
                .filter(i -> i % 5 == 0)
                .sum();
        System.out.println(result1);

        System.out.println(ArraysUtil.hashCode(new int[]{1,2,3,4,5,6}));
    }
}
