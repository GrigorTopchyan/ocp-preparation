package design_patterns_and_principles.compositon_over_inheritance;

import java.util.*;

public class InstrumentedSet<E> extends ForwardingSet<E> {

    private int addCount = 0;

    public InstrumentedSet(Set<E> set) {
        super(set);
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

class App{
    public static void main(String[] args) {
        InstrumentedSet<String> set = new InstrumentedSet<>(new HashSet<>());
        Set<Integer> items = new InstrumentedSet<>(new TreeSet<>());

//        set.addAll(List.of("A","B","C"));
        System.out.println(set.getAddCount());

    }
}
