package com.thoughtworks.collection.single_link;

public class MyNode<T> {
    private T data;
    private MyNode<T> next;

    public MyNode() {

    }

    public MyNode(T value) {
        this.data = value;
        this.next = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyNode<T> getNext() {
        return this.next;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }
}
