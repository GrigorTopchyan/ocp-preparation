package concurrency.atomics;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 * Created by grigort on 7/29/2019.
 */
public class App {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(0);
        final long[] value = {0};

        IntStream.iterate(1, i -> 1)
                .limit(100)
                .parallel()
                .forEach(i -> atomicLong.incrementAndGet());

        IntStream.iterate(1, i -> 1)
                .limit(100)
                .parallel()
                .forEach(i -> ++value[0]);

        System.out.println(atomicLong);
        System.out.println(value[0]);
    }
}

