package concurrency.concurrent_collections;

import java.util.concurrent.BlockingQueue;

/**
 * Created by grigort on 7/18/2019.
 */
public class Consumer implements Runnable{

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        if (queue == null){
            throw new RuntimeException("Illegal argument exception queue parameter can not be null");
        }
        this.queue = queue;
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                String result = queue.take();
               consume(result);
            } catch (InterruptedException e) {
                System.out.println("Consumer " + Thread.currentThread().getName() + " is interrupted");
                break;
            }
        }
    }

    private void consume(String result) throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Consumed " + result);

    }
}
