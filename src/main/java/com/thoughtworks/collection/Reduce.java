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
        return this.arrayList.stream().filter(x -> x % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int firstEven = this.getFirstEven();
        return this.arrayList.indexOf(firstEven);
    }

    public boolean isEqual(List<Integer> arrayList) {
        boolean isEqual = arrayList.size() != this.arrayList.size() ? false
                : this.arrayList.stream().allMatch(x -> x == arrayList.get(this.arrayList.indexOf(x)));
        return isEqual;
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        List<Integer> oddList = this.arrayList.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        return oddList.get(oddList.size() - 1);
    }

    public int getIndexOfLastOdd() {
        int lastOdd = this.getLastOdd();
        return this.arrayList.indexOf(lastOdd);
    }
}
