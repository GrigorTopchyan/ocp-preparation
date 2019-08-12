package concurrency.persistent_collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by grigort on 7/18/2019.
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3));
        for (Integer el : list){
            System.out.print (el + ", ");
            list.add(el);
        }
        System.out.println();
        System.out.println(list);
    }
}
