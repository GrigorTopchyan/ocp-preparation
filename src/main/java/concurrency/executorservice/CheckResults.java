package concurrency.executorservice;

import java.util.concurrent.*;

public class CheckResults {
    private static int counter;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;

        try{
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for(int i=0; i < 500; i++) CheckResults.counter++;
            });

            result.get(10,TimeUnit.SECONDS);
            System.out.println("Reached");

        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (service != null){
                service.shutdown();
            }
        }
    }
}
