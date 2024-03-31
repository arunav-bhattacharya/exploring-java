
package com.arunav.java.reactive.vo;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Quote {

    @Expose
    private List<Double> close;
    @Expose
    private List<Double> high;
    @Expose
    private List<Double> low;
    @Expose
    private List<Double> open;
    @Expose
    private List<Long> volume;

    public List<Double> getClose() {
        return close;
    }

    public void setClose(List<Double> close) {
        this.close = close;
    }

    public List<Double> getHigh() {
        return high;
    }

    public void setHigh(List<Double> high) {
        this.high = high;
    }

    public List<Double> getLow() {
        return low;
    }

    public void setLow(List<Double> low) {
        this.low = low;
    }

    public List<Double> getOpen() {
        return open;
    }

    public void setOpen(List<Double> open) {
        this.open = open;
    }

    public List<Long> getVolume() {
        return volume;
    }

    public void setVolume(List<Long> volume) {
        this.volume = volume;
    }

}
