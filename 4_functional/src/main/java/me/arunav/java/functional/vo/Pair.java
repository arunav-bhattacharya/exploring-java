package me.arunav.java.functional.vo;

public class Pair<T, R> {
    T first;
    R second;

    public Pair(T name, R product) {
        this.first = name;
        this.second = product;
    }

    public T getFirst() {
        return first;
    }

    public R getSecond() {
        return second;
    }
}