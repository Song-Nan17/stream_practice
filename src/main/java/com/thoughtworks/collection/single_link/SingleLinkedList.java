package com.thoughtworks.collection.single_link;

public class SingleLinkedList<T> implements SingleLink<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public T getHeaderData() {
        return this.head.getData();
    }

    @Override
    public T getTailData() {
        return this.tail.getData();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean deleteFirst() {
        MyNode secondMyNode = head.getNext();
        head = secondMyNode;
        size--;
        return head == secondMyNode;
    }

    @Override
    public boolean deleteLast() {
        MyNode newTail = getNodeByIndex(size - 2);
        newTail.setNext(null);
        tail = newTail;
        size--;
        return tail == newTail;
    }

    @Override
    public void addHeadPointer(T item) {
        if (head == null) {
            head = new MyNode(item);
            tail = head;
        } else {
            MyNode newMyNode = new MyNode(item);
            newMyNode.setNext(head);
            head = newMyNode;
        }
        size++;
    }

    @Override
    public void addTailPointer(T item) {
        if (head == null) {
            head = new MyNode(item);
            tail = head;
        } else {
            MyNode newMyNode = new MyNode(item);
            tail.setNext(newMyNode);
            tail = newMyNode;
        }
        size++;
    }

    @Override
    public T getNode(int index) {
        MyNode<T> result = getNodeByIndex(index);
        return result.getData();
    }

    public MyNode<T> getNodeByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("索引越界！");
        }
        MyNode<T> current = head;
        MyNode<T> result = null;
        for (int i = 0; i < size && current.getNext() != null; i++, current = current.getNext()) {
            if (i == index) {
                result = current;
                break;
            }
        }
        return result;
    }
}
