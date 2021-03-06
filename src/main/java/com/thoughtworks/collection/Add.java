package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int smallBorder = Math.min(leftBorder, rightBorder);
        int bigBorder = Math.max(leftBorder, rightBorder);
        int sumOfEvens = Stream.iterate(smallBorder, n -> n + 1).limit(bigBorder - smallBorder + 1)
                .filter(x -> x % 2 == 0).reduce(0, (x, y) -> x + y);
        return sumOfEvens;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int smallBorder = Math.min(leftBorder, rightBorder);
        int bigBorder = Math.max(leftBorder, rightBorder);
        int sumOfEvens = Stream.iterate(smallBorder, n -> n + 1).limit(bigBorder - smallBorder + 1)
                .filter(x -> x % 2 != 0).reduce(0, (x, y) -> x + y);
        return sumOfEvens;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = arrayList.stream().map(x -> x * 3 + 2).reduce(0, (x, y) -> x + y);
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(x -> x % 2 == 0 ? x : x * 3 + 2).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 != 0).map(x -> x * 3 + 5)
                .reduce(0, (x, y) -> x + y);
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> listOfEvenIndex = Stream.iterate(0, i -> i + 1).limit(arrayList.size())
                .filter(i -> i % 2 == 0).map(i -> arrayList.get(i))
                .collect(Collectors.toList());
        int size = listOfEvenIndex.size();
        double median = size % 2 != 0 ? listOfEvenIndex.get(size / 2) : (listOfEvenIndex.get(size / 2 - 1) + listOfEvenIndex.get(size / 2)) / 2.0;
        return median;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        List<Integer> listOfEvenIndex = Stream.iterate(0, i -> i + 1).limit(arrayList.size())
                .filter(i -> i % 2 == 0).map(i -> arrayList.get(i))
                .collect(Collectors.toList());
        double sum = listOfEvenIndex.stream().reduce(0, (x, y) -> x + y);
        return sum / listOfEvenIndex.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(x -> x % 2 == 0).anyMatch(x -> x == specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(x -> x % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream().filter(x -> x % 2 != 0)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        evenList.addAll(oddList);
        return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return Stream.iterate(0, i -> i + 1).limit(arrayList.size() - 1)
                .map(i -> (arrayList.get(i) + arrayList.get(i + 1)) * 3)
                .collect(Collectors.toList());
    }
}
