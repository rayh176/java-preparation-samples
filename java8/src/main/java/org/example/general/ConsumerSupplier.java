package org.example.general;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConsumerSupplier {

    public Consumer p = this::persist;

    public Supplier s = this::supply;

    Predicate<Boolean> b = s -> true;

    private Object supply() {
        return new Object();
    }


    private void persist(Object o) {
        System.out.println("persist");
    }

    public void calculate(Object o) {
        p.accept(s.get());
    }

    public void reduce() {
        int [] numbers = new int[5];
        Arrays.stream(numbers).reduce(Integer::max);
    }
}
