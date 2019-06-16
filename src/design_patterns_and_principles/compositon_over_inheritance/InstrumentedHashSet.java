package design_patterns_and_principles.compositon_over_inheritance;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet() { }

    public InstrumentedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        this.addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        this.addCount += collection.size();
        return super.addAll(collection);
    }

    public int getAddCount() {
        return addCount;
    }
}

class App1{
    public static void main(String[] args) {
       InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
       set.addAll(List.of("A","B","C"));
        System.out.println(set.getAddCount());
    }
}
