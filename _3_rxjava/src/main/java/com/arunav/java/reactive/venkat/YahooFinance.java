package com.arunav.java.reactive.venkat;

import com.arunav.java.reactive.vo.YahooFinanceResponse;
import com.google.gson.Gson;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class YahooFinance {
    public static double getPriceOrig(final String ticker) {
        try {
            final URL url = new URL("https://query1.finance.yahoo.com/v8/finance/chart/" + ticker);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            YahooFinanceResponse yahooResponse = getYahooFinanceResponse(reader.readLine());
            return yahooResponse.getChart().getResult().get(0).getMeta().getRegularMarketPrice();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static double getPriceMock(final String ticker) {
        return Math.random() * 2000;
    }

    public static double getPrice(final String ticker, boolean useMock) {
        return useMock ? getPriceMock(ticker) : getPriceOrig(ticker);
    }

    private static YahooFinanceResponse getYahooFinanceResponse(String response) {
        Gson gson = new Gson();
        YahooFinanceResponse yahooFinanceResponse = gson.fromJson(response, YahooFinanceResponse.class);
        return yahooFinanceResponse;

    }
}
