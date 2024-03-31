package com.arunav.java.reactive.venkat;

import rx.Observable;
import rx.functions.Action1;

import java.util.Arrays;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<String> symbols = Arrays.asList("GOOG", "AAPL", "MSFT", "IBM", "AMZN");

        Observable<StockInfo> feed = StockServer.getFeed(symbols);
        System.out.println("got the observable");

        feed.subscribe(new Action1<StockInfo>() {
            @Override
            public void call(StockInfo stockInfo) {
                System.out.println(stockInfo);
            }
        });
    }
}