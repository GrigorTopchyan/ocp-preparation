package concurrency.fork_join;


//(31*(31*(31*(31*(x0)+x1) + x2) + x3) + x4) = 31 * 31 *(31*x0 + x1) + 31 *(31*x2+x3) + x4 = x0

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysUtil {
    public static int hashCode(int[] arr) {
        final int n = arr.length;
        return IntStream.range(0, n)
                .parallel()
                .map(i ->  pow(31, n-i) * arr[i] )
                .reduce(0, (x,y) -> x + y);
    }

    private static int pow(int m, int n) {
        return (int) Math.pow(m, n);
    }
}
