package concurrency.executorservice;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class AmbiguousLambdaSample {
    public static void main(String[] args) {
        useCallable(() -> {throw  new IOException(); });
        // useSupplier(()-> {throw new IOException();}); will not compile
        // use(() -> {throw new IOException();}); //will not compile
        use((Callable<Integer>)() -> {throw new IOException();});
    }

    public static void useCallable(Callable<Integer> expresion){

    }

    public static void useSupplier(Supplier<Integer> expresion){

    }


    public static void use(Callable<Integer> expresion){

    }

    public static void use(Supplier<Integer> expresion){

    }
}
