package concurrency.concurrent_collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by grigort on 7/18/2019.
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        Thread producer1 = new Thread(new Producer(queue));
        Thread producer2 = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer1.start();
        producer2.start();
        consumer.start();

        Thread.sleep(4000);

        producer1.interrupt();
        producer2.interrupt();
        consumer.interrupt();

    }
}
