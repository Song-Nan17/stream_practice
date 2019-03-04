package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream().map(x -> x * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return this.array.stream().map(x -> this.letterList.get(x - 1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        int length = letterList.size();
        return this.array.stream()
                .map(x -> x > length ? letterList.get((x - 1) / length - 1) + letterList.get((x - 1) % length) : letterList.get(x - 1))
                .collect(Collectors.toList());

    }

    public List<Integer> sortFromBig() {
        return this.array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        throw new NotImplementedException();
    }
}
