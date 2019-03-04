package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int max = Math.max(left, right);
        int min = Math.min(left, right);
        List<Integer> result = Stream.iterate(min, n -> n + 1).limit(max - min + 1).collect(Collectors.toList());
        if (left > right) {
            Collections.reverse(result);
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> result = getListByInterval(left, right);
        return result.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(x -> x % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> secondList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return Arrays.stream(firstArray)
                .filter(x -> secondList.contains(x))
                .boxed().collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
