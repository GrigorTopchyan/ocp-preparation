package concurrency.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by grigort on 7/24/2019.
 */
public class LionPenManager {

    private void removeAnimals(){
        System.out.println("Removing animals");
    }

    private void cleanPen(){
        System.out.println("Cleaning the pen");
    }

    private void addAnimals(){
        System.out.println("Adding animals");
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2){

        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c1.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
