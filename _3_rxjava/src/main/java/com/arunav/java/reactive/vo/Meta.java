
package com.arunav.java.reactive.vo;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Meta {

    @Expose
    private Double chartPreviousClose;
    @Expose
    private String currency;
    @Expose
    private CurrentTradingPeriod currentTradingPeriod;
    @Expose
    private String dataGranularity;
    @Expose
    private String exchangeName;
    @Expose
    private String exchangeTimezoneName;
    @Expose
    private Long firstTradeDate;
    @Expose
    private Long gmtoffset;
    @Expose
    private String instrumentType;
    @Expose
    private Double previousClose;
    @Expose
    private Long priceHint;
    @Expose
    private String range;
    @Expose
    private Double regularMarketPrice;
    @Expose
    private Long regularMarketTime;
    @Expose
    private Long scale;
    @Expose
    private String symbol;
    @Expose
    private String timezone;
    @Expose
    private List<List<TradingPeriod>> tradingPeriods;
    @Expose
    private List<String> validRanges;

    public Double getChartPreviousClose() {
        return chartPreviousClose;
    }

    public void setChartPreviousClose(Double chartPreviousClose) {
        this.chartPreviousClose = chartPreviousClose;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public CurrentTradingPeriod getCurrentTradingPeriod() {
        return currentTradingPeriod;
    }

    public void setCurrentTradingPeriod(CurrentTradingPeriod currentTradingPeriod) {
        this.currentTradingPeriod = currentTradingPeriod;
    }

    public String getDataGranularity() {
        return dataGranularity;
    }

    public void setDataGranularity(String dataGranularity) {
        this.dataGranularity = dataGranularity;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    public void setExchangeTimezoneName(String exchangeTimezoneName) {
        this.exchangeTimezoneName = exchangeTimezoneName;
    }

    public Long getFirstTradeDate() {
        return firstTradeDate;
    }

    public void setFirstTradeDate(Long firstTradeDate) {
        this.firstTradeDate = firstTradeDate;
    }

    public Long getGmtoffset() {
        return gmtoffset;
    }

    public void setGmtoffset(Long gmtoffset) {
        this.gmtoffset = gmtoffset;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public Double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(Double previousClose) {
        this.previousClose = previousClose;
    }

    public Long getPriceHint() {
        return priceHint;
    }

    public void setPriceHint(Long priceHint) {
        this.priceHint = priceHint;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(Double regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public Long getRegularMarketTime() {
        return regularMarketTime;
    }

    public void setRegularMarketTime(Long regularMarketTime) {
        this.regularMarketTime = regularMarketTime;
    }

    public Long getScale() {
        return scale;
    }

    public void setScale(Long scale) {
        this.scale = scale;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<List<TradingPeriod>> getTradingPeriods() {
        return tradingPeriods;
    }

    public void setTradingPeriods(List<List<TradingPeriod>> tradingPeriods) {
        this.tradingPeriods = tradingPeriods;
    }

    public List<String> getValidRanges() {
        return validRanges;
    }

    public void setValidRanges(List<String> validRanges) {
        this.validRanges = validRanges;
    }

}
