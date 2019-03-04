package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        int randomInt = this.random.nextInt(3);
        int length = number / randomInt;
        return Stream.iterate(number - randomInt, n -> n - randomInt).limit(length).collect(Collectors.toList());
    }
}
