package concurency.single_thread_executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by grigort on 7/4/2019.
 */
public class ZooInfo {
    private static int counter = 0;
    public static void main(String[] args) {
        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {for (int i = 0; i < 100; i++){
                System.out.println("Printing Record " + i);
            }});
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("End");

            Future<?> result = service.submit(() -> {
                for(int i=0; i<500; i++) ZooInfo.counter++;
            });
        }finally {
            if (service != null){
                service.shutdown();
            }
        }
    }
}
