package com.haiqalrama.codetest;

import com.fasterxml.jackson.databind.util.ArrayIterator;

import java.util.Arrays;
import java.util.Iterator;

public class IterationTest {
    public static void main(String[] args) {
        System.out.println("Using Iterable");
        Iterable<String> iterable = Arrays.asList("A", "B", "C");
        System.out.println("foreach");
        for (String s : iterable) {
            System.out.println(s);
        }

        System.out.println("while");
        Iterator<String> iteratorFromIterable = iterable.iterator();
        while (iteratorFromIterable.hasNext()) {
            String s = iteratorFromIterable.next();
            System.out.println(s);
        }

        System.out.println("Using Iterator");
        System.out.println("while");
        Iterator<String> iterator = new ArrayIterator<>(new String[]{"A", "B", "C"});
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
    }
}
