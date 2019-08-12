package concurrency.parallel_streams;

import java.util.List;

/**
 * Created by grigort on 7/22/2019.
 */
public class WhaleDataCalculator {

    public int processRecord(int input){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input +1;
    }

    public void processAllData(List<Integer> data){
        data.stream().map(el -> processRecord(el)).count();
    }

    public void processAllDataParralle(List<Integer> data){
        data.parallelStream().map(el -> processRecord(el)).count();
    }

}
