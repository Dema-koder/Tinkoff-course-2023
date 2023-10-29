package edu.hw3;

import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable<Stock> {
    private int price;

    public Stock(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(@NotNull Stock o) {
        return o.getPrice() - price;
    }
}
