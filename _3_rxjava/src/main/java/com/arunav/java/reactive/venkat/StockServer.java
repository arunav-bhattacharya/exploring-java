package com.arunav.java.reactive.venkat;

import java.util.List;
import rx.Observable;
import rx.Subscriber;

class StockServer {
  public static Observable<StockInfo> getFeed(List<String> symbols) {
    return Observable.create(new Observable.OnSubscribe<StockInfo>() {
      @Override
      public void call(Subscriber<? super StockInfo> subscriber) {
        System.out.println("you called...");

        for(String symbol : symbols) {
          subscriber.onNext(StockInfo.fetch(symbol));
        }
      }
    });
  }
}