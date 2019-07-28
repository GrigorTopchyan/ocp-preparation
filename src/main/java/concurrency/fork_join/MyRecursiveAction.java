package concurrency.fork_join;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicLong;

public class MyRecursiveAction extends RecursiveAction {
    private final int from;
    private final int to;
    private AtomicLong result;

    public MyRecursiveAction(int from, int to, AtomicLong result) {
        this.from = from;
        this.to = to;
        this.result = result;
    }

    @Override
    protected void compute() {
        if (to - from < 10_000){
            for(int index = from; index < to; index++){
                if (index % 5 == 0 && index % 3 == 0)
                result.addAndGet(index);
            }
        }else {
            int mid = (to + from) >>> 1;
            MyRecursiveAction left = new MyRecursiveAction(from,mid,result);
            MyRecursiveAction right = new MyRecursiveAction(mid,to,result);
            invokeAll(right,left);

        }
    }
}
