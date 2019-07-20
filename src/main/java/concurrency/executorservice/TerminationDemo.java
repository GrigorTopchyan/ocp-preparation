package concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TerminationDemo {
    private static int counter;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for(int i=0; i < 500; i++) TerminationDemo.counter++;
            });
        }finally {
            if (service != null){
                service.shutdown();
            }
        }

        if (service != null){
            service.awaitTermination(1, TimeUnit.SECONDS);
            if (service.isTerminated()){
                System.out.println("All tasks finished");
            }else {
                System.out.println("At least one task is running");
            }
        }


    }
}
