package concurrency.cyclic_barrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by grigort on 7/24/2019.
 */
public class App {
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManager manager = new LionPenManager();
            CyclicBarrier cb1 = new CyclicBarrier(4);
            CyclicBarrier cb2 = new CyclicBarrier(4,() -> System.out.println("Pen Cleaned!"));

            for (int i =0; i< 4; i++){
                service.submit(() -> manager.performTask(cb1,cb2));
            }
        }finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
