package concurency.concurrent_collections;

import java.util.concurrent.BlockingQueue;

/**
 * Created by grigort on 7/18/2019.
 */
public class Producer implements Runnable {
    final BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        if (queue == null){
            throw new RuntimeException("Illegal argument exception queue parameter can not be null");
        }
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                String resource = getResource();
                queue.put(resource);
            } catch (InterruptedException e) {
                System.out.println("Producer:  " + Thread.currentThread().getName() + " is interrupted");
                break;
            }
        }

    }

    private String getResource() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Producing Hi!");
        return "Hi";
    }
}
