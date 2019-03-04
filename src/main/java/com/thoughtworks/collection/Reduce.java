package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream().mapToInt(x -> x).max().getAsInt();
    }

    public double getMinimum() {
        return this.arrayList.stream().mapToInt(x -> x).min().getAsInt();
    }

    public double getAverage() {
        return this.arrayList.stream().mapToInt(x -> x).average().getAsDouble();
    }

    public double getOrderedMedian() {
        List<Integer> orderedList = this.arrayList.stream().sorted().collect(Collectors.toList());
        int size = orderedList.size();
        double median = size % 2 != 0 ? orderedList.get(size / 2) : (orderedList.get(size / 2) + orderedList.get(size / 2 - 1)) * 0.5;
        return median;
    }

    public int getFirstEven() {
        throw new NotImplementedException();
    }

    public int getIndexOfFirstEven() {
        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
