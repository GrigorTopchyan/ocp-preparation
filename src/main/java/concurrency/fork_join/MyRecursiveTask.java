package concurrency.fork_join;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Long> {
    private final int from;
    private final int to;

    public MyRecursiveTask(int from, int to) {
        this.from = from;
        this.to = to;
    }


    @Override
    protected Long compute() {
        long result = 0;
        if (to - from < 10_000) {
            for (int index = from; index < to; index++) {
                if (index % 5 == 0 && index % 3 == 0) {
                    result += index;
                }
            }

            return result;
        } else {
            int mid = (from + to) >>> 1;
            MyRecursiveTask left = new MyRecursiveTask(from, mid);
            MyRecursiveTask right = new MyRecursiveTask(mid, to);

            left.fork();
            right.fork();

            return left.join() + right.join();
        }
    }
}
