package edu.hw3;

import java.util.PriorityQueue;

public class Task6 implements StockMarket {

    PriorityQueue<Stock> fund = new PriorityQueue<>();

    @Override
    public void add(Stock stock) {
        fund.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        fund.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return fund.peek();
    }
}
