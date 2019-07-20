package concurrency.scheduling_tasks;

import java.util.concurrent.*;

/**
 * Created by grigort on 7/17/2019.
 */
public class ScheduleingTasksDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable command = () -> System.out.println("Hi");
        Callable<String> callable = () -> "JAVA";
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture< String> future = scheduledExecutorService.schedule(callable,2,TimeUnit.MINUTES);
        System.out.println(future.get());
       // scheduledExecutorService.scheduleAtFixedRate(command,0,30, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(command,0,20,TimeUnit.SECONDS);
    }
}
